/**
 * 
 */
package com.ecart.searvice;

import java.util.List;

import com.ecart.domain.AccessGroups;
import com.ecart.model.CommonCustomResponce;

/**
 * @author Tharindu   Feb 1, 2020
 *
 */
public interface AccessGroupsService {

	/**
	 * @param accessGroups
	 * @return
	 */
	CommonCustomResponce createUpdateAccessGroups(AccessGroups accessGroups);

	/**
	 * @param accessGroups
	 */
	CommonCustomResponce deleteAccessGroups(AccessGroups accessGroups);

	/**
	 * @param userName
	 * @return
	 */
	AccessGroups getAccessGroupsById(Long id);

	/**
	 * @return
	 */
	List<AccessGroups> getAll();

	

}
