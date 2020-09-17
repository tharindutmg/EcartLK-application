package com.ecart.model;

import lombok.Data;

@Data
public class CommonCustomResponce {
	
	
	public String key;
	public String message;
	
	/**
	 * @param key
	 * @param message
	 */
	public CommonCustomResponce(String key, String message) {
		super();
		this.key = key;
		this.message = message;
	}

	/**
	 * 
	 */
	public CommonCustomResponce() {
		// TODO Auto-generated constructor stub
	}
}
