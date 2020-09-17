/**
 * 
 */
package com.ecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecart.domain.AccessControl;
import com.ecart.model.CommonCustomResponce;
import com.ecart.searvice.AccessControlService;
import com.ecart.searvice.AccessGroupsService;

/**
 * @author Tharindu   Feb 8, 2020
 *
 */
@CrossOrigin
@RestController
public class AccessControlControler {
	
public final String url = "/access-control";
	
	@Autowired
	public AccessControlService accessGroupsService;
	
	@PostMapping(value=url)
	public CommonCustomResponce saveAndUpdate(@RequestBody List<AccessControl> accessControl) {
		return accessGroupsService.createUpdateAccessControl(accessControl);
	}

}
