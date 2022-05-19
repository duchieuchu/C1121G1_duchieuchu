package com.example.repository;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    @Query(value="select * from blog where name like :name",nativeQuery=true)
    List<Blog> searchByName(@Param("name")String name);

    Page<Blog>findAllByNameContaining(String name, Pageable pageable);

    Page<Blog>findAllByCategory_Name(String name,Pageable pageable);

}
