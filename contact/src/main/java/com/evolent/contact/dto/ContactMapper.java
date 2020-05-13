package com.evolent.contact.dto;

import java.util.List;

import org.mapstruct.Mapper;

import com.evolent.contact.model.Contact;

@Mapper(componentModel = "spring")
public interface ContactMapper {
	ContactResponse mapContactToContactResponse(Contact contact);
	List<ContactResponse> mapContactListToContactResponseList(List<Contact> contact);
	Contact mapContactRequestToContact(ContactRequest contactRequest);
	List<Contact> mapContactRequestListToContactList(List<ContactRequest> contactRequest);
}
