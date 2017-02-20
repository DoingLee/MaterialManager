package com.material.weight;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Doing on 2017/1/13 0013.
 */
public class WeightController {

    private static final Logger logger = LoggerFactory.getLogger(WeightController.class);
    private static final String TAG = "==============";

    private static final int WEIGHTER_LISTEN_PORT = 10001; //称重器监听端口
    private static final int MOBILE_LISTEN_PORT = 10002; //移动终端监听端口

    private HashMap<String, Socket> weighters;
//    private HashMap<String, Socket> mobiles;

    private ExecutorService cachedThreadPool;

    public WeightController() {
        logger.info(TAG + "WeightController自动启动");
        init();
        listen();
    }

    private void init() {
        weighters = new HashMap<String, Socket>();
//        mobiles = new HashMap<String, Socket>();
        cachedThreadPool = Executors.newCachedThreadPool();
    }

    public void listen() {
        new WeighterSocketListenThread().start();
        new MobileSocketListenThread().start();
    }


    /**
     * 监听称重器连接请求
     */
    class WeighterSocketListenThread extends Thread {

        ServerSocket server;

        public WeighterSocketListenThread() {
            try {
//                server = new ServerSocket(WEIGHTER_LISTEN_PORT);
                server = new ServerSocket();
                server.setReuseAddress(true); //使得socket关闭后可以跳过time_wait，端口可以马上重用。（必须在bind前调用）
                server.bind(new InetSocketAddress(WEIGHTER_LISTEN_PORT));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (true) {
                try {
                    logger.info(TAG + "开始监听称重器连接请求");
                    Socket weighterSocket = server.accept();    // 该方法会阻塞直至有连接。每有一个新连接都会产生一个new Socket
                    logger.info(TAG + "称重器连接成功");
                    cachedThreadPool.execute(new WeighterSocketThread(weighterSocket));//交给称重器socket处理线程进一步处理
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 监听移动终端连接请求
     */
    class MobileSocketListenThread extends Thread {

        private ServerSocket server;

        public MobileSocketListenThread() {
            try {
//                server = new ServerSocket(MOBILE_LISTEN_PORT);
                server = new ServerSocket();
                server.setReuseAddress(true);
                server.bind(new InetSocketAddress(MOBILE_LISTEN_PORT));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (true) {
                try {
                    logger.info(TAG + "开始监听移动终端连接请求");
                    Socket socket = server.accept();    // 该方法会阻塞直至有连接。每有一个新连接都会产生一个new Socket
                    logger.info(TAG + "移动终端连接成功");
                    cachedThreadPool.execute(new MobileSocketThread(socket));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 称重器socket处理线程
     * 作用： 登记称重器名称，把称重器socket放入HashMap
     */
    private class WeighterSocketThread extends Thread {
        private Socket weighterSocket;

        public WeighterSocketThread(Socket weighterSocket) {
            this.weighterSocket = weighterSocket;
        }

        @Override
        public void run() {
            try {
                logger.info(TAG + "阻塞等待称重器登记信息");
                InputStream inputStream = weighterSocket.getInputStream(); //阻塞，直到有输入
                String msg = inputStreamToString(inputStream);
                logger.info(TAG + "称重器信息：" + msg);
                String weighterName = parseWeighterName(msg);
                weighters.put(weighterName, weighterSocket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String inputStreamToString(InputStream inputStream) {
            StringBuilder sb = new StringBuilder();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//                String str = bufferedReader.readLine();
//                while (str != null && !str.equals("")) {
//                    sb.append(str);
//                    str = bufferedReader.readLine();
//                }
                boolean flag = true;
                while(flag){
                    //接收从客户端发送过来的数据
                    String str =  bufferedReader.readLine();
                    if(str == null || "".equals(str)){
                        flag = false;
                    }else{
                        if("end".equals(str)){
                            flag = false;
                        }else{
                            sb.append(str);
                        }
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return sb.toString();
        }

        private String parseWeighterName(String json) {
            JSONObject jsonObject = new JSONObject(json);
            String weighterName = jsonObject.getString("weighterName");
            return weighterName;
        }

    }

    /**
     * 移动终端socket处理线程
     * 作用：
     * 1、等待移动终端发送称重信息，解析称重质量、称重器名称；
     * 2、从HashMap找出称重器命令称重，等待称重器返回实际称重质量
     * 3、比较是否在误差范围内，返回称重结果
     */
    class MobileSocketThread extends Thread {
        Socket mobileSocket;

        public MobileSocketThread(Socket mobileSocket) {
            this.mobileSocket = mobileSocket;
        }

        @Override
        public void run() {
            try {
                logger.info(TAG + "阻塞等待移动终端请求称重信息");
                //阻塞等待移动端称重请求信息
                InputStream inputStream = mobileSocket.getInputStream();
                String msg = inputStreamToString(inputStream);
                logger.info("移动终端信息：" + msg);
                //解析称重器名字，待称重质量
                JSONObject jsonObject = new JSONObject(msg);
                int requireWeight = jsonObject.getInt("weight");
                String weighterName = jsonObject.getString("weighterName");
                //开始称重
                handleWeight(requireWeight, weighterName, mobileSocket);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        private String inputStreamToString(InputStream inputStream) {
            StringBuilder sb = new StringBuilder();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//                String str = bufferedReader.readLine();
//                while (str != null && !str.equals("")) {
//                    sb.append(str);
//                    str = bufferedReader.readLine();
//                }
                boolean flag = true;
                while(flag){
                    //接收从客户端发送过来的数据
                    String str =  bufferedReader.readLine();
                    if(str == null || "".equals(str)){
                        flag = false;
                    }else{
                        if("end".equals(str)){
                            flag = false;
                        }else{
                            sb.append(str);
                        }
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return sb.toString();
        }

        //称重处理：
//        1、从HashMap找出称重器命令称重，等待称重器返回实际称重质量
//        2、比较是否在误差范围内，返回称重结果
        private void handleWeight(int requireWeight, String weighterName, Socket appSocket) {
            String result = null;

            Socket weighterSocket = weighters.get(weighterName);
            if (weighterSocket == null) { //找不到称重器
                logger.info(TAG + "称重器尚未连接");
                result = "{" +
                        "success:false," +
                        "msg:\"weighter unConnected!\"" +
                        "}";
            } else { //找到称重器，开始称重
                try {
                    //往称重器发送称重信息
                    logger.info(TAG + "往称重器发送称重请求");
                    OutputStream outputStream = weighterSocket.getOutputStream();
                    String weightMsg = "{weight:" + requireWeight + "}";
                    PrintStream out = new PrintStream(outputStream);
                    out.println(weightMsg);
                    out.println("end");
                    out.flush();
//                    outputStream.write(weightMsg.getBytes(Charset.forName("UTF-8")));
//                    outputStream.flush();

                    //阻塞等待称重器实际称重返回信息
                    logger.info(TAG + "阻塞等待称重器称重信息");
                    InputStream inputStream1 = weighterSocket.getInputStream();
                    String msg1 = inputStreamToString(inputStream1);
                    logger.info(TAG + "称重器实际称重信息：" + msg1);
                    JSONObject jsonObject = new JSONObject(msg1);
                    double realWeight = jsonObject.getDouble("realWeight");
                    //判断是否称重正确
                    if (Math.abs(realWeight - requireWeight) > 0.1) { //称重错误
                        result = "{success:false,msg:\"wrong weight!\"}";
                    } else { //称重正确
                        result = "{success:true,realWeight:" + realWeight + "}";
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            //发送结果到移动端
            try {
                if (result == null) {
                    result = "{success:false,msg:\"server error!\"}";
                }
                logger.info(TAG + "发送称重结果到移动端：" + result);

                OutputStream outputStream = appSocket.getOutputStream();
                PrintStream out = new PrintStream(outputStream);
                out.println(result);
                out.println("end");
                out.flush();
//                        outputStream.write(result.getBytes(Charset.forName("UTF-8")));
//                        outputStream.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
