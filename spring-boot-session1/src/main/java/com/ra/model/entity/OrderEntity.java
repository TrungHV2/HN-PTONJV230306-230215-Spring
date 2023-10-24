package com.ra.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Data
@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GenericGenerator(name = "uuid-hibernate", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid-hibernate")
    @Column(name = "id")
    private String id;
    @Column(name = "customerId")
    private String customerId;
    @Column(name = "created")
    private Timestamp created;
    @Column(name = "total")
    private double total;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JsonIgnoreProperties(value = {"orderDetails", "hibernateLazyInitializer", "handler"})
    private Set<OrderDetailEntity> orderDetails;
}
