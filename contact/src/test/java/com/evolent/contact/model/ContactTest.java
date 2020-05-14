package com.evolent.contact.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class ContactTest {

	@Test
	void test() {
		Contact ob1 = new Contact();
		ob1.setId(10);
		ob1.setCreatedOn(new Date());
		ob1.setEmail("abc@test.com");
		ob1.setFirstName("testFName");
		ob1.setLastName("testLName");
		ob1.setModifiedOn(new Date());
		ob1.setPhoneNumber("8600026600");
		ob1.setStatus("Active");
		
		Contact ob2 = new Contact();
		ob2.setId(10);
		ob2.setCreatedOn(new Date());
		ob2.setEmail("abc@test.com");
		ob2.setFirstName("testFName");
		ob2.setLastName("testLName");
		ob2.setModifiedOn(new Date());
		ob2.setPhoneNumber("8600026600");
		ob2.setStatus("Active");
		
		assertEquals(ob1, ob2);
		log.info("Hash Code ob1 {}", ob1.hashCode());
		log.info("Hash Code ob2 {}", ob2.hashCode());
		ob2.setStatus("Inactive");
		assertNotEquals(ob1, ob2);
		log.info("Hash Code ob1 {}", ob1.hashCode());
		log.info("Hash Code ob2 {}", ob2.hashCode());
	}

}
