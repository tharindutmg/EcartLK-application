/**
 * 
 */
package com.ecart.searvice;

import java.util.List;

import com.ecart.domain.AccessControl;
import com.ecart.model.CommonCustomResponce;

/**
 * @author Tharindu   Feb 8, 2020
 *
 */
public interface AccessControlService {

	/**
	 * @param accessControl
	 * @return
	 */
	CommonCustomResponce createUpdateAccessControl(List<AccessControl> accessControlList);

}
