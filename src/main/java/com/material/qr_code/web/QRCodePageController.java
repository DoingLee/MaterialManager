package com.material.qr_code.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Doing on 2016/12/21 0021.
 */
@Controller
@RequestMapping("/QRname")
public class QRCodePageController {

    @RequestMapping(value = "/page/add/",
            method = RequestMethod.GET)
    String addQRNamePage() {
        return "qr_name_add";
    }

    @RequestMapping(value = "/page/check/",
            method = RequestMethod.GET)
    String getAllQRNamePage() {
        return "qr_name_check";
    }

}
