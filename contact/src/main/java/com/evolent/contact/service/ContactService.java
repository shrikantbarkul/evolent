package com.evolent.contact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evolent.contact.model.Contact;
import com.evolent.contact.repository.ContactRepository;

@Service
public class ContactService {

	@Autowired
	ContactRepository contactRepository;

	public Iterable<Contact> getAllContacts() {
		// TODO Auto-generated method stub
		return null;
	}

	public Contact getContact(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer saveContact(Contact contact) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer updateContact(Contact contact) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer inactiveContact(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
