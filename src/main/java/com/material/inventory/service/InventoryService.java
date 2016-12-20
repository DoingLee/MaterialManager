package com.material.inventory.service;

import com.material.inventory.dao.InventoryDao;
import com.material.inventory.entity.InventoryMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Doing on 2016/12/18 0018.
 */
@Service
public class InventoryService implements IInventoryService {

    @Autowired
    private InventoryDao inventoryDao;

    public InventoryService() {
    }

    @Override
    public int addInventoryMaterial(InventoryMaterial inventoryMaterial) {
        return inventoryDao.addInventoryMaterial(inventoryMaterial);
    }

    @Override
    public int updateInventoryMaterial(InventoryMaterial inventoryMaterial) {
        return inventoryDao.updateInventoryMaterial(inventoryMaterial);
    }

    @Override
    public InventoryMaterial getInventoryMaterial(String materialName) {
        return inventoryDao.getInventoryMaterial(materialName);
    }

    @Override
    public int deleteInventoryMaterial(String materialName) {
        return inventoryDao.deleteInventoryMaterial(materialName);
    }
}
