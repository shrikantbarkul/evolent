package com.evolent.contact.service;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.evolent.contact.service.exception.ContactException;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("v1/")
@Slf4j
public class ContactController {

	@Autowired
	ContactService contactService;
	
	@GetMapping(value = "/contacts/active")
	public ResponseEntity<Iterable<ContactResponse>> getAllActiveContacts(){
		log.info("Inside getAllContacts");
		return ResponseEntity.ok(contactService.getAllActiveContacts());
	}
	
	@GetMapping(value = "/contacts")
	public ResponseEntity<Iterable<ContactResponse>> getAllContacts(){
		log.info("Inside getAllContacts");
		return ResponseEntity.ok(contactService.getAllContacts());
	}
	
	@GetMapping(value = "/contact/{id}")
	public ResponseEntity<ContactResponse> getContact(@PathVariable Integer id) throws ContactException{
		log.info("Request get {} ", id);
		return ResponseEntity.ok(contactService.getContact(id));
	}
	
	@PostMapping(value = "/contact")
	public ResponseEntity<Integer> saveContact(@RequestBody ContactRequest contact){
		log.info("Request Save {} ", contact);
		return ResponseEntity.ok(contactService.saveContact(contact));
	}
	
	@PutMapping(value = "/contact")
	public ResponseEntity<Integer> updateContact(@RequestBody ContactRequest contact){
		log.info("Request Update {} ", contact);
		return ResponseEntity.ok(contactService.updateContact(contact));
	}
	
	@DeleteMapping(value = "/contact/{id}")
	public ResponseEntity<Integer> deleteContact(@PathVariable Integer id) throws ContactException{
		log.info("Request Delete id {} ", id);
		return ResponseEntity.ok(contactService.inactiveContact(id));
	}
}
