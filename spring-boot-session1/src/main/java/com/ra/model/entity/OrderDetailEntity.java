package com.ra.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "orderDetails")
public class OrderDetailEntity {
    @Id
    @Column(name = "id")
    @GenericGenerator(name = "uuid-hibernate", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid-hibernate")
    private String id;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId", referencedColumnName = "id")
    //@JsonIgnoreProperties(value = {"order", "hibernateLazyInitializer", "handler"})
    private OrderEntity order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId", referencedColumnName = "id")
    //@JsonIgnoreProperties(value = {"product", "hibernateLazyInitializer", "handler"})
    private ProductEntity product;
}
