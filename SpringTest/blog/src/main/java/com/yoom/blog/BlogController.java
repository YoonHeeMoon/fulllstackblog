package com.yoom.blog;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
public class BlogController {
    @Autowired
    BlogService service;
    
    @GetMapping("/blogs")
    public List<Blog> showBlog(){
        return service.listBlogs();
    }
    @GetMapping("/blogs/{id}")
    public Blog detailBlog(@PathVariable("id") int id){
        return service.detailBlog(id);
    }

    @PostMapping("/blogs")
    public void createBlog(@RequestBody Blog blog){
        service.createBlog(blog);
    }

    @DeleteMapping("/blogs/{id}")
    public void deleteBlog(@PathVariable("id") int id){
        service.deleteBlog(id);
    }

}
