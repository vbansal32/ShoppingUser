package com.tcs.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.tcs.model.User;
import com.tcs.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	public Optional<User> getUserById(Integer id){
		return userRepo.findById(id);
	}
	
	public List<User> getUserByName(String userName){
		return userRepo.findByUserName(userName);
	}
	
	public List<User> getUserByDob(Date dob){
		return userRepo.findUsersByDob(dob);
	}
	
	public List<User> getUsersBetweenDob(Date dob1, Date dob2){
		return userRepo.findUsersBetweenDob(dob1, dob2);
	}
	
	public List<User> addUser(User user){
		userRepo.save(user);
		return getAllUsers();
	}
	
	public String deleteUser(@PathVariable("userId") Integer userId){
		try {
			userRepo.deleteById(userId);
		}
		catch (EmptyResultDataAccessException e) {
			return "No matching user found.";
		}
		return "User deleted successfully";
	}

	public Optional<User> updateUser(User user) {
		userRepo.save(user);
		return getUserById(user.getUserId());
	}
	
}
