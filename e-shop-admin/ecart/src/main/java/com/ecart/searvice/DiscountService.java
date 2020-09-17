/**
 * 
 */
package com.ecart.searvice;

import java.util.List;

import com.ecart.domain.Discount;
import com.ecart.domain.Product;
import com.ecart.model.CommonCustomResponce;

/**
 * @author Tharindu   Mar 5, 2020
 *
 */
public interface DiscountService {

	/**
	 * @param product
	 * @return
	 */
	CommonCustomResponce createUpdate(Discount discount);

	/**
	 * @return
	 */
	List<Discount> getAll();

	/**
	 * @param id
	 * @return
	 */
	Discount getById(Long id);

	/**
	 * @param id
	 * @return
	 */
	CommonCustomResponce delete(Long id);

	/**
	 * @param id
	 * @return
	 */
	List<Discount> getDiscountsById(Long id);

}
