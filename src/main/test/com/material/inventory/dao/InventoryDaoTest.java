package com.material.inventory.dao;

import com.material.inventory.entity.InventoryMaterial;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Doing on 2016/12/18 0018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/application.xml"})
public class InventoryDaoTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    InventoryDao inventoryDao;

    @Test
    public void testAddInventoryMaterial() throws Exception {
        InventoryMaterial inventoryMaterial = new InventoryMaterial("m0", "H柜3层", 1028);
        int r = inventoryDao.addInventoryMaterial(inventoryMaterial);
        logger.debug("结果：" + r);
    }

    @Test
    public void testaddInventoryMaterialWeight()   {
        int r = inventoryDao.addInventoryMaterialWeight("material1", 1000);
        logger.debug("结果：" + r);
    }

    @Test
    public void testUpdateInventoryMaterial() throws Exception {
        InventoryMaterial inventoryMaterial = new InventoryMaterial("m0", "H柜3层", 1333);
        int r = inventoryDao.updateInventoryMaterial(inventoryMaterial);
        logger.debug("结果：" + r);
    }

    @Test
    public void testGetInventoryMaterial() throws Exception {
        InventoryMaterial inventoryMaterial = inventoryDao.getInventoryMaterial("m0");
        logger.debug("结果：" + inventoryMaterial.toString());
    }

    @Test
    public void testDeleteInventoryMaterial() throws Exception {
        int r = inventoryDao.deleteInventoryMaterial("m0");
        logger.debug("结果：" + r);
    }
}