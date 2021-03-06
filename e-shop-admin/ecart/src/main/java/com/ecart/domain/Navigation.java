/**
 * 
 */
package com.ecart.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * @author Tharindu   Jan 29, 2020
 *
 */

@Entity
@Table(name = "navigation")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@Data
public class Navigation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "navigation_id")
	private Long navigationId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "url")
	private String url ;
	
	@Column(name = "icon")
	private String icon;
	
	@Column(name = "badge_id")
	private Long badgeId;
	
	@Column(name = "children_id")
	private Long childrenId;
	
	@Column(name = "attributes_id")
	private Long attributesId;
	
	@Column(name = "sequence")
	private long sequence;
	
	@Column(name = "add_by")
	private Long addBy;
	
	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

}
