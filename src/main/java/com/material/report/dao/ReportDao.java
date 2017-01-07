package com.material.report.dao;

import com.material.report.entity.Report;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Doing on 2017/1/7 0007.
 */
public interface ReportDao {

    /**
     * 获取从fromDate到toDate的所有报告信息
     * @param fromDate 开始时期（包含）
     * @param toDate 结束日期（包含）
     * @return
     */
    List<Report> getReport(@Param("fromDate")String fromDate, @Param("toDate")String toDate);

    /**
     * 插入新行
     * @param report
     * @return
     */
    int insertRow(Report report);

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
