package com.ra.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "categories")
public class CategoryEntity {
    @Id
    @GenericGenerator(name = "uuid-hibernate-generate", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid-hibernate-generate")
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "parentId")
    private String parentId;
    @Column(name = "status")
    private boolean status;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    @Column(nullable = true)
    @JsonIgnoreProperties(value = {"products", "hibernateLazyInitializer"})
    private List<ProductEntity> products;
}
