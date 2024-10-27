package com.vnk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vnk.entity.UserInformation;

public interface UserRepository extends JpaRepository<UserInformation,Integer> {
@Query("from UserInformation where email=:Email")
	public UserInformation findUserLogn(@Param("Email")  String Email);

}
