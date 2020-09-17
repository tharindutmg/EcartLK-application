/**
 * 
 */
package com.ecart.searvice;

import java.util.List;

import com.ecart.domain.Product;
import com.ecart.model.CommonCustomResponce;

/**
 * @author Tharindu   Feb 23, 2020
 *
 */
public interface ProductService {

	/**
	 * @param product
	 * @return
	 */
	CommonCustomResponce createUpdate(Product product);

	/**
	 * @return
	 */
	List<Product> getAll();

	/**
	 * @param id
	 * @return
	 */
	Product getById(Long id);

	/**
	 * @param id
	 * @return
	 */
	CommonCustomResponce delete(Long id);

}
