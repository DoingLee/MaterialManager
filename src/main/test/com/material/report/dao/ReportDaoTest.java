package com.material.report.dao;

import com.material.inventory.dao.InventoryDao;
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
public class ReportDaoTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ReportDao reportDao;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGetReport() throws Exception {
        List<Report> reports = reportDao.getReport("1980-01-02", "2001-01-01");
        if (reports != null) {
            logger.info(reports.toString());
        }
    }

    @Test
    public void testInsertRow() throws Exception {
        reportDao.insertRow(new Report("2017-01-07"));
    }

    @Test
    public void testAddOrder() throws Exception {
        reportDao.addOrder(88);
    }

    @Test
    public void testAddCollect() throws Exception {
        reportDao.addCollect(11);
    }

    @Test
    public void testAddSingleCollect() throws Exception {
        reportDao.addSingleCollect(11);
    }

    @Test
    public void testAddSuccessRecheck() throws Exception {
        reportDao.addSuccessRecheck(11);

    }

    @Test
    public void testAddSingleRecheck() throws Exception {
        reportDao.addSingleRecheck(11);

    }

    @Test
    public void testAddProduce() throws Exception {
        reportDao.addProduce(11);

    }

    @Test
    public void testAddSingleProduce() throws Exception {
        reportDao.addSingleProduce(11);

    }

    @Test
    public void testAddHangUp() throws Exception {
        reportDao.addHangUp();

    }
}