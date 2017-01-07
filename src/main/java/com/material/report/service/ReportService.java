package com.material.report.service;

import com.material.report.dao.ReportDao;
import com.material.report.entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Doing on 2017/1/7 0007.
 */
@Service
public class ReportService implements IReportService {

    @Autowired
    private ReportDao reportDao;

    public ReportService() {
    }

    @Override
    public List<Report> getReport(String fromDate, String toDate) {
        return reportDao.getReport(fromDate,toDate);
    }

    @Override
    public int addOrder(int sec) {
        int result = reportDao.addOrder(sec);
        if (result == 0) {
            Report report = new Report(getCurDate());
            report.setFinishedOrderCount(1);
            report.setAvgOrderTime(sec);
            result = reportDao.insertRow(report);
        }
        return result;
    }

    @Override
    public int addCollect(int sec) {
        int result = reportDao.addCollect(sec);
        if (result == 0) {
            Report report = new Report(getCurDate());
            report.setCollectCount(1);
            report.setAvgCollectTime(sec);
            result = reportDao.insertRow(report);
        }
        return result;
    }

    @Override
    public int addSingleCollect(int sec) {
        int result = reportDao.addSingleCollect(sec);
        if (result == 0) {
            Report report = new Report(getCurDate());
            report.setSingleCollectCount(1);
            report.setAvgSingleCollectTime(sec);
            result = reportDao.insertRow(report);
        }
        return result;
    }

    @Override
    public int addSuccessRecheck(int sec) {
        int result = reportDao.addSuccessRecheck(sec);
        if (result == 0) {
            Report report = new Report(getCurDate());
            report.setSuccessRecheckCount(1);
            report.setAvgSuccessRecheckTime(sec);
            result = reportDao.insertRow(report);
        }
        return result;
    }

    @Override
    public int addSingleRecheck(int sec) {
        int result = reportDao.addSingleRecheck(sec);
        if (result == 0) {
            Report report = new Report(getCurDate());
            report.setSingleRecheckCount(1);
            report.setAvgSingleRecheckTime(sec);
            result = reportDao.insertRow(report);
        }
        return result;
    }

    @Override
    public int addProduce(int sec) {
        int result = reportDao.addProduce(sec);
        if (result == 0) {
            Report report = new Report(getCurDate());
            report.setProduceCount(1);
            report.setAvgProduceTime(sec);
            result = reportDao.insertRow(report);
        }
        return result;
    }

    @Override
    public int addSingleProduce(int sec) {
        int result = reportDao.addCollect(sec);
        if (result == 0) {
            Report report = new Report(getCurDate());
            report.setSingleProduceCount(1);
            report.setAvgSingleProduceTime(sec);
            result = reportDao.insertRow(report);
        }
        return result;
    }

    @Override
    public int addHangUp() {
        int result = reportDao.addHangUp();
        if (result == 0) {
            Report report = new Report(getCurDate());
            report.setHangUpCount(1);
            result = reportDao.insertRow(report);
        }
        return result;
    }

    private String getCurDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = sdf.format(new Date(System.currentTimeMillis()));
        return dateString;
    }
}
