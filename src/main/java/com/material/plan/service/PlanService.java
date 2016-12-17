package com.material.plan.service;

import com.material.plan.dao.PlanDao;
import com.material.plan.dto.CompleteProcessDto;
import com.material.plan.dto.SingleProcessDto;
import com.material.plan.entity.Product;
import com.material.plan.entity.ProductMaterial;
import com.material.plan.entity.ProductProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Doing on 2016/12/17 0017.
 */
@Controller
public class PlanService {

    @Autowired
    PlanDao planDao;

    public PlanService() {
    }

    /************************************** 添加 ********************************************/

    @Transactional
    public boolean addSingleProcess(SingleProcessDto singleProcessDto) {
        int productIdSize = planDao.getProductId(singleProcessDto.getProductName()).size();
        int addProductResult, addProductMaterialResult, addProductProcessResult;
        if (productIdSize == 0) {
            addProductResult = addSingleProduct(singleProcessDto);
        } else {
            addProductResult = 1;
        }
        int productId = planDao.getProductId(singleProcessDto.getProductName()).get(0);
        addProductMaterialResult = addSingleProductMaterial(productId, singleProcessDto);
        addProductProcessResult = addSingleProductProcess(productId, singleProcessDto);

        if (addProductResult == 1 && addProductMaterialResult == 1 && addProductProcessResult == 1) {
            return true;
        } else {
            return false;
        }
    }

    private int addSingleProduct(SingleProcessDto singleProcessDto) {
        Product product = new Product(singleProcessDto.getProductName(), singleProcessDto.getDescription());
        return planDao.addProduct(product);
    }

    private int addSingleProductProcess(int productId, SingleProcessDto singleProcessDto) {
        ProductProcess productProcess = new ProductProcess(productId, singleProcessDto.getProcessOrder(),
                singleProcessDto.getMaterialName(), singleProcessDto.getBlenderName());
        return planDao.addProductProcess(productProcess);
    }

    private int addSingleProductMaterial(int productId, SingleProcessDto singleProcessDto) {
        ProductMaterial productMaterial = new ProductMaterial(productId, singleProcessDto.getMaterialName(),
                singleProcessDto.getWeight());
        return planDao.addProductMaterial(productMaterial);
    }

    /*************************************** 修改 *******************************************/


    @Transactional
    public boolean updateSingleProcess(SingleProcessDto singleProcessDto) {
        int productIdSize = planDao.getProductId(singleProcessDto.getProductName()).size();
        if (productIdSize == 0) return false;
        int productId = planDao.getProductId(singleProcessDto.getProductName()).get(0);
        int r1 = updateSingleProductProcess(productId, singleProcessDto.getProcessOrder(), singleProcessDto);
        int r2 = updateSingleProductMaterial(productId, singleProcessDto);

        if (r1 == 1 && r2 == 1) {
            return true;
        } else {
            return false;
        }
    }

    private int updateSingleProductProcess(int productId, int processOrder, SingleProcessDto singleProcessDto) {
        ProductProcess productProcess = new ProductProcess(productId, processOrder,
                singleProcessDto.getMaterialName(), singleProcessDto.getBlenderName());
        return planDao.updateProductProcess(productProcess);
    }

    private int updateSingleProductMaterial(int productId, SingleProcessDto singleProcessDto) {
        ProductMaterial productMaterial = new ProductMaterial(productId, singleProcessDto.getMaterialName(),
                singleProcessDto.getWeight());
        return planDao.addProductMaterial(productMaterial);
    }

    /***************************************** 删除 *****************************************/

    @Transactional
    public boolean deleteSingleProcess(int productId, int processOrder) {
        int r1 = planDao.deleteSingleProductProcess(productId, processOrder);
        int r2 = planDao.deleteSingleProductMaterial(productId, processOrder);

        if (r1 == 1 && r2 == 1) {
            return true;
        } else {
            return false;
        }
    }

    /***************************************** 查找 *****************************************/

    public CompleteProcessDto getCompleteProcess(String productName) {
        int productIdSize = planDao.getProductId(productName).size();
        if (productIdSize == 0) return null;

        Product product = planDao.getProduct(productName);
        int productId = planDao.getProductId(productName).get(0);
        List<ProductMaterial> productMaterials = planDao.getProductMaterial(productId);
        List<ProductProcess> productProcesses = planDao.getProductProcess(productId);

        List<Integer> processOrders = new ArrayList<Integer>();
        List<String> materialNames = new ArrayList<String>();
        List<String> blenderNames= new ArrayList<String>();
        List<Integer> weights = new ArrayList<Integer>();
        for (int i = 0; i < productProcesses.size(); i++) {
            processOrders.add(productProcesses.get(i).getProcessOrder());
            materialNames.add(productProcesses.get(i).getMaterialName());
            blenderNames.add(productProcesses.get(i).getBlenderName());
            weights.add(productMaterials.get(i).getWeight());
        }
        CompleteProcessDto completeProcessDto = new CompleteProcessDto(productName, product.getDescription());
        completeProcessDto.setProcessOrders(processOrders);
        completeProcessDto.setMaterialNames(materialNames);
        completeProcessDto.setBlenderNames(blenderNames);
        completeProcessDto.setWeights(weights);

        return completeProcessDto;

        需要修改：把product_material去掉；在product_process表中加上weight！！
    }

}
