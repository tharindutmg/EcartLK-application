/**
 * 
 */
package com.ecart.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecart.domain.ProductCategory;

/**
 * @author Tharindu   Feb 19, 2020
 *
 */
@Repository
public interface ProductCategoryRepo extends JpaRepository<ProductCategory,Long>{

	/**
	 * @param productCategoryCode
	 * @return
	 */
	@Query("FROM ProductCategory WHERE code=:productCategoryCode")
	ProductCategory findByProductCategoryCode(String productCategoryCode);

}
