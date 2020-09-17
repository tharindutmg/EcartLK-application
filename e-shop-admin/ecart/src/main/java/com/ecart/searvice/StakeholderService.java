/**
 * 
 */
package com.ecart.searvice;

import java.util.List;

import com.ecart.domain.Stakeholder;
import com.ecart.model.CommonCustomResponce;

/**
 * @author Tharindu   Jan 28, 2020
 *
 */
public interface StakeholderService {

	/**
	 * @param stakeholder
	 */
	public CommonCustomResponce createUpdateStakeholder(Stakeholder stakeholder);

	/**
	 * @param userName
	 * @return
	 */
	public Stakeholder getUserByUserName(String userName);

	/**
	 * @param id
	 * @return
	 */
	public Stakeholder getStakeholdeById(Long id);

	/**
	 * @param stakeholder
	 */
	public void deleteStakeholder(Stakeholder stakeholder);

	/**
	 * @return
	 */
	public List<Stakeholder> getAllUsers();

	

}
