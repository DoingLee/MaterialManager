package com.material.inventory.service;

import com.material.inventory.dto.TotalOrderInventoryMaterialDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Doing on 2016/12/18 0018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/application.xml"})
public class MaterialLackServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MaterialLackService materialLackService;

    @Test
    public void testCompareAllOrderMaterialWeight() throws Exception {
        List<TotalOrderInventoryMaterialDto> totalOrderInventoryMaterialDtos = materialLackService.compareAllOrderMaterialWeight();
        for (TotalOrderInventoryMaterialDto totalOrderInventoryMaterialDto : totalOrderInventoryMaterialDtos){
            logger.debug("结果：" + totalOrderInventoryMaterialDto.toString());
        }
    }
}