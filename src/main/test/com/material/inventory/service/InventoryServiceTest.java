package com.material.inventory.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Doing on 2016/12/22 0022.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/application.xml"})
public class InventoryServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    InventoryService inventoryService;

    @Test
    public void testAddInventoryMaterial() throws Exception {

    }

    @Test
    public void testAddInventoryMaterialWeight() throws Exception {

    }

    @Test
    public void testUpdateInventoryMaterial() throws Exception {

    }

    @Test
    public void testGetInventoryMaterial() throws Exception {

    }

    @Test
    public void testDeleteInventoryMaterial() throws Exception {

    }
}