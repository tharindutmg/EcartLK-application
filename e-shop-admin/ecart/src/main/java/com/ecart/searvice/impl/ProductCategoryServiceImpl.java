/**
 * 
 */
package com.ecart.searvice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecart.domain.ProductCategory;
import com.ecart.exception.ResourceNotFoundException;
import com.ecart.model.CommonCustomResponce;
import com.ecart.model.CommonMessages;
import com.ecart.repo.ProductCategoryRepo;
import com.ecart.searvice.ProductCategoryService;

/**
 * @author Tharindu   Feb 19, 2020
 *
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{
	
	@Autowired
	private ProductCategoryRepo productCategoryRepo;

	@Override
	public CommonCustomResponce createUpdate(ProductCategory productCategory) {
		CommonCustomResponce comRe= new CommonCustomResponce();
		CommonMessages cm = new CommonMessages();
		if(productCategory.getId()==null) {
			try {
				ProductCategory productCategoryObj=null;
				productCategoryObj=productCategoryRepo.findByProductCategoryCode(productCategory.getCode());
				
				if(productCategoryObj!=null) {
					comRe.setKey(cm.ERROR);
					comRe.setMessage(cm.ALRADYEXIS);
				}else {
					productCategoryRepo.save(productCategory);
					comRe.setKey(cm.SUCCESS);
					comRe.setMessage(cm.CREATESUCCESS);
				}
				
			} catch (Exception e) {
				System.out.println(e);
				comRe.setKey(cm.ERROR);
				comRe.setMessage(cm.SUMTHINGWRONG);
				
			}
		}else {
			ProductCategory productcat= getById(productCategory.getId());
			if(productcat!=null) {
				
				productCategory.setId(productcat.getId());
				try {
					productCategoryRepo.save(productCategory);
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
	public List<ProductCategory> getAll() {
		return productCategoryRepo.findAll();
	}
	
	@Override
	public ProductCategory getById(Long id) {
		return productCategoryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("ProductCategory", "id", id));
	}

	@Override
	public CommonCustomResponce delete(Long id) {
		CommonCustomResponce comRe= new CommonCustomResponce();
		CommonMessages cm = new CommonMessages();
		try {
			ProductCategory productCategory= getById(id);
			productCategoryRepo.delete(productCategory);
			comRe.setKey(cm.SUCCESS);
			comRe.setMessage(cm.DeleteSUCCESS);
		} catch (Exception e) {
			comRe.setKey(cm.ERROR);
			comRe.setMessage(cm.SUMTHINGWRONG);
		}
		
		return comRe;
	}

	

}
