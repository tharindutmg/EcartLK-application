/**
 * 
 */
package com.ecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecart.domain.AccessGroups;
import com.ecart.model.CommonCustomResponce;
import com.ecart.searvice.AccessGroupsService;

/**
 * @author Tharindu   Feb 1, 2020
 *
 */
@CrossOrigin
@RestController
public class AccessGroupsController {
	
	public final String url = "/accessGroups";
	
	@Autowired
	public AccessGroupsService accessGroupsService;
	
	@PostMapping(value=url)
	public CommonCustomResponce saveAndUpdate(@RequestBody AccessGroups accessControlList) {
		return accessGroupsService.createUpdateAccessGroups(accessControlList);
	}
	
	@GetMapping(value=url)
	public List<AccessGroups> getAll() {
		return accessGroupsService.getAll();
	}
	
	@GetMapping(value=url+"/{id}")
	public AccessGroups getAccessGroupById(@PathVariable(value = "id") Long id) {
		return accessGroupsService.getAccessGroupsById(id);
	}
	
	// Delete a Note
	@DeleteMapping(url+"/{id}")
	public CommonCustomResponce delete(@PathVariable(value = "id") Long id) {
		AccessGroups accessGroups=accessGroupsService.getAccessGroupsById(id);
		CommonCustomResponce cr=accessGroupsService.deleteAccessGroups(accessGroups);
	    return cr;
	}

}
