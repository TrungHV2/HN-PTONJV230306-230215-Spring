package com.ra.product.api;

import com.ra.product.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductsApi.class);
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public List<Product> get() {
        try {
            List<Object> data = restTemplate.getForObject("http://catalog-core-service/categories/", List.class);
            LOGGER.info("Call catalog-core-service with response: {}", data);
        } catch (ResourceAccessException | HttpServerErrorException ex) {
            LOGGER.error("Error Server {}", ex.getMessage());
        }
        catch (HttpClientErrorException ex) {
            LOGGER.error("Error Client {}", ex.getMessage());
        }
        catch (Exception ex) {
            LOGGER.error("Error Exception {}", ex.getMessage());
        }


        return Arrays.asList(
                new Product("P01", "Product 01", 1000, "C01", "ACTIVE"),
                new Product("P02", "Product 02", 2000, "C02", "ACTIVE"),
                new Product("P03", "Product 03", 3000, "C03", "INACTIVE"),
                new Product("P04", "Product 04", 4000, "C04", "ACTIVE"),
                new Product("P05", "Product 05", 5000, "C05", "INACTIVE")
        );
    }
}
