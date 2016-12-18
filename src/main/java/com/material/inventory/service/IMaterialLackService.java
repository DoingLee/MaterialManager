package com.material.inventory.service;

import com.material.inventory.dto.TotalOrderInventoryMaterialDto;

import java.util.List;

/**
 * Created by Doing on 2016/12/18 0018.
 */
public interface IMaterialLackService {

    List<TotalOrderInventoryMaterialDto> compareAllOrderMaterialWeight();

}
