/**
 * 
 */
package com.ecart.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecart.domain.Product;

/**
 * @author Tharindu   Feb 23, 2020
 *
 */
@Repository
public interface ProductRepo extends JpaRepository<Product,Long>{

	/**
	 * @param code
	 * @return
	 */
	@Query("FROM Product WHERE code=:code")
	Product findByProductCode(String code);

}
