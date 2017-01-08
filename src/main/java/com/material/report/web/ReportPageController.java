package com.material.report.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Doing on 2017/1/8 0008.
 */
@Controller
@RequestMapping("/report")
public class ReportPageController {

    @RequestMapping(value = "/page/check/",
            method = RequestMethod.GET)
    String getReportPage() {
        return "report";
    }
}
