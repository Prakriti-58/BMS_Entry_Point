package com.ngn.bms.entrypoint.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ngn.bms.entrypoint.dao.UserDao;
import com.ngn.bms.entrypoint.model.DAOUser;
import com.ngn.bms.entrypoint.model.UserDTO;

@Service
public class JwtUserDetailsService implements UserDetailsService { 

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

		DAOUser user = userDao.findByUserId(userId);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with userId: " + userId);
		}
		return new org.springframework.security.core.userdetails.User(user.getUserId(), user.getPassword(),
				new ArrayList<>());
	}

	public DAOUser save(UserDTO user) {
		DAOUser newUser = new DAOUser();
		newUser.setEmpId(user.getEmp_id());
		newUser.setUserId(user.getUser_id());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setActive(user.getActive());
		return userDao.save(newUser);
	}
}