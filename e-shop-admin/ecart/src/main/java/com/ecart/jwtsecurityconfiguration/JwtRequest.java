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
public class JwtRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;

	private String userName;

	private String password;

	//need default constructor for JSON Parsing

	public JwtRequest(){}

	public JwtRequest(String username, String password) {
		this.setUserName(username);
		this.setPassword(password);
	}

	
}
