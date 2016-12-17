package com.material.plan.dto;

import java.util.List;

/**
 * Created by Doing on 2016/12/17 0017.
 */
public class CompleteProcessDto {

    private String productName;
    private String description;
    private List<Integer> processOrders;
    private List<String> materialNames;
    private List<String> blenderNames;
    private List<Integer> weights;

    public CompleteProcessDto() {
    }

    public CompleteProcessDto(String productName) {
        this.productName = productName;
    }

    public CompleteProcessDto(String productName, String description) {
        this.productName = productName;
        this.description = description;
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

    public List<Integer> getProcessOrders() {
        return processOrders;
    }

    public void setProcessOrders(List<Integer> processOrders) {
        this.processOrders = processOrders;
    }

    public List<String> getMaterialNames() {
        return materialNames;
    }

    public void setMaterialNames(List<String> materialNames) {
        this.materialNames = materialNames;
    }

    public List<String> getBlenderNames() {
        return blenderNames;
    }

    public void setBlenderNames(List<String> blenderNames) {
        this.blenderNames = blenderNames;
    }

    public List<Integer> getWeights() {
        return weights;
    }

    public void setWeights(List<Integer> weights) {
        this.weights = weights;
    }
}
