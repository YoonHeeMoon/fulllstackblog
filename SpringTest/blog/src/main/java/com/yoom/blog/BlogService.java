package com.yoom.blog;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yoom.blog.Blog;
@Service
public class BlogService {
    @Autowired
    BlogDAO dao;
    public List<Blog> listBlogs(){
        return dao.findAll();
    }
    public Blog detailBlog(int id){
        return dao.findById(id);
    }
    public void createBlog(Blog blog){
        Blog b = Blog.builder()
        .title(blog.title)
        .Author(blog.Author)
        .body(blog.body)
        .build();
        dao.save(b);
    }
    public void deleteBlog(int id){
        Blog blog = dao.findById(id);
        dao.delete(blog);
    }
}
