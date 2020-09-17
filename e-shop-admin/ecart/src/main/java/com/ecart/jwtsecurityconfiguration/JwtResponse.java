/**
 * 
 */
package com.ecart.jwtsecurityconfiguration;

import java.io.Serializable;

import lombok.Data;

/**
 * @author Tharindu Jan 27, 2020
 *
 */
@Data
public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;

	private String jwttoken;
	
	private String key;
	
	private String message;
	
	private String role;
	
	

	/*
	 * public JwtResponse(String jwttoken) { this.jwttoken = jwttoken; }
	 */

	
}
