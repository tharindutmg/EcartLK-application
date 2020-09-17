/**
 * 
 */
package com.ecart.searvice.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecart.domain.AccessControl;
import com.ecart.model.CommonCustomResponce;
import com.ecart.model.CommonMessages;
import com.ecart.repo.AccessControlDao;
import com.ecart.searvice.AccessControlService;

/**
 * @author Tharindu   Feb 8, 2020
 *
 */
@Service
public class AccessControlServiceImpl implements AccessControlService{
	
	@Autowired
	private AccessControlDao accessControlDao;

	@Override
	public CommonCustomResponce createUpdateAccessControl(List<AccessControl> accessControlList) {
		CommonCustomResponce comRe= new CommonCustomResponce();
		CommonMessages cm = new CommonMessages();
		try {
			for(AccessControl accessControl :accessControlList) {
				deleteExisRecords(accessControl.getAccessGroupId());
				break;
			}
			
			accessControlDao.saveAll(accessControlList);
			
			comRe.setKey(cm.SUCCESS);
			comRe.setMessage(cm.CREATESUCCESS);
		} catch (Exception e) {
			System.out.println(e);
			comRe.setKey(cm.ERROR);
			comRe.setMessage(cm.SUMTHINGWRONG);
		}
		
		return comRe;
	}
	
	
	public void deleteExisRecords(Long accessGroupId) throws Exception{
		
		List<AccessControl> accessControlDe = accessControlDao.getAccessControlByAccessGroupId(accessGroupId);
		if(!accessControlDe.isEmpty()) 
			accessControlDao.deleteAll(accessControlDe);
		
	}

}
