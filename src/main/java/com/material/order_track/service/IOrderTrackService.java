package com.material.order_track.service;

import com.material.order_track.entity.OrderTrackMsg;

import java.util.List;

/**
 * Created by Doing on 2016/12/18 0018.
 */
public interface IOrderTrackService {

    int addOrderTrack(OrderTrackMsg orderTrackMsg);

    List<OrderTrackMsg> getOrderTrack(int orderId);
}
