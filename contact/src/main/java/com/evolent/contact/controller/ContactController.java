package com.evolent.contact.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evolent.contact.dto.ContactRequest;
import com.evolent.contact.dto.ContactResponse;
import com.evolent.contact.service.ContactService;
import com.evolent.contact.service.exception.ContactException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("v1/")
@Slf4j
@Api(tags = "Contact API")
public class ContactController {

	@Autowired
	ContactService contactService;
	
	@ApiOperation(value = "Get all active contacts", response = Iterable.class, notes= "Returning all active contacts",
			tags = "Contact API")
	@ApiResponses(value = {
			@ApiResponse( code= 200, message = "Success" , response = ResponseEntity.class),
			@ApiResponse( code= 400, message = "Bad Request"),
			@ApiResponse( code= 401, message = "Unauthorized"),
			@ApiResponse( code= 500, message = "Internal Server Error")
	})
	@GetMapping(value = "/contacts/active")
	public ResponseEntity<Iterable<ContactResponse>> getAllActiveContacts(){
		log.info("Inside getAllActiveContacts");
		return ResponseEntity.ok(contactService.getAllActiveContacts());
	}
	
	@ApiOperation(value = "Get all contacts", response = Iterable.class, notes= "Returning all contacts",
			tags = "Contact API")
	@ApiResponses(value = {
			@ApiResponse( code= 200, message = "Success" , response = ResponseEntity.class),
			@ApiResponse( code= 400, message = "Bad Request"),
			@ApiResponse( code= 401, message = "Unauthorized"),
			@ApiResponse( code= 500, message = "Internal Server Error")
	})
	@GetMapping(value = "/contacts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<ContactResponse>> getAllContacts(){
		log.info("Inside getAllContacts");
		return ResponseEntity.ok(contactService.getAllContacts());
	}
	
	@ApiOperation(value = "Get contact by id", response = Iterable.class, notes= "Return contact by id",
			tags = "Contact API")
	@ApiResponses(value = {
			@ApiResponse( code= 200, message = "Success" , response = ResponseEntity.class),
			@ApiResponse( code= 400, message = "Bad Request"),
			@ApiResponse( code= 401, message = "Unauthorized"),
			@ApiResponse( code= 500, message = "Internal Server Error")
	})
	@GetMapping(value = "/contact/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ContactResponse> getContact(@PathVariable Integer id) throws ContactException{
		log.info("Request get {} ", id);
		return ResponseEntity.ok(contactService.getContact(id));
	}
	
	@ApiOperation(value = "Save contact", response = Integer.class, notes= "Save contact",
			tags = "Contact API")
	@ApiResponses(value = {
			@ApiResponse( code= 200, message = "Success" , response = ResponseEntity.class),
			@ApiResponse( code= 400, message = "Bad Request"),
			@ApiResponse( code= 401, message = "Unauthorized"),
			@ApiResponse( code= 500, message = "Internal Server Error")
	})
	@PostMapping(value = "/contact", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> saveContact(@Valid @RequestBody ContactRequest contact){
		log.info("Request Save {} ", contact);
		return ResponseEntity.ok(contactService.saveContact(contact));
	}
	
	@PutMapping(value = "/contact" , consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> updateContact(@Valid @RequestBody ContactRequest contact){
		log.info("Request Update {} ", contact);
		return ResponseEntity.ok(contactService.updateContact(contact));
	}
	
	@ApiOperation(value = "Delete contact", response = Integer.class, notes= "Delete contact",
			tags = "Contact API")
	@ApiResponses(value = {
			@ApiResponse( code= 200, message = "Success" , response = ResponseEntity.class),
			@ApiResponse( code= 400, message = "Bad Request"),
			@ApiResponse( code= 401, message = "Unauthorized"),
			@ApiResponse( code= 500, message = "Internal Server Error")
	})
	@DeleteMapping(value = "/contact/{id}")
	public ResponseEntity<Integer> deleteContact(@PathVariable Integer id) throws ContactException{
		log.info("Request Delete id {} ", id);
		return ResponseEntity.ok(contactService.inactiveContact(id));
	}
}
