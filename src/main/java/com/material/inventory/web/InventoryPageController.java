package com.material.inventory.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Doing on 2016/12/22 0022.
 */
@Controller
@RequestMapping("/inventory")
public class InventoryPageController {

    @RequestMapping(value = "/page/check_lack/",
            method = RequestMethod.GET)
    String checkLackPage() {
        return "inventory_lack";
    }


    @RequestMapping(value = "/page/add_weight/",
            method = RequestMethod.GET)
    String addMaterialWeightPage() {
        return "inventory_add_weight";
    }

}
