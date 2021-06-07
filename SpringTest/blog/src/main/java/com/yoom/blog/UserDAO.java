package com.yoom.blog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,String>{

    User findOneById(String id);

}
