package com.material.order_track.entity;

import com.sun.istack.internal.Nullable;

/**
 * Created by Doing on 2016/12/18 0018.
 */
public class OrderTrackMsg {
    private int orderId;
    private String userName;
    private String action;
    @Nullable private String actionTime;

    public OrderTrackMsg() {
    }

    public OrderTrackMsg(int orderId, String userName, String action) {
        this.orderId = orderId;
        this.userName = userName;
        this.action = action;
    }

    public OrderTrackMsg(int orderId, String userName, String action, String actionTime) {
        this.orderId = orderId;
        this.userName = userName;
        this.action = action;
        this.actionTime = actionTime;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getActionTime() {
        return actionTime;
    }

    public void setActionTime(String actionTime) {
        this.actionTime = actionTime;
    }

}
