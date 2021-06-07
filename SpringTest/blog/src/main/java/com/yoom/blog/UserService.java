package com.yoom.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDAO dao;
    public void checkUser(User user){
        String id = user.getId();
        User tmp = dao.findOneById(id);
        if(tmp==null){
            throw new RestException(HttpStatus.INTERNAL_SERVER_ERROR, "ID not found");
        }
        if(!tmp.getPw().equals(user.getPw())){
            throw new RestException(HttpStatus.INTERNAL_SERVER_ERROR, "Pw not matched");
        }
    }
}
