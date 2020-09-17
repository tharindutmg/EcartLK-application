/**
 * 
 */
package com.ecart.model;

import java.util.List;

import com.ecart.domain.NavigationAttributes;
import com.ecart.domain.NavigationBadge;
import com.ecart.domain.NavigationChildren;

import lombok.Data;

/**
 * @author Tharindu   Jan 29, 2020
 *
 */
@Data
public class NavigationModel {
	private Long navigationId;
	private String name;
	private String url ;
	private String icon;
	private long sequence;
	private NavigationBadgeModel badge;
	private List<NavigationChildrenModel> children;
	private NavigationAttributesModel attributes;
}
