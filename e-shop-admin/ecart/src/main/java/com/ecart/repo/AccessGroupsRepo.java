/**
 * 
 */
package com.ecart.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecart.domain.AccessGroups;

/**
 * @author Tharindu   Feb 1, 2020
 *
 */
@Repository
public interface AccessGroupsRepo extends JpaRepository<AccessGroups, Long>{
	
	@Query("FROM AccessGroups WHERE code=:code")
	AccessGroups findByCode(String code);

}
