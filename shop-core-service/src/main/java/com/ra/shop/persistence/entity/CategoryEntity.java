package com.ra.shop.persistence.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "categories")
public class CategoryEntity {
    @Id
    @GenericGenerator(name = "hibernate-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "hibernate-uuid")
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "parentId")
    private String parentId;
    @Column(name = "status")
    private boolean status;
}
