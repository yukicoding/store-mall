package com.xkkj.dao;

import com.xkkj.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderDao  {
    //获取所有订单信息
    public List<Order> findAll();

    //获取所有订单信息
    public Order findOne(String o_order);

    //新建订单
    public void addOrder(Order order);

    //删除订单
    public void removeOrder(Integer id);

    //修改订单
    public boolean  updateOrder(Order order);
}
