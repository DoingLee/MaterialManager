package com.material.plan.service;

import com.material.plan.dto.SingleProcessDto;

import java.util.List;

/**
 * Created by Doing on 2016/12/18 0018.
 */
public interface IPlanService {

    /**
     * 添加单个步骤（若产品不存在，则顺带添加产品）
     * @param singleProcessDto
     * @return
     */
    int addSingleProcess(SingleProcessDto singleProcessDto);

    /**
     * 更新单个步骤
     * @param singleProcessDto
     * @return
     */
    int updateSingleProcess(SingleProcessDto singleProcessDto);

    /**
     * 删除单个步骤
     * @param productName
     * @param processOrder
     * @return
     */
    int deleteSingleProcess(String productName, int processOrder);

    /**
     * 删除产品及其所有操作步骤
     * @param productName
     * @return
     */
    int deleteProduct(String productName);

    /**
     * 获取某个产品的所有操作步骤
     * @param productName
     * @return null：无
     */
    List<SingleProcessDto> getProductProcess(String productName);
}
