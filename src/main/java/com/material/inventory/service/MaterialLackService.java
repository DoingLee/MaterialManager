package com.material.inventory.service;

import com.material.inventory.dao.InventoryDao;
import com.material.inventory.dto.TotalOrderInventoryMaterialDto;
import com.material.inventory.entity.InventoryMaterial;
import com.material.order.dao.OrderDao;
import com.material.order.entity.UnsolvedOrderProductCount;
import com.material.plan.dao.PlanDao;
import com.material.plan.entity.ProductProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Doing on 2016/12/18 0018.
 */
@Service
public class MaterialLackService implements IMaterialLackService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private PlanDao planDao;
    @Autowired
    private InventoryDao inventoryDao;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public MaterialLackService() {
    }

    @Override
    public List<TotalOrderInventoryMaterialDto> compareAllOrderMaterialWeight() {
        //1、获取所有未处理的订单的产品总数目
        List<UnsolvedOrderProductCount> unsolvedOrderProductCounts = orderDao.getUnsolvedOrderProductCount();
        if (unsolvedOrderProductCounts == null || unsolvedOrderProductCounts.size() == 0 ) return null;

        //对每种产品：
        HashMap<String, Integer> orderMaterialsMap = new HashMap<String, Integer>(); //原料名：所需总重量
        for (UnsolvedOrderProductCount unsolvedOrderProductCount : unsolvedOrderProductCounts) {
            //获取产品所需原料信息
            List<ProductProcess> productProcesses = planDao.getProductProcess(unsolvedOrderProductCount.getProductName());
            //所需该产品数目
            int count = unsolvedOrderProductCount.getCount();

            //把产品所需的原料重量统计累加到HashMap
            addOrderMaterialsWeight(productProcesses, count, orderMaterialsMap);
        }
        // 把订单所需原料总重量与仓库原料总重量比较，综合信息到TotalOrderInventoryMaterialDto
        return compareWithInventory(orderMaterialsMap);
    }


    /**
     *  统计所有订单产品的原料总重量到HashMap
     * @param productProcesses 产品原料信息
     * @param count 产品数目
     * @param orderMaterialsMap
     */
    private void addOrderMaterialsWeight(List<ProductProcess> productProcesses, int count, HashMap<String, Integer> orderMaterialsMap){
        if (productProcesses == null || productProcesses.size() == 0) return;
        //累加：产品中每一种原料的质量 * 该产品数目
        for (ProductProcess productProcess : productProcesses) {
            String materialName = productProcess.getMaterialName();
            int newWeight = productProcess.getWeight() * count;
            if (orderMaterialsMap.containsKey(materialName)) {
                int originWeight = orderMaterialsMap.get(materialName);
                int totalWeight = originWeight + newWeight;
                orderMaterialsMap.put(materialName, totalWeight);
            }else{
                orderMaterialsMap.put(materialName, newWeight);
            }
        }
    }

    /**
     * 把订单所需原料总重量与仓库原料总重量比较，综合信息到TotalOrderInventoryMaterialDto
     * @param orderMaterialsMap
     * @return
     */
    private List<TotalOrderInventoryMaterialDto> compareWithInventory(HashMap<String, Integer> orderMaterialsMap) {
        List<TotalOrderInventoryMaterialDto> totalOrderInventoryMaterialDtos = new ArrayList<TotalOrderInventoryMaterialDto>(orderMaterialsMap.size());
        for (Map.Entry<String, Integer> entry : orderMaterialsMap.entrySet()) {
            TotalOrderInventoryMaterialDto totalOrderInventoryMaterialDto = new TotalOrderInventoryMaterialDto(entry.getKey());
            totalOrderInventoryMaterialDto.setTotalOrderNeedWeight(entry.getValue());
            InventoryMaterial inventoryMaterial = inventoryDao.getInventoryMaterial(entry.getKey());
            totalOrderInventoryMaterialDto.setTotalInventoryWeight(inventoryMaterial.getTotalWeight());
            if (entry.getValue() >= inventoryMaterial.getTotalWeight()){
                totalOrderInventoryMaterialDto.setIsLack(true);
            }else {
                totalOrderInventoryMaterialDto.setIsLack(false);
            }
            totalOrderInventoryMaterialDtos.add(totalOrderInventoryMaterialDto);
        }
        return totalOrderInventoryMaterialDtos;
    }

}
