/**
 * 
 */
package com.ecart.searvice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecart.domain.Stakeholder;
import com.ecart.exception.ResourceNotFoundException;
import com.ecart.model.CommonCustomResponce;
import com.ecart.model.CommonMessages;
import com.ecart.repo.StakeholderRepo;
import com.ecart.searvice.StakeholderService;

/**
 * @author Tharindu   Jan 28, 2020
 *
 */
@Service
public class StakeholderServiceImpl implements StakeholderService{
	
	@Autowired
	public StakeholderRepo stakeholderRepo;
	
	static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Override
	public CommonCustomResponce createUpdateStakeholder(Stakeholder stakeholder) {
		Stakeholder stk =null;
		String password= null;
		CommonCustomResponce comRe = new CommonCustomResponce();
		CommonMessages cm = new CommonMessages();
		/* save stakeholder */
		if(stakeholder.getStakeholderId()==null) {
			
			try {
				if(stakeholder.getUserName() != null) {
					stk = stakeholderRepo.findByUserName(stakeholder.getUserName());
				}
			} catch (Exception e) {
				comRe.setKey(cm.ERROR);
				comRe.setMessage(cm.SUMTHINGWRONG);
			}
			
			if( stk == null ) {
				if(stakeholder.getPassword() != null) {
					password = getPasswordTash(stakeholder.getPassword());
					stakeholder.setPassword(password);
				}
				stakeholderRepo.save(stakeholder);
				comRe.setKey(cm.SUCCESS);
				comRe.setMessage(cm.CREATESUCCESS);
			}else {
				comRe.setKey(cm.ERROR);
				comRe.setMessage("User name alrady use..!!");
			}
		}else {
			/* Update stakeholder */
			Stakeholder stkh=stakeholderRepo.findById(stakeholder.getStakeholderId()).orElseThrow(() -> new ResourceNotFoundException("Stakeholder", "id", stakeholder.getStakeholderId()));
			
			try {
				if(stkh!=null) {
					stakeholder.setStakeholderId(stkh.getStakeholderId());;
					stakeholderRepo.save(stkh);
					comRe.setKey(cm.SUCCESS);
					comRe.setMessage(cm.UpdateSUCCESS);
				}else {
					comRe.setKey(cm.ERROR);
					comRe.setMessage(cm.SUMTHINGWRONG);
				}
				
			} catch (Exception e) {
				comRe.setKey(cm.ERROR);
				comRe.setMessage(cm.SUMTHINGWRONG);
			}
			
		}
		return comRe;
	}

    public static String getPasswordTash(String password) {
        return encoder.encode(password);
    }
	
	@Override
	public Stakeholder getUserByUserName(String userName) {
		return stakeholderRepo.findByUserName(userName);
	}

	@Override
	public Stakeholder getStakeholdeById(Long id) {
		return stakeholderRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Stakeholder", "id", id));
	}

	@Override
	public void deleteStakeholder(Stakeholder stakeholder) {
		Stakeholder stakeholderObj=stakeholderRepo.findById(stakeholder.getStakeholderId()).orElseThrow(() -> new ResourceNotFoundException("Stakeholder", "id", stakeholder.getStakeholderId()));
		stakeholderRepo.delete(stakeholderObj);
	}

	@Override
	public List<Stakeholder> getAllUsers() {
		return stakeholderRepo.findAll();
	}

}
