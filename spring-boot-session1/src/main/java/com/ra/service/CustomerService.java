package com.ra.service;

import com.ra.model.entity.CustomerEntity;

import java.util.List;

public interface CustomerService {
    List<CustomerEntity> findAll();
    CustomerEntity findId(String id);
    CustomerEntity insertOrUpdate(CustomerEntity entity);
    CustomerEntity remove(String id);
}
