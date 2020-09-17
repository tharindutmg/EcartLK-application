/**
 * 
 */
package com.ecart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecart.domain.AccessGroupMap;
import com.ecart.model.CommonCustomResponce;
import com.ecart.searvice.AccessGroupMapService;

/**
 * @author Tharindu   Feb 12, 2020
 *
 */
@CrossOrigin
@RestController
public class AccessGroupMapControler {
	
	public final String url = "/accessGroupMap";
	
	@Autowired
	public AccessGroupMapService sccessGroupMapService;
	
	@PostMapping(url)
	public CommonCustomResponce createUpdate(@RequestBody AccessGroupMap accessGroupMap) {
		return sccessGroupMapService.createUpdateAccessGroupMap(accessGroupMap);
	}

}
