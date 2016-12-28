package com.material.plan.dto;

import java.util.List;

/**
 * Created by Doing on 2016/12/17 0017.
 */
public class SingleProcessDto {

    private String productName;
    private String description;
    private int processOrder;
    private String materialName;
    private String blenderName;
    private int weight;
    private String location;

    public SingleProcessDto() {
    }

    public SingleProcessDto(String productName) {
        this.productName = productName;
    }

    public SingleProcessDto(String productName, String description) {
        this.productName = productName;
        this.description = description;
    }

    public SingleProcessDto(String productName, String description, int processOrder, String materialName, String blenderName, int weight) {
        this.productName = productName;
        this.description = description;
        this.processOrder = processOrder;
        this.materialName = materialName;
        this.blenderName = blenderName;
        this.weight = weight;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProcessOrder() {
        return processOrder;
    }

    public void setProcessOrder(int processOrder) {
        this.processOrder = processOrder;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getBlenderName() {
        return blenderName;
    }

    public void setBlenderName(String blenderName) {
        this.blenderName = blenderName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    @Override
    public String toString() {
        return "SingleProcessDto{" +
                "productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", processOrder=" + processOrder +
                ", materialName='" + materialName + '\'' +
                ", blenderName='" + blenderName + '\'' +
                ", weight=" + weight +
                ", location='" + location + '\'' +
                '}';
    }
}
