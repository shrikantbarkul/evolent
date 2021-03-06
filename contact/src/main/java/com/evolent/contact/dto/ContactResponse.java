package com.evolent.contact.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ContactResponse {
	
	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phoneNumber;
	
	private String status;
	
	private Date createdOn;		
	
	private Date modifiedOn;
}
