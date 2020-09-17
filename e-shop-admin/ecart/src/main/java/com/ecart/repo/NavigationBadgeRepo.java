/**
 * 
 */
package com.ecart.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecart.domain.NavigationBadge;

/**
 * @author Tharindu   Jan 29, 2020
 *
 */
@Repository
public interface NavigationBadgeRepo extends JpaRepository<NavigationBadge,Long>{

	/**
	 * @return
	 */
	@Query("FROM NavigationBadge WHERE navigationId=:navigationId ORDER BY sequence ASC")
	public NavigationBadge getNavigationBadgeByNavigationId(Long navigationId);

}
