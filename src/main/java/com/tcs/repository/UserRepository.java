package com.tcs.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tcs.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	List<User> findByUserName(String userName);
	
	public List<User> findUsersByDob(Date dob);
	
	@Query("from User where dob between :dateOfBirth1 and :dateOfBirth2")
	public List<User> findUsersBetweenDob(@Param("dateOfBirth1") Date dateOfBirth1, @Param("dateOfBirth2")Date dateOfBirth2);
	

}
