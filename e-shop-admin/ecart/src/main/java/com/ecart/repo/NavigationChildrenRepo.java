/**
 * 
 */
package com.ecart.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecart.domain.NavigationChildren;
import com.ecart.model.NavigationChildrenModel;

/**
 * @author Tharindu   Jan 29, 2020
 *
 */
@Repository
public interface NavigationChildrenRepo extends JpaRepository<NavigationChildren,Long>{

	/**
	 * @param navigationId
	 * @return
	 */
	@Query("FROM NavigationChildren WHERE navigationId=:navigationId ORDER BY sequence ASC")
	public List<NavigationChildren> getNavigationChildByNavigationId(Long navigationId);

}
