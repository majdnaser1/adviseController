package com.example.springbootday7.Repository;

import com.example.springbootday7.Model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {

   Blog findBlogById(Integer id);
   Blog findBlogByTitle(String title);

   @Query("select  u from Blog u where u.id=?1")
   Blog findIdForMe(Integer id);



}
