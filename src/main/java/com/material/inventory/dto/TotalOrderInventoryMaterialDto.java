package com.material.inventory.dto;

/**
 * Created by Doing on 2016/12/18 0018.
 */

/**
 * 订单总原料+仓库总原料信息类
 */
public class TotalOrderInventoryMaterialDto {
    private String materialName;
    private int totalOrderNeedWeight;
    private int totalInventoryWeight;
    private boolean isLack;

    public TotalOrderInventoryMaterialDto() {
    }

    public TotalOrderInventoryMaterialDto(String materialName) {
        this.materialName = materialName;
    }

    public TotalOrderInventoryMaterialDto(String materialName, int totalOrderNeedWeight, int totalInventoryWeight, boolean isLack) {
        this.materialName = materialName;
        this.totalOrderNeedWeight = totalOrderNeedWeight;
        this.totalInventoryWeight = totalInventoryWeight;
        this.isLack = isLack;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public int getTotalOrderNeedWeight() {
        return totalOrderNeedWeight;
    }

    public void setTotalOrderNeedWeight(int totalOrderNeedWeight) {
        this.totalOrderNeedWeight = totalOrderNeedWeight;
    }

    public int getTotalInventoryWeight() {
        return totalInventoryWeight;
    }

    public void setTotalInventoryWeight(int totalInventoryWeight) {
        this.totalInventoryWeight = totalInventoryWeight;
    }

    public boolean isLack() {
        return isLack;
    }

    public void setIsLack(boolean isLack) {
        this.isLack = isLack;
    }

    @Override
    public String toString() {
        return "TotalOrderInventoryMaterialDto{" +
                "materialName='" + materialName + '\'' +
                ", totalOrderNeedWeight=" + totalOrderNeedWeight +
                ", totalInventoryWeight=" + totalInventoryWeight +
                ", isLack=" + isLack +
                '}';
    }
}
