package com.material.report.web;

import com.material.qr_code.service.QRCodeService;
import com.material.report.entity.Report;
import com.material.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import utils.Result;

/**
 * Created by Doing on 2017/1/8 0008.
 */
@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "/sum/{fromDate}/{toDate}/",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<Report> getSumReport(@PathVariable("fromDate") String fromDate, @PathVariable("toDate") String toDate ){

        Report result = reportService.getSumReport(fromDate, toDate);
        if (result != null){
            return new Result<Report>(true, result);
        }else {
            return new Result<Report>(false, null);
        }
    }

}
