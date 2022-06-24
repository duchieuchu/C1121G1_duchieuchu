package com.example.repository;

import com.example.model.Blog;
import com.example.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IBlogRepository extends JpaRepository<Blog,Integer> {

    @Query(value = " select * from blog b where b.id =:idBlog", nativeQuery = true)
    Blog selectBlogById(@Param("idBlog") Integer id);
    @Modifying
    @Query(value = " delete from blog b where b.id =:idBlog", nativeQuery = true)
    int deleteBlogById(@Param("idBlog") Integer id);

    @Modifying
    @Query(value="update blog set name=:name,content=:content,note=:note,category_id=:category where id=:id",nativeQuery = true)
    int updateBlog(@Param("name") String name, @Param("content") String content, @Param("note") String note, @Param("category") Integer category, @Param("id") Integer id);

}
