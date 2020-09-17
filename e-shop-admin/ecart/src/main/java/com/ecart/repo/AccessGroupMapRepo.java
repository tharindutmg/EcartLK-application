/**
 * 
 */
package com.ecart.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecart.domain.AccessGroupMap;

/**
 * @author Tharindu   Feb 12, 2020
 *
 */
@Repository
public interface AccessGroupMapRepo extends JpaRepository<AccessGroupMap, Long>{

}
