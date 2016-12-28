package com.material.plan.service;

import com.material.plan.dto.SingleProcessDto;
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
public class PlanServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    IPlanService planService;

    @Test
    public void testAddSingleProcess() throws Exception {
        SingleProcessDto singleProcessDto = new SingleProcessDto("product3", "新产品", 1, "material1", "blender1", 38);
        int r = planService.addSingleProcess(singleProcessDto);
        logger.debug("结果：" + r);
    }

    @Test
    public void testUpdateSingleProcess() throws Exception {
        SingleProcessDto singleProcessDto = new SingleProcessDto("product3", "新产品", 1, "material1", "blender1", 119);
        int r = planService.updateSingleProcess(singleProcessDto);
        logger.debug("结果：" + r);
    }

    @Test
    public void testDeleteSingleProcess() throws Exception {
        int r = planService.deleteSingleProcess("product3", 1);
        logger.debug("结果：" + r);
    }

    @Test
    public void testDeleteProduct() throws Exception {
        int r = planService.deleteProduct("product3");
        logger.debug("结果：" + r);
    }

    @Test
    public void testGetProductProcess() throws Exception {
        List<SingleProcessDto> singleProcessDtos = planService.getProductProcess("天麻多糖润肤霜");
        for (int i = 0 ; i < singleProcessDtos.size(); i++){
            logger.debug(singleProcessDtos.get(i).toString());
        }
    }
}