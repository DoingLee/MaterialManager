package com.material.order.entity;

/**
 * Created by Doing on 2016/12/18 0018.
 */
public class UnsolvedOrderProductCount {
    private String productName;
    private int count;

    public UnsolvedOrderProductCount() {
    }

    public UnsolvedOrderProductCount(String productName, int count) {
        this.productName = productName;
        this.count = count;
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

}
