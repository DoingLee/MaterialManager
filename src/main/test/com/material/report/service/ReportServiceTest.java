package com.material.report.service;

import com.material.report.dao.ReportDao;
import com.material.report.entity.Report;
import org.junit.Before;
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
 * Created by Doing on 2017/1/7 0007.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/application.xml"})
public class ReportServiceTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ReportService reportService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGetReport() throws Exception {
        List<Report> reports = reportService.getReport("1998-01-01", "1999-12-31");
        logger.debug(reports.toString());
    }

    @Test
    public void testAddOrder() throws Exception {
        reportService.addOrder(12);
    }

    @Test
    public void testAddCollect() throws Exception {
        reportService.addCollect(12);

    }

    @Test
    public void testAddSingleCollect() throws Exception {
        reportService.addSingleCollect(12);

    }

    @Test
    public void testAddSuccessRecheck() throws Exception {
        reportService.addSuccessRecheck(12);

    }

    @Test
    public void testAddSingleRecheck() throws Exception {
        reportService.addSingleRecheck(12);

    }

    @Test
    public void testAddProduce() throws Exception {
        reportService.addProduce(12);

    }

    @Test
    public void testAddSingleProduce() throws Exception {
        reportService.addSingleProduce(12);

    }

    @Test
    public void testAddHangUp() throws Exception {
        reportService.addHangUp();

    }
}