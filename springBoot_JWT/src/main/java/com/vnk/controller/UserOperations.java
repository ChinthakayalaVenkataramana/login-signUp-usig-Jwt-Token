package com.vnk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vnk.entity.UserInformation;
import com.vnk.security.JwtUtil;
import com.vnk.services.UserOperationServiceInterface;

@Controller
@RequestMapping("/api")
public class UserOperations {
@Autowired
private UserOperationServiceInterface userOperationServiceInterface;
@Autowired
private JwtUtil jwtUtil;
@Autowired 
private PasswordEncoder cryptPasswordEncoder;

@GetMapping("/home")
public ResponseEntity<String> home() {
	return new ResponseEntity<String>("Welcome Home page",HttpStatus.OK);
}

@PostMapping("/signup")
public String signUp(@RequestBody UserInformation information) {
	information.setPassword(cryptPasswordEncoder.encode(information.getPassword()));
	return userOperationServiceInterface.userSignUp(information);
}

@PostMapping("/login")
public ResponseEntity<String> postMethodName(@RequestBody UserInformation  entity) {
    String email=entity.getEmail();
    String password=entity.getPassword();
    String token=userOperationServiceInterface.userLogin(email, password);
    if(token!=null) {
    return new ResponseEntity<String>(token,HttpStatus.OK);
    }else {
    	return new ResponseEntity<String>("Invalid Email And Password",HttpStatus.BAD_GATEWAY);
    }
}


}
