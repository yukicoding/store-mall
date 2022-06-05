package com.xkkj.controller;


import cn.hutool.core.date.DateUtil;
import com.xkkj.dao.OrderDao;
import com.xkkj.pojo.Order;
import com.xkkj.util.ResultData;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderDao orderDao;
    @GetMapping("")
    public ResultData<List<Order>>  getAllOrder(){
        try{
            return ResultData.success(orderDao.findAll());
        }
        catch (Exception e){
            return ResultData.fail(999,e.toString());
        }
    }

    @GetMapping("/{o_order}")
    public ResultData<Order>  getOrderById(@PathVariable(value = "o_order")String o_order){

        try{
            return ResultData.success(orderDao.findOne(o_order));
        }
        catch (Exception e){
            return ResultData.fail(999,e.toString());
        }
    }

    @PostMapping("")
    public ResultData<Order>  addOrder(@RequestBody Order order){
        System.out.println(order);
        try{
            String order_num = RandomStringUtils.random(16, 0, 20, true, true, "qw32rfHIJk9iQ8Ud7h0X".toCharArray());
            String now = DateUtil.now();
            order.setO_createAt(now);
            order.setO_order(order_num);
            System.out.println(order);
            orderDao.addOrder(order);
            return ResultData.success(orderDao.findOne(order_num));
        }
        catch (Exception e){
            return ResultData.fail(999,e.toString());
        }
    }

    @PutMapping("")
    public  ResultData<List<Order>>   updateOrder(@RequestBody Order order){

        try{
            System.out.println(order);
            orderDao.updateOrder(order);
            System.out.println(order.toString());
            return ResultData.success(orderDao.findAll());
        }
        catch (Exception e){
            return ResultData.fail(999,e.toString());
        }
    }
}
