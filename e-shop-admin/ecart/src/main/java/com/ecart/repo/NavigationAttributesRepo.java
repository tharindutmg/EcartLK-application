/**
 * 
 */
package com.ecart.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecart.domain.NavigationAttributes;

/**
 * @author Tharindu   Jan 29, 2020
 *
 */
@Repository
public interface NavigationAttributesRepo extends JpaRepository<NavigationAttributes,Long>{

	/**
	 * 
	 */
	public NavigationAttributes getNavigationAttributesByNavigationId(Long navigationId);

}
