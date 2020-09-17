/**
 * 
 */
package com.ecart.searvice.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecart.domain.Item;
import com.ecart.exception.ResourceNotFoundException;
import com.ecart.model.CommonCustomResponce;
import com.ecart.model.CommonMessages;
import com.ecart.repo.ItemRepo;
import com.ecart.searvice.ItemService;
import com.ecart.searvice.ProductCategoryService;
import com.ecart.searvice.ProductService;

/**
 * @author Tharindu   Feb 27, 2020
 *
 */
@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemRepo itemRepo;
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductCategoryService productCatService;

	@Override
	public CommonCustomResponce createUpdate(Item item) {
		CommonCustomResponce comRe= new CommonCustomResponce();
		CommonMessages cm = new CommonMessages();
		if(item==null) {
			comRe.setKey(cm.ERROR);
			comRe.setMessage(cm.SUMTHINGWRONG);
			
		}else {
			if(item.getId()==null) {
				try {
					/*
					 * Item itemObj=null;
					 * productObj=itemRepo.findByItemCode(product.getCode());
					 */
					
					/*if(item==null) {
						comRe.setKey(cm.ERROR);
						comRe.setMessage(cm.ALRADYEXIS);
					}else {*/
						itemRepo.save(item);
						comRe.setKey(cm.SUCCESS);
						comRe.setMessage(cm.CREATESUCCESS);
					//}
					
				} catch (Exception e) {
					System.out.println(e);
					comRe.setKey(cm.ERROR);
					comRe.setMessage(cm.SUMTHINGWRONG);
					
				}
			}else {
				Item itemObj= getById(item.getId());
				if(itemObj!=null) {
					
					item.setId(itemObj.getId());
					try {
						itemRepo.save(item);
						comRe.setKey(cm.SUCCESS);
						comRe.setMessage(cm.UpdateSUCCESS);
					} catch (Exception e) {
						comRe.setKey(cm.ERROR);
						comRe.setMessage(cm.SUMTHINGWRONG);
						
					}
					
				}else {
					comRe.setKey(cm.ERROR);
					comRe.setMessage(cm.SUMTHINGWRONG);
				}
			}
		}
		return comRe;
	}

	@Override
	public List<Item> getAll() {
		List<Item> main = new ArrayList<Item>();
		for(Item item : itemRepo.findAll()) {
			item.setProductDiscription( productService.getById(item.getProductId()).getDescription() );
			item.setProductCatDiscription( productCatService.getById(item.getProductCategoryId()).getDescription() );
			main.add(item);
		}
		
		return main;
	}

	@Override
	public Item getById(Long id) {
		Item item=itemRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item", "id", id));
		
		item.setProductDiscription( productService.getById(item.getProductId()).getDescription() );
		item.setProductCatDiscription( productCatService.getById(item.getProductCategoryId()).getDescription() );
		
		return item;
	}

	@Override
	public CommonCustomResponce delete(Long id) {
		CommonCustomResponce comRe= new CommonCustomResponce();
		CommonMessages cm = new CommonMessages();
		try {
			Item item= getById(id);
			itemRepo.delete(item);
			comRe.setKey(cm.SUCCESS);
			comRe.setMessage(cm.DeleteSUCCESS);
		} catch (Exception e) {
			comRe.setKey(cm.ERROR);
			comRe.setMessage(cm.SUMTHINGWRONG);
		}
		
		return comRe;
	}

}
