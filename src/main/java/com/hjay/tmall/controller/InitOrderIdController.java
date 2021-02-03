package com.hjay.tmall.controller;

import com.hjay.tmall.po.Category;
import com.hjay.tmall.po.Product;
import com.hjay.tmall.po.ProductImage;
import com.hjay.tmall.po.Property;
import com.hjay.tmall.service.CategoryService;
import com.hjay.tmall.service.ProductImageService;
import com.hjay.tmall.service.ProductService;
import com.hjay.tmall.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 初始化排序号
 *
 * @Author: lzt
 * @Date: 2019/12/5 22:54
 */
@Controller
public class InitOrderIdController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private ProductImageService productImageService;

    @RequestMapping("/tmall_init_order_id")
    @ResponseBody
    public String initOrderId() {

        initCategory();

        return "success";

    }


    private void initCategory() {
        List<Category> list = categoryService.list(null);
        int orderId = 1;
        for (Category category : list) {
            category.setOrderId(orderId++);
            categoryService.update(category);
            initProduct(category.getId());
            initProperty(category.getId());
        }
    }

    private void initProduct(int cid) {
        List<Product> list = productService.list(cid, null);
        int orderId = 1;
        for (Product product : list) {
            product.setOrderId(orderId++);
            productService.update(product);

            initProductImage(product.getId(), "type_single");
            initProductImage(product.getId(), "type_detail");
        }
    }

    private void initProductImage(Integer pid, String type) {
        List<ProductImage> list = productImageService.list(pid, type);
        int orderId = 1;
        for (ProductImage productImage : list) {
            productImage.setOrderId(orderId++);
            productImageService.update(productImage);
        }

    }

    private void initProperty(Integer cid) {
        List<Property> list = propertyService.list(cid, null);
        int orderId = 1;
        for (Property property : list) {
            property.setOrderId(orderId++);
            propertyService.update(property);
        }
    }
}
