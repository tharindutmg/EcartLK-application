/**
 * 
 */
package com.ecart.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecart.domain.Item;
import com.ecart.model.CommonCustomResponce;
import com.ecart.searvice.ItemService;

/**
 * @author Tharindu   Feb 27, 2020
 * 
 * 764428.55
 * 124428
 *
 */
@CrossOrigin
@RestController
public class ItemController {
	
	public final String url = "/item";
	
	@Autowired
	public ItemService itemService;
	
	@PostMapping(url)
	public CommonCustomResponce createUpdate(@RequestBody Item item) {
		return itemService.createUpdate(item);
	}
	
	@GetMapping(url)
	public List<Item> getAll() {
		return itemService.getAll();
	}
	
	@GetMapping(value=url+"/{id}")
	public Item getById(@PathVariable(value = "id") Long id) {
		return itemService.getById(id);
	}
	
	// Delete
	@DeleteMapping(url+"/{id}")
	public CommonCustomResponce delete(@PathVariable(value = "id") Long id) {
	    return itemService.delete(id);
	}
	
	@PostMapping(url+"/temporyImage")
	public Item gettemporyImage(@RequestPart("file") MultipartFile file,@RequestPart("number") String number){
		Item item=new Item(); 
		try {
			if(number.equals("1")) {
				item.setImageName1(file.getOriginalFilename());
				item.setImageData1(file.getBytes());
			}else if(number.equals("2")) {
				item.setImageName2(file.getOriginalFilename());
				item.setImageData2(file.getBytes());
			}else if(number.equals("3")) {
				item.setImageName3(file.getOriginalFilename());
				item.setImageData3(file.getBytes());
			}else if(number.equals("4")) {
				item.setImageName4(file.getOriginalFilename());
				item.setImageData4(file.getBytes());
			}
		
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		return item;
	}

}
