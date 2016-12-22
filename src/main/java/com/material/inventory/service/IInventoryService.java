package com.material.inventory.service;

import com.material.inventory.entity.InventoryMaterial;

/**
 * Created by Doing on 2016/12/18 0018.
 */
public interface IInventoryService {

    int addInventoryMaterial(InventoryMaterial inventoryMaterial);

    int addInventoryMaterialWeight(String materialName, int weight);

    int updateInventoryMaterial(InventoryMaterial inventoryMaterial);

    InventoryMaterial getInventoryMaterial(String materialName);

    int deleteInventoryMaterial(String materialName);

}
