package com.ra.repository;

import com.ra.model.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {
    List<CategoryEntity> findByNameLike(String name);
    // nativeQuery = false: Dùng Java Persistence Query Language (JPQL) để truy vấn
    @Query("select c from CategoryEntity c where c.name like :name")
    List<CategoryEntity> findByNameNativeFalse(String name);
    // nativeQuery = true: Dùng câu query theo hệ quản trị CSDL đang sử dụng, query thuần
    @Query(value = "select * from categories where name like :name", nativeQuery = true)
    List<CategoryEntity> findByNameNativeTrue(String name);
}
