package com.hjay.tmall.controller;

import com.hjay.tmall.po.Order;
import cn.lzt.tmall.service.*;
import com.hjay.tmall.util.Page;
import com.github.pagehelper.*;
import com.hjay.tmall.service.OrderItemService;
import com.hjay.tmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

/**
 * @author lzt
 * @date 2019/11/28 15:29
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    @RequestMapping("/admin_order_list")
    public String list(Model model, Page page) {
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Order> orders = orderService.list();
        int total = (int) new PageInfo<>(orders).getTotal();
        page.setTotal(total);
        orderItemService.fill(orders);
        model.addAttribute("orders", orders);
        model.addAttribute("page", page);
        return "admin/listOrder";
    }

    /**
     * 发货
     *
     * @param id
     * @return
     */
    @RequestMapping("/admin_order_delivery")
    public String delivery(int id) {
        Order order = orderService.get(id);
        order.setDeliveryDate(new Date());
        order.setStatus(OrderService.WAITCONFIRM);
        orderService.update(order);
        return "redirect:/admin_order_list";
    }
}
