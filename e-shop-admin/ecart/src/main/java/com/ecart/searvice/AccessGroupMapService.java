/**
 * 
 */
package com.ecart.searvice;

import com.ecart.domain.AccessGroupMap;
import com.ecart.domain.Stakeholder;
import com.ecart.model.CommonCustomResponce;

/**
 * @author Tharindu   Feb 12, 2020
 *
 */
public interface AccessGroupMapService {

	/**
	 * @param stakeholder
	 * @return
	 */
	CommonCustomResponce createUpdateAccessGroupMap(AccessGroupMap accessGroupMap);

}
