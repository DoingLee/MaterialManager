package com.material.order_track.entity;

import com.sun.istack.internal.Nullable;

/**
 * Created by Doing on 2016/12/18 0018.
 */
public class OrderTrackMsg {
    private String orderId;
    private String userName;
    private String action;
    @Nullable private String actionTime;

    public OrderTrackMsg() {
    }

    public OrderTrackMsg(String orderId, String userName, String action) {
        this.orderId = orderId;
        this.userName = userName;
        this.action = action;
    }

    public OrderTrackMsg(String orderId, String userName, String action, String actionTime) {
        this.orderId = orderId;
        this.userName = userName;
        this.action = action;
        this.actionTime = actionTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
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
