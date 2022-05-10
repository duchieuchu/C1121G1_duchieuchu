package com.example.repository;

import com.example.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value="select * from blog where name like :name",nativeQuery=true)
    List<Blog> searchByName(@Param("name")String name);
}
