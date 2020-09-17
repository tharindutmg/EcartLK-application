/**
 * 
 */
package com.ecart.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecart.domain.Stakeholder;

/**
 * @author Tharindu   Jan 28, 2020
 *
 */
@Repository
public interface StakeholderRepo extends JpaRepository<Stakeholder,Long>{
	
	public Stakeholder findByUserNameIgnoreCase(String username); // this method use for login
	
	public Stakeholder findByUserName(String userName);

}
