package com.material.plan.entity;

/**
 * Created by Doing on 2016/12/17 0017.
 */
public class ProductMaterial {

    private int productId;
    private String materialName;
    private int weight;

    public ProductMaterial() {
    }

    public ProductMaterial(int productId, String materialName, int weight) {
        this.productId = productId;
        this.materialName = materialName;
        this.weight = weight;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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
        return "ProductMaterial{" +
                "productId=" + productId +
                ", materialName='" + materialName + '\'' +
                ", weight=" + weight +
                '}';
    }
}
