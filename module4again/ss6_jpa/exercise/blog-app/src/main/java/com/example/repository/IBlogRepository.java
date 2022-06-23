package com.example.repository;

import com.example.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value = " select * from blog", nativeQuery = true)
    List<Blog> selectList();

    @Query(value = " select * from blog b where b.id =:idBlog", nativeQuery = true)
    Blog selectBlogById(@Param("idBlog") Integer id);

    @Query(value = " select * from blog where name like :name", nativeQuery = true)
    List<Blog> selectListByName(@Param("name")String name);

    @Modifying
    @Query(value = " delete from blog b where b.id =:idBlog", nativeQuery = true)
    int deleteBlogById(@Param("idBlog") Integer id);

    @Modifying
    @Query(value="insert into blog (name, content, note) VALUES (:name ,:content, :note) ",nativeQuery = true)
    int createBlog(@Param("name") String name, @Param("content") String content, @Param("note") String note);

    @Modifying
    @Query(value="update blog set name=:name,content=:content,note=:note where id=:id",nativeQuery = true)
    int updateBlog(@Param("name") String name, @Param("content") String content, @Param("note") String note, @Param("id") Integer id);


}
