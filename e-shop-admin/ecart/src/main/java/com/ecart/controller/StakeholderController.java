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

import com.ecart.domain.Stakeholder;
import com.ecart.model.CommonCustomResponce;
import com.ecart.searvice.StakeholderService;

/**
 * @author Tharindu   Jan 28, 2020
 * 
 * This class contain
 * . Registration
 * . update stakeholder
 * . delete stakeholder
 *
 */
@CrossOrigin
@RestController
public class StakeholderController {
	
	public final String url = "/stakeholder";
	
	@Autowired
	public StakeholderService stakeholderService;
	
	@PostMapping(url)
	public CommonCustomResponce createUpdateStakeholder(@RequestBody Stakeholder stakeholder) {
		return stakeholderService.createUpdateStakeholder(stakeholder);
	}
	
	@GetMapping(url+"/{userName}")
	public Stakeholder getUserByUserName(@PathVariable(value = "userName") String userName) {
		return stakeholderService.getUserByUserName(userName);
	}
	
	@GetMapping(url+"/id/{id}")
	public Stakeholder getUserById(@PathVariable(value = "id") Long id) {
		return stakeholderService.getStakeholdeById(id);
	}
	
	@GetMapping(url)
	public List<Stakeholder> getAllUsers() {
		return stakeholderService.getAllUsers();
	}

	/*
	 * @PutMapping(url+"/{id}") public CommonCustomResponce
	 * createStakeholder(@PathVariable(value="id") Long id,@RequestBody Stakeholder
	 * stakeholder) { return stakeholderService.createStakeholder(stakeholder); }
	 */
	
	// Delete a Note
	@DeleteMapping(url+"/{id}")
	public ResponseEntity<?> deleteStakeholder(@PathVariable(value = "id") Long id) {
		Stakeholder stakeholder=stakeholderService.getStakeholdeById(id);
		stakeholderService.deleteStakeholder(stakeholder);
	    return ResponseEntity.ok().build();
	}

}
