package com.evolent.contact.repository;

import org.springframework.data.repository.CrudRepository;

import com.evolent.contact.model.Contact;

public interface ContactRepository extends CrudRepository<Contact, Integer>{

}
