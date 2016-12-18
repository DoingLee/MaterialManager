package com.material.plan.service;

import com.material.plan.dao.PlanDao;
import com.material.plan.dto.CompleteProcessDto;
import com.material.plan.dto.SingleProcessDto;
import com.material.plan.entity.Product;
import com.material.plan.entity.ProductProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Doing on 2016/12/17 0017.
 */
@Controller
public class PlanService implements IPlanService{

    @Autowired
    PlanDao planDao;

    public PlanService() {
    }

    @Override
    @Transactional
    public int addSingleProcess(SingleProcessDto singleProcessDto) {
        Product product = planDao.getProduct(singleProcessDto.getProductName());
        if (product == null) {
            Product newProduct = new Product(singleProcessDto.getProductName(), singleProcessDto.getDescription());
            planDao.addProduct(newProduct);
        }

        ProductProcess productProcess = new ProductProcess();
        productProcess.setWeight(singleProcessDto.getWeight());
        productProcess.setProcessOrder(singleProcessDto.getProcessOrder());
        productProcess.setMaterialName(singleProcessDto.getMaterialName());
        productProcess.setBlenderName(singleProcessDto.getBlenderName());
        productProcess.setProductName(singleProcessDto.getProductName());

        return planDao.addProductProcess(productProcess);
    }

    @Override
    public int updateSingleProcess(SingleProcessDto singleProcessDto) {
        Product product = new Product(singleProcessDto.getProductName(), singleProcessDto.getDescription());
        planDao.updateProduct(product);

        ProductProcess productProcess = new ProductProcess();
        productProcess.setWeight(singleProcessDto.getWeight());
        productProcess.setProcessOrder(singleProcessDto.getProcessOrder());
        productProcess.setMaterialName(singleProcessDto.getMaterialName());
        productProcess.setBlenderName(singleProcessDto.getBlenderName());
        productProcess.setProductName(singleProcessDto.getProductName());
        int result = planDao.updateProductProcess(productProcess);

        return result;
    }

    @Override
    public int deleteSingleProcess(String productName, int processOrder) {
        return planDao.deleteSingleProductProcess(productName, processOrder);
    }

    @Override
    @Transactional
    public int deleteProduct(String productName) {
        int result1 = planDao.deleteProductProcess(productName);
        int result2 = planDao.deleteProduct(productName);
        return result2;
    }

    @Override
    public List<SingleProcessDto> getProductProcess(String productName) {

        Product product = planDao.getProduct(productName);
        List<ProductProcess> productProcesses =  planDao.getProductProcess(productName);
        if (productProcesses == null || productProcesses.size() == 0)
            return null;

        List<SingleProcessDto> singleProcessDtos = new ArrayList<SingleProcessDto>();
        for (int i = 0 ; i < productProcesses.size(); i++ ) {
            ProductProcess productProcess = productProcesses.get(i);
            SingleProcessDto singleProcessDto = new SingleProcessDto(productName, product.getDescription());

            singleProcessDto.setBlenderName(productProcess.getBlenderName());
            singleProcessDto.setMaterialName(productProcess.getMaterialName());
            singleProcessDto.setProcessOrder(productProcess.getProcessOrder());
            singleProcessDto.setWeight(productProcess.getWeight());

            singleProcessDtos.add(singleProcessDto);
        }
        return singleProcessDtos;
    }



}
