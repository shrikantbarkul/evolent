package com.evolent.contact.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;

import com.evolent.contact.model.Contact;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ContactMapper {

	ContactResponse mapContactToContactResponse(Contact contact);
	List<ContactResponse> mapContactListToContactResponseList(List<Contact> contact);
	
	Contact mapContactRequestToContact(ContactRequest contactRequest);
	List<Contact> mapContactRequestListToContactList(List<ContactRequest> contactRequest);
}
