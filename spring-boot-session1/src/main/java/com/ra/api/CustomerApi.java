package com.ra.api;

import com.ra.model.dto.CustomerRequest;
import com.ra.model.entity.CustomerEntity;
import com.ra.service.CustomerService;
import com.ra.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin
public class CustomerApi {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping
    public ResponseEntity get() {
        List<CustomerEntity> data = customerService.findAll();
        return new ResponseEntity(data, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable String id) {
        CustomerEntity data = customerService.findId(id);
        if (data == null)
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity(data, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity post(@RequestParam("file") MultipartFile file, @RequestBody CustomerRequest entity) {
        CustomerEntity data = customerService.insertOrUpdate(entity);
        return new ResponseEntity(data, HttpStatus.OK);
    }

    @PostMapping("/uploadFile")
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file) {
        fileStorageService.save(file);
//        String fileName = fileStorageService.storeFile(file);
//
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(fileName)
//                .toUriString();

        return new ResponseEntity(file.getOriginalFilename(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable String id, @RequestBody CustomerRequest entity) {
        CustomerEntity _cus = customerService.findId(id);
        if (_cus == null)
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        CustomerEntity data = customerService.insertOrUpdate(entity);
        return new ResponseEntity(data, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        CustomerEntity data = customerService.remove(id);
        return new ResponseEntity(data, HttpStatus.OK);
    }
}
