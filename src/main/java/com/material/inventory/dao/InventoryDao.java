package com.material.inventory.dao;

import com.material.inventory.entity.InventoryMaterial;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Doing on 2016/12/18 0018.
 */
public interface InventoryDao {

    int addInventoryMaterial(InventoryMaterial inventoryMaterial);

    int addInventoryMaterialWeight(@Param("materialName")String materialName, @Param("weight")int weight);

    int updateInventoryMaterial(InventoryMaterial inventoryMaterial);

    InventoryMaterial getInventoryMaterial(String materialName);

    int deleteInventoryMaterial(String materialName);
}
