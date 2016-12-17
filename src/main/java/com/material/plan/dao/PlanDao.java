package com.material.plan.dao;

import com.material.plan.entity.Product;
import com.material.plan.entity.ProductMaterial;
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
     * @param productMaterial
     * @return 成功：返回1； 重复插入：返回0
     */
    int addProductMaterial(ProductMaterial productMaterial);

    /**
     *
     * @param productProcess
     * @return 成功：返回1； 重复插入：返回0
     */
    int addProductProcess(ProductProcess productProcess);

    /***************************************修改操作*************************************/

    int updateProduct(Product product);

    int updateProductMaterial(ProductMaterial productMaterial);

    int updateProductProcess(ProductProcess productProcess);

    /***************************************删除操作**************************************/

    int deleteProduct(String productName);

    int deleteProductMaterial(int productId);

    int deleteSingleProductMaterial(@Param("productId")int productId, @Param("processOrder")int processOrder);

    int deleteProductProcess(int productId);

    int deleteSingleProductProcess(@Param("productId")int productId, @Param("processOrder")int processOrder);

    /**************************************查找操作**************************************/

    /**
     * 查看所有订单
     * @return
     */
    List<Product> getProducts();

    Product getProduct(String productName);

    List<ProductMaterial> getProductMaterial(int productId);

    List<ProductProcess> getProductProcess(int productId);
}
