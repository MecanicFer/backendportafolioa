package com.portafolioa.backendportafolioa.service;

import java.util.List;

import com.portafolioa.backendportafolioa.entity.Contact;
import com.portafolioa.backendportafolioa.model.ContactModel;

public interface ContactService {
	
	public abstract ContactModel addContact(ContactModel contactModel);
	
	public abstract List<ContactModel> ListAllContacts();
	
	public abstract Contact findContactById(int id);
	
	public abstract void removeContact(int id);
	
	public abstract ContactModel findContactByIdModel(int id);

}
