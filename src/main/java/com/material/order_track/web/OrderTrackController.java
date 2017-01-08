package com.material.order_track.web;

import com.material.order.service.IOrderService;
import com.material.order_track.entity.OrderTrackMsg;
import com.material.order_track.service.IOrderTrackService;
import com.material.report.service.IReportService;
import com.material.user.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.Constants;
import utils.Result;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Doing on 2016/12/18 0018.
 */
@Controller
@RequestMapping("/order_track")
public class OrderTrackController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String TAG = OrderTrackController.class.getSimpleName() + " ====================== ";

    @Autowired
    private IOrderTrackService orderTrackService;
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IReportService reportService;

    @RequestMapping(value = "/",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<String> addOrderTrack(final OrderTrackMsg orderTrackMsg){
        int result = orderTrackService.addOrderTrack(orderTrackMsg);

        if (orderTrackMsg.getAction().equals("完成订单")) {
            orderService.updateOrderStatus(orderTrackMsg.getOrderId(), Constants.ORDER_STATUS_SOLED);
        }

        //开线程计算
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    handleReport(orderTrackMsg.getOrderId(), orderTrackMsg.getAction());
                } catch (ParseException e) {
                    logger.debug(TAG + "日期解析出错！！");
                    e.printStackTrace();
                }
            }
        });

        if (result == 1){
            String msg = "添加成功！";
            return new Result<String>(true, msg);
        }else {
            String msg = "添加失败！";
            return new Result<String>(false, msg);
        }
    }

    @RequestMapping(value = "/{orderId}/",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<List<OrderTrackMsg>> getOrderTrack(@PathVariable("orderId")String orderId){
        List<OrderTrackMsg> result = orderTrackService.getOrderTrack(orderId);
        if (result != null){
            return new Result<List<OrderTrackMsg>>(true, result);
        }else {
            return new Result<List<OrderTrackMsg>>(false, null);
        }
    }

    //记录
    private void handleReport(String orderId, String action) throws ParseException {

        String actionType = action.substring(0, 4); //前四个文字

        if (actionType.equals("完成订单")) {
            String beginActionRegex = "开始订单";
            int sec = calculateTime(orderId, beginActionRegex);
            reportService.addOrder((int) sec);
        }else if (actionType.equals("完成取料")) {
            String beginActionRegex = "开始取料";
            int sec = calculateTime(orderId, beginActionRegex);
            reportService.addCollect((int) sec);
        }else if (actionType.equals("取料完成")) {
            String beginActionRegex = "取料开始";
            int sec = calculateTime(orderId, beginActionRegex);
            reportService.addSingleCollect((int) sec);
        }else if (actionType.equals("完成复核")) {
            String beginActionRegex = "开始复核";
            int sec = calculateTime(orderId, beginActionRegex);
            reportService.addSuccessRecheck((int) sec);
        }else if (actionType.equals("复核完成")) {
            String beginActionRegex = "复核开始";
            int sec = calculateTime(orderId, beginActionRegex);
            reportService.addSingleRecheck((int) sec);
        }else if (actionType.equals("完成投料")) {
            String beginActionRegex = "开始投料";
            int sec = calculateTime(orderId, beginActionRegex);
            reportService.addProduce((int) sec);
        }else if (actionType.equals("投料完成")) {
            String beginActionRegex = "投料开始";
            int sec = calculateTime(orderId, beginActionRegex);
            reportService.addSingleProduce((int) sec);
        }else if (actionType.equals("复核挂单")) {
            reportService.addHangUp();
        }
    }

    //计算间隔时间
    private int calculateTime(String orderId, String beginActionRegex) throws ParseException {
        String beginDateTimeString = orderTrackService.getBeginDateTime(orderId, "^" + beginActionRegex); //开始时间
        String endDateTimeString = getCurrentTime(); //结束时间

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date beginDateTime = sdf.parse(beginDateTimeString);
        Date endDateTime = sdf.parse(endDateTimeString);
        long sec = ( endDateTime.getTime() - beginDateTime.getTime() ) / 1000; //间隔时间（秒）
        return (int)sec;
    }

    private String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateString = sdf.format(new Date(System.currentTimeMillis()));
        return dateString;
    }
}
