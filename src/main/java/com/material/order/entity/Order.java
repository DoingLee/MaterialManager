package com.material.order.entity;

/**
 * Created by Doing on 2016/12/18 0018.
 */
public class Order {
    private String productName;
    private int count;
    private String status;
    private String clientName;
    private String clientTel;

    private String orderId;

    public Order() {
    }

    public Order(String productName, int count, String status, String clientName, String clientTel) {
        this.productName = productName;
        this.count = count;
        this.status = status;
        this.clientName = clientName;
        this.clientTel = clientTel;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientTel() {
        return clientTel;
    }

    public void setClientTel(String clientTel) {
        this.clientTel = clientTel;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "productName='" + productName + '\'' +
                ", count=" + count +
                ", status='" + status + '\'' +
                ", clientName='" + clientName + '\'' +
                ", clientTel='" + clientTel + '\'' +
                ", orderId=" + orderId +
                '}';
    }
}
