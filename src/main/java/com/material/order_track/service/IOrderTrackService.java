package com.material.order_track.service;

import com.material.order_track.entity.OrderTrackMsg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Doing on 2016/12/18 0018.
 */
public interface IOrderTrackService {

    int addOrderTrack(OrderTrackMsg orderTrackMsg);

    List<OrderTrackMsg> getOrderTrack(String orderId);

    /**
     * 根据开始动作关键词获取 最新的开始动作时间
     * @param orderId 订单号
     * @param actionRegex 开始动作的正则表达式（SQL语句正则表达式）
     * @return 最新的开始动作时间(yy-MM-dd hh-mm-ss)
     */
    String getBeginDateTime(String orderId, String actionRegex);
}
