package com.material.report.service;

import com.material.report.entity.Report;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Doing on 2017/1/7 0007.
 */
public interface IReportService {
    /**
     * 获取从fromDate到toDate的所有报告信息
     * @param fromDate 开始时期（包含）yyyy-MM-dd格式
     * @param toDate 结束日期（包含）yyyy-MM-dd格式
     * @return
     */
    List<Report> getReport(String fromDate, String toDate);

    /**
     * 获取从fromDate到toDate的所有报告的汇总统计信息
     * @param fromDate 开始时期（包含）yyyy-MM-dd格式
     * @param toDate 结束日期（包含）yyyy-MM-dd格式
     * @return
     */
    Report getSumReport(String fromDate, String toDate);

    /**
     *  更新 完成订单数 和 平均完成订单时间（秒）
     * @param sec
     * @return
     */
    int addOrder(int sec);

    /**
     * 更新 完成取料单据数 和 平均完成订单取料时间（秒）
     * @param sec
     * @return
     */
    int addCollect(int sec);

    /**
     * 更新 完成单个取料动作数 平均完成单个取料动作时间（秒）
     * @param sec
     * @return
     */
    int addSingleCollect(int sec);

    /**
     * 更新 完成复核单据数 平均完成订单成功复核时间（秒）
     * @param sec
     * @return
     */
    int addSuccessRecheck(int sec);

    /**
     * 更新 完成单个复核动作数 平均完成单个复核动作时间（秒）
     * @param sec
     * @return
     */
    int addSingleRecheck(int sec);

    /**
     * 更新 完成投料单据数 平均完成订单投料时间（秒）
     * @param sec
     * @return
     */
    int addProduce(int sec);

    /**
     * 更新 完成单个投料动作数 平均完成单个投料动作时间（秒）
     * @param sec
     * @return
     */
    int addSingleProduce(int sec);

    /**
     * 更新 挂单数
     * @return
     */
    int addHangUp();
}
