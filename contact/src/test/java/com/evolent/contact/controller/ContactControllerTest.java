package com.evolent.contact.controller;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.evolent.contact.dto.ContactRequest;
import com.evolent.contact.dto.ContactRequest.ContactRequestBuilder;
import com.evolent.contact.dto.ContactResponse;
import com.evolent.contact.model.Contact;
import com.evolent.contact.service.exception.ContactException;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@ActiveProfiles("test")
@Slf4j
@TestMethodOrder(OrderAnnotation.class)
class ContactControllerTest {

	@Autowired
	ContactController contactController;

	ContactRequest contactRequest;

	@BeforeEach
	void setUp() throws Exception {
		log.info("Test Case Setup : Started");
		ContactRequestBuilder contactRequestBuilder = ContactRequest.builder().email("shrikantbarkul@gmail.com").firstName("Shrikant").id(1)
				.lastName("Barkul").phoneNumber("8600026600").status("Active");
		log.info("Builder Object {}" ,contactRequestBuilder);
		contactRequest = contactRequestBuilder.build();
		log.info("Test Case Setup : End");
	}

	@Test
	@Order(2)
	void testGetAllActiveContacts() {
		ResponseEntity<List<ContactResponse>> responseEntity = contactController.getAllActiveContacts();
		List<ContactResponse> contactResponseList = responseEntity.getBody();
		assertTrue(null != contactResponseList);
		assertTrue(contactResponseList.size() == 1);
	}

	@Test
	@Order(4)
	void testUpdateContact() {
		contactRequest.setEmail("shrikantbarkul@hotmail.com");
		contactRequest.setPhoneNumber("9284498568");
		contactRequest.setFirstName("firstName");
		contactRequest.setLastName("lastName");
		contactRequest.setStatus("Active");
		contactRequest.setId(1);
		ResponseEntity<Integer> responseEntity = contactController.updateContact(contactRequest);
		assertEquals(1, responseEntity.getBody());

	}

	@Test
	@Order(5)
	void testGetAllContacts() {
		ResponseEntity<List<ContactResponse>> responseEntity = contactController.getAllContacts();
		List<ContactResponse> contactResponseList = responseEntity.getBody();
		assertTrue(null != contactResponseList);
		assertTrue(contactResponseList.size() == 1);
	}

	@Test
	@Order(3)
	void testGetContact() throws ContactException {
		ResponseEntity<ContactResponse> responseEntity = contactController.getActiveContact(contactRequest.getId());		
		assertEquals(1, responseEntity.getBody().getId());
		log.info("Response : {} ", responseEntity.getBody().toString());		
	}

	@Test
	@Order(1)
	void testSaveContact() {
		log.info("Request {}", contactRequest);
		ResponseEntity<Integer> responseEntity = contactController.saveContact(contactRequest);		
		assertEquals(1, responseEntity.getBody());
	}

	@Test
	@Order(6)
	void testDeleteContact() throws ContactException {
		ResponseEntity<Integer> responseEntity = contactController.deleteContact(contactRequest.getId());
		assertEquals(1, responseEntity.getBody());
	}

	@Test
	@Order(7)
	void testGetAllActiveContactsAfterDelete() {
		ResponseEntity<List<ContactResponse>> responseEntity = contactController.getAllActiveContacts();
		List<ContactResponse> contactResponseList = responseEntity.getBody();
		assertTrue(null != contactResponseList);
		assertTrue(contactResponseList.size() == 0);
	}

	@Test
	@Order(8)
	void testGetContactAfterDelete() throws ContactException {
		
		assertThatExceptionOfType(ContactException.class)
		.isThrownBy(() -> contactController.getActiveContact(contactRequest.getId()));
		
	}
	
	@Test
	@Order(9)
	void testUpdateContactAfterDelete() {
		assertThatExceptionOfType(ContactException.class)
		.isThrownBy(() -> contactController.deleteContact(contactRequest.getId()));

	}
}
