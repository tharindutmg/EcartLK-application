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
public class NavigationBadgeModel {
	private String variant;
	private String text;
	private long sequence;
	private Long navigationId;

}
