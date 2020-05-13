package com.evolent.contact.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContactRequest {

	@PositiveOrZero
	private Integer id;
	
	@NotEmpty(message = "Please enter FirstName")
	private String firstName;
	
	private String lastName;
	
	@Email(message = "{contact.email.invalid}")
    @NotEmpty(message = "Please enter email")
	private String email;
	
	@Pattern(regexp="(^$|[0-9]{10})", message="{contact.phoneNumber.invalid}")
	private String phoneNumber;
	
	@Pattern(regexp = "Active|Inactive", message="{contact.status.invalid}")
	private String status;
	
	private Date createdOn;		
	
	private Date modifiedOn;
}
