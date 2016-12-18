package com.material.plan.web;

import com.material.plan.dto.SingleProcessDto;
import com.material.plan.service.IPlanService;
import com.material.user.entity.User;
import com.material.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import utils.Result;

import java.util.List;

/**
 * Created by Doing on 2016/12/18 0018.
 */
@Controller
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    private IPlanService planService;

    @RequestMapping(value = "/",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<String> addSingleProcess(SingleProcessDto singleProcessDto) {
        int result = planService.addSingleProcess(singleProcessDto);
        if (result == 1) {
            String s = "添加成功！";
            return new Result<String>(true, s);
        }else {
            String s = "添加失败！";
            return new Result<String>(false, s);
        }
    }

    @RequestMapping(value = "/{productName}/",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<List<SingleProcessDto>> getProductProcess(@PathVariable("productName") String productName) {
        List<SingleProcessDto> singleProcessDtos = planService.getProductProcess(productName);

        if (singleProcessDtos == null) {
            return new Result<List<SingleProcessDto>>(false, null);
        }else {
            return new Result<List<SingleProcessDto>>(true, singleProcessDtos);
        }
    }

    @RequestMapping(value = "/{productName}/",
            method = RequestMethod.PUT,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<String> updateSingleProcess(SingleProcessDto singleProcessDto) {
        int result = planService.updateSingleProcess(singleProcessDto);
        if (result == 1) {
            String s = "更改成功！";
            return new Result<String>(true, s);
        }else {
            String s = "更改失败！";
            return new Result<String>(false, s);
        }
    }

    @RequestMapping(value = "/{productName}/",
            method = RequestMethod.DELETE,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<String> deleteProduct(@PathVariable("productName") String productName) {
        int result = planService.deleteProduct(productName);
        if (result == 1) {
            String s = "删除成功！";
            return new Result<String>(true, s);
        }else {
            String s = "删除失败！";
            return new Result<String>(false, s);
        }
    }

    @RequestMapping(value = "/{productName}/{processOrder}/",
            method = RequestMethod.DELETE,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<String> deleteSingleProcess(@PathVariable("productName") String productName,
                                       @PathVariable("processOrder") int processOrder) {
        int result = planService.deleteSingleProcess(productName, processOrder);
        if (result == 1) {
            String s = "删除成功！";
            return new Result<String>(true, s);
        }else {
            String s = "删除失败！";
            return new Result<String>(false, s);
        }
    }


}
