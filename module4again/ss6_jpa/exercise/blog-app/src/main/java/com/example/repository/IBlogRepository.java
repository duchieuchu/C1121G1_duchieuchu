package com.example.repository;

import com.example.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value = " select * from blog", nativeQuery = true)
    List<Blog> selectList();

    @Query(value = " select * from blog b where b.id =:idBlog", nativeQuery = true)
    Blog selectBlogById(@Param("idBlog") Integer id);
}
