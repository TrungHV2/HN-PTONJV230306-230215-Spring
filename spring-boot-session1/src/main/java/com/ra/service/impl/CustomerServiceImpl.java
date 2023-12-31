package com.ra.service.impl;

import com.ra.model.dto.CustomerRequest;
import com.ra.model.entity.CustomerEntity;
import com.ra.repository.CustomerRepository;
import com.ra.service.CustomerService;
import com.ra.service.FileStorageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private FileStorageService fileStorageService;
    private ModelMapper mapper = new ModelMapper();

    @Override
    public List<CustomerEntity> findAll() {
        try {
            return customerRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public CustomerEntity findId(String id) {
        try {
            return customerRepository.findById(id).orElse(null);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public CustomerEntity insertOrUpdate(CustomerRequest entity) {
        try {
            CustomerEntity cus = mapper.map(entity, CustomerEntity.class);
//            if (entity.getFile() != null && !entity.getFile().isEmpty()) {
//                fileStorageService.save(entity.getFile());
//                cus.setAvatar(entity.getFile().getOriginalFilename());
//            }
            return customerRepository.save(cus);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public CustomerEntity remove(String id) {
        try {
            CustomerEntity cus = findId(id);
            customerRepository.delete(cus);
            return cus;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
