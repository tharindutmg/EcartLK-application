package com.ecart.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * Created by Tharindu on 2/25/2019.
 */

/*
 * @Entity
 * 
 * @Table(name = "user_login")
 * 
 * @EntityListeners(AuditingEntityListener.class)
 * 
 * @JsonIgnoreProperties(value = {"createdAt", "updatedAt"},allowGetters = true)
 * 
 * @Data public class User implements Serializable{
 *//**
	* 
	*//*
		 * private static final long serialVersionUID = -2264041110253822918L;
		 * 
		 * @Id
		 * 
		 * @GeneratedValue(strategy = GenerationType.IDENTITY)
		 * 
		 * @Column(name = "user_id") private Long userId;
		 * 
		 * @Column(name = "user_name") private String userName;
		 * 
		 * @Column(name = "password") private String password;
		 * 
		 * @Column(name = "enabled") private boolean enabled;
		 * 
		 * @Column(name = "role") private String role;
		 * 
		 * @OneToOne(mappedBy="user") private Stakeholder stakeholder;
		 * 
		 * @Column(nullable = false, updatable = false)
		 * 
		 * @Temporal(TemporalType.TIMESTAMP)
		 * 
		 * @CreatedDate private Date createdAt;
		 * 
		 * @Column(nullable = false)
		 * 
		 * @Temporal(TemporalType.TIMESTAMP)
		 * 
		 * @LastModifiedDate private Date updatedAt;
		 * 
		 * 
		 * 
		 * 
		 * }
		 */
