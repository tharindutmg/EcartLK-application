/**
 * 
 */
package com.ecart.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecart.domain.AccessControl;

/**
 * @author Tharindu   Feb 9, 2020
 *
 */
@Repository
public interface AccessControlDao extends JpaRepository<AccessControl, Long>{

	/**
	 * @return
	 */
	@Query("FROM AccessControl WHERE accessGroupId=:accessGroupId")
	List<AccessControl> getAccessControlByAccessGroupId(Long accessGroupId);

}
