/**
 * 
 */
package com.ecart.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecart.domain.Discount;

/**
 * @author Tharindu   Mar 5, 2020
 *
 */
@Repository
public interface DiscountRepo extends JpaRepository<Discount, Long>{

	/**
	 * @param id
	 */
	@Query("FROM Discount WHERE itemId=:id")
	List<Discount> getDiscountsByItemId(Long id);

}
