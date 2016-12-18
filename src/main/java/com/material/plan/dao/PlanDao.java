package com.material.plan.dao;

import com.material.plan.entity.Product;
import com.material.plan.entity.ProductProcess;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Doing on 2016/12/17 0017.
 */
public interface PlanDao {

    /**
     *
     * @param productName
     * @return 成功：返回产品ID；不存在：返回list大小为0
     */
    List<Integer> getProductId(String productName);

    /**********************************添加操作**************************************/
    /**
     *
     * @return 成功：返回1； 重复插入：返回0
     */
    int addProduct(Product product);

    /**
     *
     * @param productProcess
     * @return 成功：返回1； 重复插入：返回0
     */
    int addProductProcess(ProductProcess productProcess);

    /***************************************修改操作*************************************/

    int updateProduct(Product product);

    int updateProductProcess(ProductProcess productProcess);

    /***************************************删除操作**************************************/

    int deleteProduct(String productName);

    int deleteProductProcess(String productName);

    int deleteSingleProductProcess(@Param("productName")String productName, @Param("processOrder")int processOrder);

    /**************************************查找操作**************************************/

    /**
     * 查看所有订单
     * @return
     */
    List<Product> getProducts();

    Product getProduct(String productName);

    List<ProductProcess> getProductProcess(String productName);
}
