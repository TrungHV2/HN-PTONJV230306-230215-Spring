package com.ra.service;

import com.ra.model.dto.CustomerRequest;
import com.ra.model.entity.CustomerEntity;

import java.util.List;

public interface CustomerService {
    List<CustomerEntity> findAll();
    CustomerEntity findId(String id);
    CustomerEntity insertOrUpdate(CustomerRequest entity);
    CustomerEntity remove(String id);
}
