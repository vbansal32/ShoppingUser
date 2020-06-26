package com.tcs.resources;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.model.User;
import com.tcs.repository.UserRepository;
import com.tcs.service.UserService;

@RestController
@RequestMapping("/user")
public class ShoppingUserResource {
	
	@Autowired
	UserService userService;

	@GetMapping("/getUser/{userId}")
	public Optional<User> getUser(@PathVariable("userId") Integer userId) {
		return userService.getUserById(userId);
	}
	
	@GetMapping("/getUser/name/{userName}")
	public List<User> getUser(@PathVariable("userName") String userName) {
		return userService.getUserByName(userName);
	}
	
	@GetMapping("/getUser/dob")
	public List<User> getUserbyDob(@RequestParam("dob") @DateTimeFormat(pattern = "yyyy-MM-dd")Date dob) {
		System.out.println("dob===" + dob.toString());
		return userService.getUserByDob(dob);
	}
	@GetMapping("/getUser/dobs")
	public List<User> getUsersBetweenDob(@RequestParam("dob1") @DateTimeFormat(pattern = "yyyy-MM-dd")Date dob1, @RequestParam("dob2") @DateTimeFormat(pattern = "yyyy-MM-dd")Date dob2) {
		System.out.println("dob1===" + dob1.toString());
		System.out.println("dob2===" + dob2.toString());
		return userService.getUsersBetweenDob(dob1, dob2);
	}
	
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@PostMapping("/addUser")
	public List<User> addUser(@RequestBody User user) {
		userService.addUser(user);
		return getAllUsers();
	}
	
	@PostMapping("/updateUser")
	public Optional<User> updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@GetMapping("/deleteUser/{userId}")
	public String deleteUser(@PathVariable("userId") Integer userId) {
		return userService.deleteUser(userId);
	}
	
}
