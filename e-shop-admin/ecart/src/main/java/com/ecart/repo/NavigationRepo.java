/**
 * 
 */
package com.ecart.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecart.domain.Navigation;

/**
 * @author Tharindu   Jan 29, 2020
 *
 */
@Repository
public interface NavigationRepo extends JpaRepository<Navigation,Long>{

	/**
	 * @return
	 */
	@Query("FROM Navigation ORDER BY sequence ASC")
	List<Navigation> getNavigationTree();

}
