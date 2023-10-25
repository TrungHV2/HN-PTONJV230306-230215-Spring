package com.ra.model.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "customers")
public class CustomerEntity {
    @Id
    @GenericGenerator(name = "hibernate-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "hibernate-uuid")
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "avatar")
    private String avatar;
}
