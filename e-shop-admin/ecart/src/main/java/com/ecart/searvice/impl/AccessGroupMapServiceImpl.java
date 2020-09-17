/**
 * 
 */
package com.ecart.searvice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecart.domain.AccessGroupMap;
import com.ecart.exception.ResourceNotFoundException;
import com.ecart.model.CommonCustomResponce;
import com.ecart.model.CommonMessages;
import com.ecart.repo.AccessGroupMapRepo;
import com.ecart.searvice.AccessGroupMapService;

/**
 * @author Tharindu   Feb 12, 2020
 *
 */
@Service
public class AccessGroupMapServiceImpl implements AccessGroupMapService{
	
	@Autowired
	private AccessGroupMapRepo accessGroupMapRepo;

	@Override
	public CommonCustomResponce createUpdateAccessGroupMap(AccessGroupMap accessGroupMap) {
		
		CommonCustomResponce comRe= new CommonCustomResponce();
		CommonMessages cm = new CommonMessages();
		try {
			
			if(getAccessGroupsMapById(accessGroupMap.getAccessGroupId())!=null) {
				accessGroupMapRepo.delete(accessGroupMap);
				
				accessGroupMapRepo.save(accessGroupMap);
			}else {
				accessGroupMapRepo.save(accessGroupMap);
			}
			comRe.setKey(cm.SUCCESS);
			comRe.setMessage(cm.CREATESUCCESS);
		} catch (Exception e) {
			System.out.println(e);
			comRe.setKey(cm.ERROR);
			comRe.setMessage(cm.SUMTHINGWRONG);
		}
		
		return comRe;
		
		
	}
	
	//@Override
	public AccessGroupMap getAccessGroupsMapById(Long id) {
		return accessGroupMapRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("AccessGroupMap", "id", id));
	}

}
