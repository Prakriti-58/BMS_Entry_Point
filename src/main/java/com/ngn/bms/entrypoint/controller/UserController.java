package com.ngn.bms.entrypoint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ngn.bms.entrypoint.model.DAOUser;
import com.ngn.bms.entrypoint.model.UserList;
import com.ngn.bms.entrypoint.repository.UserListRepo;
import com.ngn.bms.entrypoint.repository.UserRepository;
import com.ngn.bms.entrypoint.repository.UserRepositoryForId;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://192.168.124.242","http://103.80.111.102"})
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRepositoryForId userRepositoryForId;
	
	@Autowired
	private UserListRepo userListRepo;
	
	@GetMapping("/getUserEmpId/{userId}")
	public DAOUser getDaoUser(@PathVariable String userId) {
		return userRepository.findByUserId(userId);	
	} 
	
	@GetMapping("/getEmpDetailByUserId/{userId}")
	public DAOUser getEmpDetailByUserId(@PathVariable Long userId) {
		return userRepository.findById(userId).orElse(null);
	} 
	
	@GetMapping("/getUserEmpById/{empId}")
	public DAOUser getDaoUser(@PathVariable int empId) {
		return userRepositoryForId.findByEmpId(empId);	
	} 
	  
	@GetMapping("/getAssignToList")
	public List<UserList> getList(){
		return userListRepo.findAll();
	}
	
	@GetMapping("/getUserId/{username}")
	public UserList getUserList(@PathVariable String username){
		return userListRepo.findByUserId(username);
	} 
	
}
