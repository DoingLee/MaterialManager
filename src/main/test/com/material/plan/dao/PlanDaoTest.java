package com.material.plan.dao;

import com.material.plan.entity.Product;
import com.material.plan.entity.ProductMaterial;
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
        int size = planDao.getProductId("测试产品000").size();
        logger.debug("大小：" + size);

    }

    /*****************************************************************************/

    @Test
    public void testAddProduct() throws Exception {
        Product product = new Product("测试产品0", "描述0");
        int result = planDao.addProduct(product);
        logger.debug("结果：" + result);
    }

    @Test
    public void testAddProductMaterial() throws Exception {
        //注意getProductId可能返回null -> 用try catch
        ProductMaterial productMaterial = new ProductMaterial(planDao.getProductId("测试产品0").get(0), "材料1", 113);
        int result = planDao.addProductMaterial(productMaterial);
        logger.debug("结果：" + result);
    }

    @Test
    public void testAddProductProcess() throws Exception {
        //注意getProductId可能返回null -> 用try catch
        ProductProcess productProcess = new ProductProcess(planDao.getProductId("测试产品0").get(0), 2, "材料1", "混料罐1");
        int result = planDao.addProductProcess(productProcess);
        logger.debug("结果：" + result);
    }

    /************************************************************************************/

    @Test
    public void testUpdateProduct() throws Exception {
        Product product = new Product("测试产品0", "描述222");
        int result = planDao.updateProduct(product);
        logger.debug("结果：" + result);
    }

    @Test
    public void testUpdateProductMaterial() throws Exception {
        //注意getProductId可能返回null -> 用try catch
        ProductMaterial productMaterial = new ProductMaterial(planDao.getProductId("测试产品0").get(0), "材料1", 22);
        int result = planDao.updateProductMaterial(productMaterial);
        logger.debug("结果：" + result);
    }

    @Test
    public void testUpdateProductProcess() throws Exception {
        //注意getProductId可能返回null -> 用try catch
        ProductProcess productProcess = new ProductProcess(planDao.getProductId("测试产品").get(0), 2, "材料1", "混料罐1");
        int result = planDao.updateProductProcess(productProcess);
        logger.debug("结果：" + result);
    }

    /************************************************************************************/


    @Test
    public void testDeleteProduct() throws Exception {
        int result = planDao.deleteProduct("测试产品0");
        logger.debug("结果：" + result);
    }

    @Test
    public void testDeleteProductMaterial() throws Exception {
        int result = planDao.deleteProductMaterial(2);
        logger.debug("结果：" + result);
    }

    @Test
    public void testDeleteProductProcess() throws Exception {
        int result = planDao.deleteProductProcess(1);
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
        Product product = planDao.getProduct("测试产品0");
        logger.debug("结果：" + product.toString());
    }

    @Test
    public void testGetProductMaterial() throws Exception {
        List<ProductMaterial> productMaterials = planDao.getProductMaterial(planDao.getProductId("测试产品0").get(0));
        for (int i = 0; i < productMaterials.size(); i++) {
            ProductMaterial productMaterial = productMaterials.get(i);
            logger.debug("结果：" + productMaterial.toString());
        }
    }

    @Test
    public void testGetProductProcess() throws Exception {
        List<ProductProcess> productProcesses = planDao.getProductProcess(1);
        for (int i = 0; i < productProcesses.size(); i++) {
            ProductProcess productProcess = productProcesses.get(i);
            logger.debug("结果：" + productProcess.toString());
        }
    }
}