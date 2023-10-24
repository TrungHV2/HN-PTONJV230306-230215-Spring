package com.ra.service.impl;

import com.ra.model.entity.OrderDetailEntity;
import com.ra.model.entity.OrderEntity;
import com.ra.repository.OrderDetailRepository;
import com.ra.repository.OrderRepository;
import com.ra.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Transactional
    @Override
    public void insert(OrderEntity entity) {
        orderRepository.save(entity);
        for (OrderDetailEntity od : entity.getOrderDetails()) {
            OrderEntity o = new OrderEntity();
            o.setId(entity.getId());
            od.setOrder(o);
            orderDetailRepository.save(od);
        }
    }
}
