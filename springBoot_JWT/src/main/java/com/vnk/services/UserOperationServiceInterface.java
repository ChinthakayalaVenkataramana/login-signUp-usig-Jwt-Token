package com.vnk.services;

import com.vnk.entity.UserInformation;

public interface UserOperationServiceInterface {
public String userSignUp(UserInformation information);
public String userLogin(String email, String password); 
}
