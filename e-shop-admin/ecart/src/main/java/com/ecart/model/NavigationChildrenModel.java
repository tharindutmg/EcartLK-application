/**
 * 
 */
package com.ecart.model;

import lombok.Data;

/**
 * @author Tharindu   Jan 29, 2020
 *
 */
@Data
public class NavigationChildrenModel {
	private String name;
	private String url;
	private String icon;
	private long sequence;
	private Long navigationId;
	private Long navigationChildrenId;
}
