package com.yoom.blog;

import java.util.HashMap;
import java.util.Map;

import com.yoom.blog.jwt.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
public class UserController {
    @Autowired JwtUtil jwtUtil;
    @Autowired UserService service;

    @PostMapping("/login")
    public HashMap login (@RequestBody User user){
        service.checkUser(user);
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("AToken", jwtUtil.createToken(user));
        map.put("RToken", jwtUtil.createRefreshToken(user));
        
        return map;
        
        //return new ResponseEntity(token,HttpStatus.OK);
    }
    @GetMapping("/hi")
    public ResponseEntity hi (){
        return new ResponseEntity("ho",HttpStatus.OK);
    }
    @GetMapping("/er")
    public ResponseEntity eResponseEntity(){
        return new ResponseEntity("er",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
