package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByAuthorContaining(String author);

    @Transactional
    @Modifying
    @Query(value ="SELECT b.* from blog b where b.category_id = :id", nativeQuery=true)
    List<Blog> findByCategory(@Param("id") int id);
}
