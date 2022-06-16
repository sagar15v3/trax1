package com.trax.servicess;

import java.util.List;

import com.trax.entites.Contact;

public interface ContactServices {
	
	public void saveContact(Contact contact);
	public List<Contact> getAllContacts();
	public Contact findContactById(long id);

}
