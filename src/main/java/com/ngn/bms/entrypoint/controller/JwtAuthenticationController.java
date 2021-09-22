package com.ngn.bms.entrypoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ngn.bms.entrypoint.config.JwtTokenUtil;
import com.ngn.bms.entrypoint.model.JwtRequest;
import com.ngn.bms.entrypoint.model.JwtResponse;
import com.ngn.bms.entrypoint.model.UserDTO;
import com.ngn.bms.entrypoint.service.JwtUserDetailsService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost", "http://192.168.124.242","http://103.80.111.102","http://192.168.124.90"})
public class JwtAuthenticationController {
		
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUserId(), authenticationRequest.getPassword());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserId());
		final String token = jwtTokenUtil.generateToken(userDetails);// creating token after authentication
		final String userId = userDetails.getUsername();
		return ResponseEntity.ok(new JwtResponse(token,userId));
	}

	/* User Registration  */
	@RequestMapping(value = "/register", method = RequestMethod.POST) 
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}

	//Checking the user and password
	private void authenticate(String userId, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userId, password));
		}catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		}catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
}
