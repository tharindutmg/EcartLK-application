/**
 * 
 */
package com.ecart.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * @author Tharindu   Jan 28, 2020
 *
 */
@Entity
@Table(name = "stakeholder")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@Data
public class Stakeholder {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stakeholder_id")
    private Long stakeholderId;

	/*
	 * @Column(name = "stakeholder_type_code") private String stakeholderTypeCode;
	 */
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "middle_name")
	private String middleName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "nic")
	private String nic;
	
	@Column(name = "is_active")
	private String isActive; // 1-Active 0- Inactive
	
	@Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;
    

    @Column(name = "role")
    private String stakeholderType;
	
	/*
	 * @Column(name = "password") private String password;
	 */
	
	@Column(name = "initials")
	private String initials;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "profile_picture")
	private byte[] profilePicture;
	
	@Column(name = "mobile_no")
	private String mobileNo;
	
	@Column(name = "address_line1")
	private String addressLine1;
	
	@Column(name = "address_line2")
	private String addressLine2;
	
	@Column(name = "address_line3")
	private String addressLine3;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

}
