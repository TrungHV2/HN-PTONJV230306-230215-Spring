package com.ra.api;

import com.ra.model.entity.OrderEntity;
import com.ra.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderApi {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public String postOrder(@RequestBody OrderEntity model) {
        orderService.insert(model);
        return null;
    }
}
