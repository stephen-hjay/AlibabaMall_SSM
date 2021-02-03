package com.hjay.tmall.controller;

import cn.lzt.tmall.po.*;
import cn.lzt.tmall.service.*;
import com.hjay.tmall.po.Product;
import com.hjay.tmall.po.PropertyValue;
import com.hjay.tmall.service.ProductService;
import com.hjay.tmall.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lzt
 * @date 2019/11/28 10:47
 */
@Controller
public class PropertyValueController {

    @Autowired
    private PropertyValueService propertyValueService;

    @Autowired
    private ProductService productService;

    public PropertyValueController() {
    }

    @RequestMapping("/admin_propertyValue_edit")
    public String list(int pid, Model model) {
        Product p = productService.get(pid);
        propertyValueService.init(p);
        List<PropertyValue> pvs = propertyValueService.list(pid);
        model.addAttribute("p", p);
        model.addAttribute("pvs", pvs);
        return "admin/editPropertyValue";
    }

    @RequestMapping("/admin_propertyValue_update")
    @ResponseBody
    public String update(PropertyValue pv) {
        propertyValueService.update(pv);
        return "success";
    }
}
