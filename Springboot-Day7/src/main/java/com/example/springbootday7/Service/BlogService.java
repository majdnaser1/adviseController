package com.example.springbootday7.Service;

import com.example.springbootday7.Exception.ApiException;
import com.example.springbootday7.Model.Blog;
import com.example.springbootday7.Repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    public List<Blog> getBlog(){
        return blogRepository.findAll();
    }
    public void addBlog(Blog blog){
        blogRepository.save(blog);
    }

    public Boolean updateBlog(Integer id,Blog blog){
        Blog oldblog=blogRepository.findBlogById(id);
        if(oldblog==null){
            return false;
        }
        oldblog.setTitle(blog.getTitle());
        oldblog.setBody(blog.getBody());
        blogRepository.save(oldblog);

        return true;
    }

    public Blog getBlogbyId(Integer id){
       Blog blog=blogRepository.findBlogById(id);
       if(blog==null){
           throw new ApiException("wrong ID");
       }
       return blog;


    }

    public Blog getBlogByTitle(String title){
        Blog blog=blogRepository.findBlogByTitle(title);
        if(blog==null){
            throw new ApiException("Wrong title");
        }
        return blog;
    }

    public Boolean deleteBlog(Integer id){
        Blog blog=blogRepository.findBlogById(id);

        if(blog==null){
            return false;
        }
        blogRepository.delete(blog);
        return true;
    }

}
