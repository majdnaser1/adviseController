package com.example.springbootday7.Controller;

import com.example.springbootday7.Dto.ApiResponse;
import com.example.springbootday7.Model.Blog;
import com.example.springbootday7.Service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @GetMapping("/get")
    public ResponseEntity getBlog() {
        List<Blog> blogs = blogService.getBlog();
        return ResponseEntity.status(200).body(blogs);
    }
    @PostMapping("/add")
    public ResponseEntity addBlog(@RequestBody @Valid Blog blog, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        blogService.addBlog(blog);
        return ResponseEntity.status(200).body(new ApiResponse("blog add!!"));

    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateBlog(@PathVariable Integer id,@RequestBody @Valid Blog blog, Errors errors){
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        boolean isUpdated=blogService.updateBlog(id,blog);
        if(isUpdated){
        blogService.updateBlog(id,blog);
            return ResponseEntity.status(200).body(new ApiResponse("blog update!!"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("wrong id!!"));


    }

    @DeleteMapping("/delete/{id}")
    public String deleteBlog(@PathVariable Integer id){

        blogService.deleteBlog(id);
        return "blog delete";

    }

    @GetMapping("/byid/{id}")
    public ResponseEntity getBlogById(@PathVariable Integer id){
        Blog blog=blogService.getBlogbyId(id);
        return ResponseEntity.status(200).body(blog);

    }

    @GetMapping("/bytitle/{title}")
    public ResponseEntity getBlogByTitle(@PathVariable String title){
        Blog blog=blogService.getBlogByTitle(title);
        return ResponseEntity.status(200).body(blog);
    }



}
