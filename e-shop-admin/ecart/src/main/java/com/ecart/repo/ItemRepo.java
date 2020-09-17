/**
 * 
 */
package com.ecart.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecart.domain.Item;

/**
 * @author Tharindu   Feb 27, 2020
 *
 */
public interface ItemRepo extends JpaRepository<Item, Long>{

}
