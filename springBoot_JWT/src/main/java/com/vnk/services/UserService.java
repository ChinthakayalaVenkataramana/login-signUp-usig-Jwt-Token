package com.vnk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vnk.entity.UserInformation;
import com.vnk.repository.UserRepository;
import com.vnk.security.JwtUtil;
@Service
public class UserService implements UserOperationServiceInterface {
	@Autowired
	private UserRepository repository;
	@Autowired 
	private PasswordEncoder cryptPasswordEncoder;
	@Autowired
	private JwtUtil jwtUtil;
	@Override
	public String userSignUp(UserInformation information) {
		if(information!=null) {
			repository.save(information);
		 return "Successfully register "+information.getEmail() ;
		}else {
			return "Not Register give currect details";
		}
	}
	@Override
	public String userLogin(String email, String password) {
		UserInformation information=repository.findUserLogn(email);
		if(information!=null && cryptPasswordEncoder.matches(password,information.getPassword())) {
			return jwtUtil.genarateToken(email); 
		}
		return null;
	}
}
