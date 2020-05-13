package com.evolent.contact.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import com.evolent.contact.dto.ContactRequest;
import com.evolent.contact.dto.ContactResponse;
import com.evolent.contact.model.Contact;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ContactMapper {

	ContactResponse mapContactToContactResponse(Contact contact);
	List<ContactResponse> mapContactListToContactResponseList(List<Contact> contact);
	
	Contact mapContactRequestToContact(ContactRequest contactRequest);
	List<Contact> mapContactRequestListToContactList(List<ContactRequest> contactRequest);
}
