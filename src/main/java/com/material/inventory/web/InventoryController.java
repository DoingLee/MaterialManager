package com.material.inventory.web;

import com.material.inventory.dto.TotalOrderInventoryMaterialDto;
import com.material.inventory.entity.InventoryMaterial;
import com.material.inventory.service.IInventoryService;
import com.material.inventory.service.IMaterialLackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.Result;

import java.util.List;

/**
 * Created by Doing on 2016/12/18 0018.
 */
@Controller
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private IInventoryService inventoryService;
    @Autowired
    private IMaterialLackService materialLackService;

    @RequestMapping(value = "/",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<String> addInventoryMaterial(InventoryMaterial inventoryMaterial) {
        int result = inventoryService.addInventoryMaterial(inventoryMaterial);
        if (result == 1) {
            String msg = "添加成功！";
            return new Result<String>(true, msg);
        } else {
            String msg = "添加失败！";
            return new Result<String>(false, msg);
        }
    }


    @RequestMapping(value = "/{materialName}/",
            method = RequestMethod.PUT,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<String> updateInventoryMaterial(InventoryMaterial inventoryMaterial) {
        int result = inventoryService.updateInventoryMaterial(inventoryMaterial);
        if (result == 1) {
            String msg = "修改成功！";
            return new Result<String>(true, msg);
        } else {
            String msg = "修改失败！";
            return new Result<String>(false, msg);
        }
    }

    @RequestMapping(value = "/{materialName}/",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<InventoryMaterial> getInventoryMaterial(@PathVariable("materialName") String materialName) {
        InventoryMaterial inventoryMaterial = inventoryService.getInventoryMaterial(materialName);
        if (inventoryMaterial != null) {
            return new Result<InventoryMaterial>(true, inventoryMaterial);
        } else {
            return new Result<InventoryMaterial>(false, inventoryMaterial);
        }
    }

    @RequestMapping(value = "/{materialName}/",
            method = RequestMethod.DELETE,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<String> deleteInventoryMaterial(@PathVariable("materialName") String materialName) {
        int result = inventoryService.deleteInventoryMaterial(materialName);
        if (result == 1) {
            String msg = "删除成功！";
            return new Result<String>(true, msg);
        } else {
            String msg = "删除失败！";
            return new Result<String>(false, msg);
        }
    }


    @RequestMapping(value = "/all/lack/",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<List<TotalOrderInventoryMaterialDto>> checkLackMaterial() {
        List<TotalOrderInventoryMaterialDto> result = materialLackService.compareAllOrderMaterialWeight();
        if (result != null && result.size() != 0) {
            return new Result<List<TotalOrderInventoryMaterialDto>>(true, result);
        } else {
            return new Result<List<TotalOrderInventoryMaterialDto>>(false, result);
        }
    }


}
