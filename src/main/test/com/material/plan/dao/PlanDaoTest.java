package com.material.plan.dao;

import com.material.plan.entity.Product;
import com.material.plan.entity.ProductProcess;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Doing on 2016/12/17 0017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/application.xml"})
public class PlanDaoTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PlanDao planDao;

    @Test
    public void testGetProductId() throws Exception {
        int size = planDao.getProductId("测试产品0").size();
        logger.debug("大小：" + size);
        if (size == 1) {
            logger.debug("productID：" + planDao.getProductId("测试产品0").get(0));
        }
    }

    /************************************************************************************/

    @Test
    public void testAddProduct() throws Exception {
        Product product = new Product("test0", "desc0");
        int result = planDao.addProduct(product);
        logger.debug("result：" + result);
    }

    @Test
    public void testAddProductProcess() {
        ProductProcess productProcess = new ProductProcess("product1", 2, "blender2", "material2", 23);
        int result = planDao.addProductProcess(productProcess);
        logger.debug("result：" + result);
    }

    /************************************************************************************/

    @Test
    public void testUpdateProduct() throws Exception {
        Product product = new Product("test0", "描述222");
        int result = planDao.updateProduct(product);
        logger.debug("结果：" + result);
    }

    @Test
    public void testUpdateProductProcess() throws Exception {
        ProductProcess productProcess = new ProductProcess("product1", 2, "blender1", "material1", 23);
        int result = planDao.updateProductProcess(productProcess);
        logger.debug("结果：" + result);
    }

    /************************************************************************************/


    @Test
    public void testDeleteProduct() throws Exception {
        int result = planDao.deleteProduct("test0");
        logger.debug("结果：" + result);
    }

    @Test
    public void testDeleteProductProcess() throws Exception {
        int result = planDao.deleteProductProcess("product1");
        logger.debug("结果：" + result);
    }

    @Test
    public void testDeleteSingleProductProcess() throws Exception {
        int result = planDao.deleteSingleProductProcess("test0",3 );
        logger.debug("结果：" + result);
    }

    /************************************************************************************/


    @Test
    public void testGetProducts() throws Exception {
        List<Product> products = planDao.getProducts();
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            logger.debug("结果：" + product.toString());
        }
    }

    @Test
    public void testGetProduct() throws Exception {
        Product product = planDao.getProduct("test0");
        logger.debug("结果：" + product.toString());
    }

    @Test
    public void testGetProductProcess() throws Exception {
        List<ProductProcess> productProcesses = planDao.getProductProcess("product1");
        for (int i = 0; i < productProcesses.size(); i++) {
            ProductProcess productProcess = productProcesses.get(i);
            logger.debug("结果：" + productProcess.toString());
        }
    }
}