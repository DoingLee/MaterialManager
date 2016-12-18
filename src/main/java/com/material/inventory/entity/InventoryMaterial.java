package com.material.inventory.entity;

/**
 * Created by Doing on 2016/12/18 0018.
 */
public class InventoryMaterial {
    private String materialName;
    private String location;
    private int totalWeight;

    public InventoryMaterial() {
    }

    public InventoryMaterial(String materialName, String location, int totalWeight) {
        this.materialName = materialName;
        this.location = location;
        this.totalWeight = totalWeight;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(int totalWeight) {
        this.totalWeight = totalWeight;
    }


    @Override
    public String toString() {
        return "InventoryMaterial{" +
                "materialName='" + materialName + '\'' +
                ", location='" + location + '\'' +
                ", totalWeight=" + totalWeight +
                '}';
    }
}
