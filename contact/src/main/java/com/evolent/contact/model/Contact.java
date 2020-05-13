package com.evolent.contact.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@Entity
@ToString
public class Contact {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phoneNumber;
	
	private String status;
		
	private Date createdOn;		
	
	private Date modifiedOn;
	
}
