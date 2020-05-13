package com.evolent.contact.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
public class Contact {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private Long phoneNumber;
	
	private Boolean isActive;
		
	private Date createdOn;
		
	private String createdBy;
	
	private Date modifiedOn;
	
	private String modifiedBy;
	
}
