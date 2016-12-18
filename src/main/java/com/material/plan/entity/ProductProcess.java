package com.material.plan.entity;

import org.apache.ibatis.annotations.Param;

/**
 * Created by Doing on 2016/12/17 0017.
 */
public class ProductProcess {
    private String productName;
    private int processOrder;
    private String blenderName;
    private String materialName;
    private int weight;

    public ProductProcess() {
    }

    public ProductProcess(String productName, int processOrder, String blenderName, String materialName, int weight) {
        this.productName = productName;
        this.processOrder = processOrder;
        this.blenderName = blenderName;
        this.materialName = materialName;
        this.weight = weight;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProcessOrder() {
        return processOrder;
    }

    public void setProcessOrder(int processOrder) {
        this.processOrder = processOrder;
    }

    public String getBlenderName() {
        return blenderName;
    }

    public void setBlenderName(String blenderName) {
        this.blenderName = blenderName;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "ProductProcess{" +
                "productName='" + productName + '\'' +
                ", processOrder=" + processOrder +
                ", blenderName='" + blenderName + '\'' +
                ", materialName='" + materialName + '\'' +
                ", weight=" + weight +
                '}';
    }
}
