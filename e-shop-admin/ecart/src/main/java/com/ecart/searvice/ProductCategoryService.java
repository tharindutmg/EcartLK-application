/**
 * 
 */
package com.ecart.searvice;

import java.util.List;

import com.ecart.domain.ProductCategory;
import com.ecart.model.CommonCustomResponce;

/**
 * @author Tharindu   Feb 19, 2020
 *
 */
public interface ProductCategoryService {

	/**
	 * @param productCategory
	 * @return
	 */
	CommonCustomResponce createUpdate(ProductCategory productCategory);

	/**
	 * @return
	 */
	List<ProductCategory> getAll();

	/**
	 * @param id
	 * @return
	 */
	ProductCategory getById(Long id);

	/**
	 * @param productCategory
	 * @return
	 */
	CommonCustomResponce delete(Long id);

}
