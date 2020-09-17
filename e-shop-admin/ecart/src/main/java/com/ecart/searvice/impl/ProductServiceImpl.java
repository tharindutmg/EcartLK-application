/**
 * 
 */
package com.ecart.searvice.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecart.domain.Product;
import com.ecart.exception.ResourceNotFoundException;
import com.ecart.model.CommonCustomResponce;
import com.ecart.model.CommonMessages;
import com.ecart.repo.ProductRepo;
import com.ecart.searvice.ProductCategoryService;
import com.ecart.searvice.ProductService;

/**
 * @author Tharindu   Feb 23, 2020
 *
 */
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private ProductCategoryService productCategoryService;

	@Override
	public CommonCustomResponce createUpdate(Product product) {
		CommonCustomResponce comRe= new CommonCustomResponce();
		CommonMessages cm = new CommonMessages();
		if(product.getId()==null) {
			try {
				Product productObj=null;
				productObj=productRepo.findByProductCode(product.getCode());
				
				if(productObj!=null) {
					comRe.setKey(cm.ERROR);
					comRe.setMessage(cm.ALRADYEXIS);
				}else {
					productRepo.save(product);
					comRe.setKey(cm.SUCCESS);
					comRe.setMessage(cm.CREATESUCCESS);
				}
				
			} catch (Exception e) {
				System.out.println(e);
				comRe.setKey(cm.ERROR);
				comRe.setMessage(cm.SUMTHINGWRONG);
				
			}
		}else {
			Product productcat= getById(product.getId());
			if(productcat!=null) {
				
				product.setId(productcat.getId());
				try {
					productRepo.save(product);
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
	public List<Product> getAll() {
		List<Product> main = new ArrayList<Product>();
		for(Product product :productRepo.findAll()) {
			
			product.setPrdCatCode( productCategoryService.getById(product.getProductCategoryId()).getDescription()  );
			
			main.add(product);
		}
		return main;
	}

	@Override
	public Product getById(Long id) {
		return productRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
	}

	@Override
	public CommonCustomResponce delete(Long id) {
		CommonCustomResponce comRe= new CommonCustomResponce();
		CommonMessages cm = new CommonMessages();
		try {
			Product product= getById(id);
			productRepo.delete(product);
			comRe.setKey(cm.SUCCESS);
			comRe.setMessage(cm.DeleteSUCCESS);
		} catch (Exception e) {
			comRe.setKey(cm.ERROR);
			comRe.setMessage(cm.SUMTHINGWRONG);
		}
		
		return comRe;
	}

}
