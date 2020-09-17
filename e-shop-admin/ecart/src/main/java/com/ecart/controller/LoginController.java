/**
 * 
 */
package com.ecart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecart.jwtsecurityconfiguration.JwtRequest;
import com.ecart.jwtsecurityconfiguration.JwtResponse;
import com.ecart.jwtsecurityconfiguration.JwtUtil;
import com.ecart.jwtsecurityconfiguration.MyUserDetailsServiceImpl;
import com.ecart.repo.StakeholderRepo;

/**
 * @author Tharindu Jan 27, 2020
 * 
 * This is a common login for user and admin
 *
 */
@CrossOrigin
@RestController
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsServiceImpl myUserDetailsService;

	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@Autowired
	public StakeholderRepo stakeholderRepo;
	
	

	@PostMapping(value = "/login")
	public JwtResponse createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		JwtResponse jwtResponce = new JwtResponse();
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword()));
			final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUserName());
			final String jwttoken = jwtTokenUtil.generateToken(userDetails);
			jwtResponce.setJwttoken(jwttoken);
			jwtResponce.setRole(stakeholderRepo.findByUserNameIgnoreCase(authenticationRequest.getUserName()).getStakeholderType());
		} catch (DisabledException e) {
			jwtResponce.setKey("error");
			jwtResponce.setMessage("User Desabled");
			//throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			jwtResponce.setKey("error");
			jwtResponce.setMessage("Invalid User Name Or Password");
			//throw new Exception("INVALID_CREDENTIALS", e);
		}
		return jwtResponce;
	}

	

}
