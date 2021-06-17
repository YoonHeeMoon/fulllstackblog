package com.yoom.blog;

import javax.servlet.http.HttpServletRequest;

import com.yoom.blog.jwt.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/token")
public class TokenController {
    @Autowired JwtUtil jwtUtil;

    @GetMapping("/exp")
    public Boolean isExp (HttpServletRequest request){
        final String token = request.getHeader("Authorization");
        return jwtUtil.isExpired(token);
    }   
}