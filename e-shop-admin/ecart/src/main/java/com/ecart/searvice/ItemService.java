/**
 * 
 */
package com.ecart.searvice;

import java.util.List;

import com.ecart.domain.Item;
import com.ecart.model.CommonCustomResponce;

/**
 * @author Tharindu   Feb 27, 2020
 *
 */
public interface ItemService {

	/**
	 * @param product
	 * @return
	 */
	CommonCustomResponce createUpdate(Item item);

	/**
	 * @return
	 */
	List<Item> getAll();

	/**
	 * @param id
	 * @return
	 */
	Item getById(Long id);

	/**
	 * @param id
	 * @return
	 */
	CommonCustomResponce delete(Long id);

}
