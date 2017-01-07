package com.material.order_track.service;

import com.material.order_track.dao.OrderTrackDao;
import com.material.order_track.entity.OrderTrackMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Doing on 2016/12/18 0018.
 */
@Service
public class OrderTrackService implements IOrderTrackService {

    @Autowired
    OrderTrackDao orderTrackDao;

    @Override
    public int addOrderTrack(OrderTrackMsg orderTrackMsg) {
        return orderTrackDao.addOrderTrack(orderTrackMsg);
    }

    @Override
    public List<OrderTrackMsg> getOrderTrack(int orderId) {
        return orderTrackDao.getOrderTrack(orderId);
    }

    @Override
    public String getBeginDateTime(String orderId, String actionRegex) {
        return orderTrackDao.getBeginDateTime(orderId,actionRegex);
    }

}
