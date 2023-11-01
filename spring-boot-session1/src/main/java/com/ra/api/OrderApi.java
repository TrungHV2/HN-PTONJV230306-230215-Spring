package com.ra.api;

import com.ra.model.entity.OrderEntity;
import com.ra.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class OrderApi {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public String postOrder(@RequestBody OrderEntity model) {
        orderService.insert(model);
        return null;
    }
}
