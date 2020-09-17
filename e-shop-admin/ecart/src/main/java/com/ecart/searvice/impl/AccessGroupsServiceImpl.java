/**
 * 
 */
package com.ecart.searvice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecart.domain.AccessGroups;
import com.ecart.exception.ResourceNotFoundException;
import com.ecart.model.CommonCustomResponce;
import com.ecart.model.CommonMessages;
import com.ecart.repo.AccessGroupsRepo;
import com.ecart.searvice.AccessGroupsService;

/**
 * @author Tharindu   Feb 1, 2020
 *
 */
@Service
public class AccessGroupsServiceImpl implements AccessGroupsService{
	
	@Autowired
	private AccessGroupsRepo accessGroupsRepo;

	@Override
	public CommonCustomResponce createUpdateAccessGroups(AccessGroups accessGroups) {
		CommonCustomResponce comRe= new CommonCustomResponce();
		CommonMessages cm = new CommonMessages();
		if(accessGroups.getAccessGroupId()==null) {
			try {
				AccessGroups accessGroupsObj=null;
				accessGroupsObj=accessGroupsRepo.findByCode(accessGroups.getCode());
				
				if(accessGroupsObj!=null) {
					comRe.setKey(cm.ERROR);
					comRe.setMessage(cm.ALRADYEXIS);
				}else {
					accessGroupsRepo.save(accessGroups);
					comRe.setKey(cm.SUCCESS);
					comRe.setMessage(cm.CREATESUCCESS);
				}
				
			} catch (Exception e) {
				System.out.println(e);
				comRe.setKey(cm.ERROR);
				comRe.setMessage(cm.SUMTHINGWRONG);
				
			}
		}else {
			AccessGroups ag= getAccessGroupsById(accessGroups.getAccessGroupId());;
			if(ag!=null) {
				ag = accessGroups;
				try {
					accessGroupsRepo.save(ag);
					comRe.setKey(cm.SUCCESS);
					comRe.setMessage(cm.UpdateSUCCESS);
				} catch (Exception e) {
					comRe.setKey(cm.ERROR);
					comRe.setMessage(cm.SUMTHINGWRONG);
					
				}
				
			}else {
				comRe.setKey(cm.ERROR);
				comRe.setMessage(cm.SUMTHINGWRONG);
			}
		}
		
		return comRe;
	}

	@Override
	public CommonCustomResponce deleteAccessGroups(AccessGroups accessGroups) {
		CommonCustomResponce comRe= new CommonCustomResponce();
		CommonMessages cm = new CommonMessages();
		try {
			AccessGroups ag= getAccessGroupsById(accessGroups.getAccessGroupId());
			accessGroupsRepo.delete(ag);
			comRe.setKey(cm.SUCCESS);
			comRe.setMessage(cm.DeleteSUCCESS);
		} catch (Exception e) {
			comRe.setKey(cm.ERROR);
			comRe.setMessage(cm.SUMTHINGWRONG);
		}
		
		return comRe;
	}

	@Override
	public AccessGroups getAccessGroupsById(Long id) {
		return accessGroupsRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("AccessGroups", "id", id));
	}

	@Override
	public List<AccessGroups> getAll() {
		return accessGroupsRepo.findAll();
	}

}
