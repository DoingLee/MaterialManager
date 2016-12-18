package com.material.inventory.dao;

import com.material.inventory.entity.InventoryMaterial;

/**
 * Created by Doing on 2016/12/18 0018.
 */
public interface InventoryDao {

    int addInventoryMaterial(InventoryMaterial inventoryMaterial);

    int updateInventoryMaterial(InventoryMaterial inventoryMaterial);

    InventoryMaterial getInventoryMaterial(String materialName);

    int deleteInventoryMaterial(String materialName);
}
