/**
 * 
 */
package com.ecart.searvice.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecart.domain.Discount;
import com.ecart.domain.Item;
import com.ecart.exception.ResourceNotFoundException;
import com.ecart.model.CommonCustomResponce;
import com.ecart.model.CommonMessages;
import com.ecart.repo.DiscountRepo;
import com.ecart.searvice.DiscountService;
import com.ecart.searvice.ItemService;

/**
 * @author Tharindu   Mar 5, 2020
 *
 */
@Service
public class DiscountServiceImpl implements DiscountService{
	
	@Autowired
	private DiscountRepo discountRepo;
	
	@Autowired
	private ItemService itemService;

	@Override
	public CommonCustomResponce createUpdate(Discount discount) {
		CommonCustomResponce comRe= new CommonCustomResponce();
		CommonMessages cm = new CommonMessages();
		if(discount.getId()==null) {
			try {
				discountRepo.save(discount);
				comRe.setKey(cm.SUCCESS);
				comRe.setMessage(cm.CREATESUCCESS);
				
			} catch (Exception e) {
				System.out.println(e);
				comRe.setKey(cm.ERROR);
				comRe.setMessage(cm.SUMTHINGWRONG);
				
			}
		}else {
			Discount discountObj= getById(discount.getId());
			if(discountObj!=null) {
				
				discount.setId(discountObj.getId());
				try {
					discountRepo.save(discount);
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
		return comRe;
	}

	@Override
	public List<Discount> getAll() {
		return discountRepo.findAll();
	}

	@Override
	public Discount getById(Long id) {
		Discount discount = discountRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
		Item item = itemService.getById( discount.getItemId());
		discount.setItemDiscription( item.getItemDisplayName() );
		discount.setSellPrice(item.getSellPrice());
		return discount;
	}

	@Override
	public CommonCustomResponce delete(Long id) {
		CommonCustomResponce comRe= new CommonCustomResponce();
		CommonMessages cm = new CommonMessages();
		try {
			Discount product= getById(id);
			discountRepo.delete(product);
			comRe.setKey(cm.SUCCESS);
			comRe.setMessage(cm.DeleteSUCCESS);
		} catch (Exception e) {
			comRe.setKey(cm.ERROR);
			comRe.setMessage(cm.SUMTHINGWRONG);
		}
		
		return comRe;
	}

	@Override
	public List<Discount> getDiscountsById(Long id) {
		List<Discount> main = new ArrayList<Discount>();
		List<Discount> discountList = discountRepo.getDiscountsByItemId(id);
		
		for (Discount discount : discountList) {
			Item item = itemService.getById( discount.getItemId());
			
			discount.setItemCode(item.getCode());
			discount.setItemDiscription(item.getItemDisplayName());
			discount.setSellPrice(item.getSellPrice());
			main.add(discount);
		}
		
		return main;
	}

}
