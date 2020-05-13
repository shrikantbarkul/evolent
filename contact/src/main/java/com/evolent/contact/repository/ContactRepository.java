package com.evolent.contact.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.evolent.contact.model.Contact;

public interface ContactRepository extends CrudRepository<Contact, Integer>{

	List<Contact> findByStatus(String status);
	
}
