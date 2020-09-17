/**
 * 
 */
package com.ecart.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * @author Tharindu   Feb 27, 2020
 *
 */

@Entity
@Table(name = "item")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@Data
public class Item {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "product_id")
	private Long productId;
	
	@Transient
	private String productDiscription;
	
	@Column(name = "product_cat_id")
	private Long productCategoryId;
	
	@Transient
	private String productCatDiscription;
	
	@Column(name = "dispaly_name")
	private String itemDisplayName;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "sell_price")
	private String sellPrice;
	
	@Column(name = "avalability")
	private String avalability;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "discription")
	private String discription;
	
	@Column(name = "details")
	private String details;
	
	@Column(name = "size")
	private String size;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "quntity")
	private String quntity;
	
	//image 1
	@Lob
	@Column(name = "image_ata_1")
	private byte[] imageData1;
	
	@Column(name = "image_name_1")
	private String imageName1;
	
	//image 2
	@Lob
	@Column(name = "image_ata_2")
	private byte[] imageData2;
	
	@Column(name = "image_name_2")
	private String imageName2;
	
	//image 3
	@Lob
	@Column(name = "image_ata_3")
	private byte[] imageData3;
	
	@Column(name = "image_name_3")
	private String imageName3;
	
	//image 4
	@Lob
	@Column(name = "image_ata_4")
	private byte[] imageData4;
	
	@Column(name = "image_name_4")
	private String imageName4;
	
	@Transient
	private String base64Image;

}
