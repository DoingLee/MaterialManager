package com.material.qr_code.web;

import com.material.qr_code.service.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.Result;

import java.util.List;

/**
 * Created by Doing on 2016/12/17 0017.
 */
@Controller
@RequestMapping("/QRname")
public class QRCodeController {

    @Autowired
    private QRCodeService qrCodeService;

    @RequestMapping(value = "/material/",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<String> addMaterialName(@RequestParam("material_name") String materialName){
        int result = qrCodeService.addMaterialName(materialName);
        if (result == 1){
            String msg = "添加成功！";
            return new Result<String>(true, msg);
        }else {
            String msg = "添加失败！";
            return new Result<String>(false, msg);
        }
    }

    @RequestMapping(value = "/blender/",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<String> addBlenderName(@RequestParam("blender_name") String blenderName){
        int result = qrCodeService.addBlenderName(blenderName);
        if (result == 1){
            String msg = "添加成功！";
            return new Result<String>(true, msg);
        }else {
            String msg = "添加失败！";
            return new Result<String>(false, msg);
        }
    }

    @RequestMapping(value = "/material/",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<List<String>> getAllMaterialName(){
        List<String> result = qrCodeService.getAllMaterialName();
        if (result != null){
            return new Result<List<String>>(true, result);
        }else {
            return new Result<List<String>>(false, null);
        }
    }

    @RequestMapping(value = "/blender/",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<List<String>> getAllBlenderName(){
        List<String> result = qrCodeService.getAllBlenderName();
        if (result != null){
            return new Result<List<String>>(true, result);
        }else {
            return new Result<List<String>>(false, null);
        }
    }
}
