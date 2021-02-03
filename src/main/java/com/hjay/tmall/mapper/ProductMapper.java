package com.hjay.tmall.mapper;

import com.hjay.tmall.po.Product;
import com.hjay.tmall.po.ProductExample;

import java.util.List;

public interface ProductMapper extends EntityMoveMapper<Product> {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}