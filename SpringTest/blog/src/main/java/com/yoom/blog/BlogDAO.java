package com.yoom.blog;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogDAO extends JpaRepository<Blog,String>{

    List<Blog> findAll();
    Blog findById(int id);
}
