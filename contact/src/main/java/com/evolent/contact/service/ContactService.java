package com.evolent.contact.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.evolent.contact.dto.ContactRequest;
import com.evolent.contact.dto.ContactResponse;
import com.evolent.contact.mapper.ContactMapper;
import com.evolent.contact.model.Contact;
import com.evolent.contact.repository.ContactRepository;
import com.evolent.contact.service.exception.ContactException;
import com.evolent.contact.util.ContactConstant;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ContactService {

	@Autowired
	ContactRepository contactRepository;

	@Autowired
	ContactMapper contactMapper;
	
	public List<ContactResponse> getAllActiveContacts() {
		List<Contact> contactList = contactRepository.findByStatus(ContactConstant.ACTIVE);
		log.info("Number of contact found {} " + contactList.size());		
		return contactMapper.mapContactListToContactResponseList(contactList);
	}
	
	public List<ContactResponse> getAllContacts() {
		List<Contact> contactList =  new ArrayList<>();
		contactRepository.findAll().iterator().forEachRemaining(contactList::add);
		log.info("Number of contact found {} " + contactList.size());
		return contactMapper.mapContactListToContactResponseList(contactList);
	}

	public ContactResponse getActiveContact(Integer id) throws ContactException {
		List<Contact> contactList = contactRepository.findByIdAndStatus(id, "Active");
		if(CollectionUtils.isEmpty(contactList)) {
			throw new ContactException("Contact Not Found for id =" + id);
		} else {			
			Contact contact = contactList.get(0);
			log.info("Received Contact {}", contact);
			return contactMapper.mapContactToContactResponse(contact);
		}
	}

	public Integer saveContact(ContactRequest contactRequest) {
		Contact contact =  contactMapper.mapContactRequestToContact(contactRequest);
		contact.setCreatedOn(Date.from(LocalDateTime.now().atOffset(ZoneOffset.UTC).toInstant()));
		contact = contactRepository.save(contact);
		return contact.getId();
	}

	public Integer updateContact(ContactRequest contactRequest) {
		Contact contact =  contactMapper.mapContactRequestToContact(contactRequest);
		contact.setModifiedOn(Date.from(LocalDateTime.now().atOffset(ZoneOffset.UTC).toInstant()));
		log.info("Update Entity {}", contact);
		contact = contactRepository.save(contact);
		return contact.getId();
	}

	public Integer inactiveContact(Integer id) throws ContactException {
		List<Contact> contactList = contactRepository.findByIdAndStatus(id, "Active");
		if(CollectionUtils.isEmpty(contactList)) {
			throw new ContactException("Contact Not Found for id =" + id);
		} else {			
			Contact contact = contactList.get(0);
			contact.setStatus(ContactConstant.INACTIVE);
			contact = contactRepository.save(contact);
			return contact.getId();
		}
	}
	
	
}
