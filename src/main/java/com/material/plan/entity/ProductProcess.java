package com.material.plan.entity;

/**
 * Created by Doing on 2016/12/17 0017.
 */
public class ProductProcess {
    private int productId;
    private int processOrder;
    private String materialName;
    private String blenderName;

    public ProductProcess() {
    }

    public ProductProcess(int productId, int processOrder, String materialName, String blenderName) {
        this.productId = productId;
        this.processOrder = processOrder;
        this.materialName = materialName;
        this.blenderName = blenderName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    @Override
    public String toString() {
        return "ProductProcess{" +
                "productId=" + productId +
                ", processOrder=" + processOrder +
                ", materialName='" + materialName + '\'' +
                ", blenderName='" + blenderName + '\'' +
                '}';
    }
}
