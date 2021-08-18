package com.yoom.blog.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.yoom.blog.RestException;
import com.yoom.blog.User;
import com.yoom.blog.ErrorCode;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

    private static final String SECRET_KEY = "YoonHeeMoon";
    long expiredTime = (30 * 1000 * 60);

    public String createToken(User loginVO) {
        Date now = new Date();
        return Jwts.builder()
        .setSubject("accessToken")
        .setHeader(createHeader())
        .setExpiration(new Date(now.getTime() + expiredTime))
        .claim("id", loginVO.getId())
        .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }
    public String createRefreshToken(User loginVO) {
        Date now = new Date();
        return Jwts.builder()
        .setSubject("refreshToken")
        .setHeader(createHeader())
        .claim("id", loginVO.getId())
        .setExpiration(new Date(now.getTime() + expiredTime * 48 * 7 ))//일주일
        .signWith(SignatureAlgorithm.HS256,SECRET_KEY).compact();
    }

    private Map<String, Object> createHeader() {
        Map<String, Object> header = new HashMap<>();
        header.put("typ", "JWT");
        header.put("alg", "HS256"); // 해시 256 사용하여 암호화
        return header;
    }

    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    public String getIdFromToken(String token) {
         return (String) getClaims(token).get("id");
    }
    public boolean isExpired(String token){
        Date now = new Date();
        String tokenonly = token.substring(0,token.lastIndexOf(".")+1);
        Date exp = ((Claims)Jwts.parser().parse(tokenonly).getBody()).getExpiration();
        if(now.after(exp)){
            return false;
        }else{
            throw new RestException(HttpStatus.UNAUTHORIZED,ErrorCode.UNUSABLE_TOKEN);
		}
    }

    public boolean isUsable(String token){
		try{
			Claims claims = Jwts.parser()
					  .setSigningKey(SECRET_KEY)
					  .parseClaimsJws(token).getBody(); 
			return true;
		}catch (Exception e) {
            throw new RestException(HttpStatus.UNAUTHORIZED,ErrorCode.UNUSABLE_TOKEN);
		}
	}
}

