package com.vnk.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
final private String KEY="avuct1234$8";
public String genarateToken(String email) {
	return Jwts.builder()
			.setSubject(email)
			.setExpiration(new Date(System.currentTimeMillis()+1000*60*60*5))
			.signWith(SignatureAlgorithm.HS256, KEY)
			.compact();
}
public String extractEmail(String token) {
	return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody().getSubject();
   }
private Date extractExpiration(String token) {
	return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody().getExpiration();
   }
public Boolean isValidToken(String token) {
	return extractExpiration(token).before(new Date());
  }
public boolean validToken(String token,String email) {
	final String extractedEmail=extractEmail(token);
	return (extractedEmail.equals(email) && !isValidToken(token));
 }
}
