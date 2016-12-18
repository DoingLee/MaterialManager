package com.material.order.dto;

/**
 * Created by Doing on 2016/12/18 0018.
 */

/**
 *订单所需原料信息类
 */
public class OrderMaterialDto {
    private String materialName;
    private int weight;
    private String location;

    public OrderMaterialDto() {
    }

    public OrderMaterialDto(String materialName, int weight, String location) {
        this.materialName = materialName;
        this.weight = weight;
        this.location = location;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "OrderMaterialDto{" +
                "materialName='" + materialName + '\'' +
                ", weight=" + weight +
                ", location='" + location + '\'' +
                '}';
    }
}
