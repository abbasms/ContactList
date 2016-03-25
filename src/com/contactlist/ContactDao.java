package com.contactlist;

import java.util.*;

public class ContactDao {
	
	private static List<Contact> contactList = new ArrayList<Contact>();
	
	public List<Contact> getAllContacts() {		
		return contactList;
	}
	
	public Contact createContact(Contact contact) {
		//Could check for possible duplicates here if required
		contactList.add(contact);
		return contact;
	}
	
	public Contact getContact(String id) {		
		for (Contact storedContact: contactList) {
			if (storedContact.getId().equals(id))
				return storedContact;
		}
		
		return null; //Could also throw an error message saying "Contact not found"
	}
	
	public int updateContact(Contact contact) {
		for (Contact storedContact: contactList) {
			if (storedContact.getId().equals(contact.getId())) {
	            int index = contactList.indexOf(storedContact);			
	            contactList.set(index, contact);
	            return 1;
			}
		}
		return 0;
	}
	
	public int deleteContact(String id) {
		for (Contact storedContact: contactList) {
			if (storedContact.getId().equals(id)) {
	            int index = contactList.indexOf(storedContact);			
	            contactList.remove(index);
	            return 1;
			}
		}
		return 0;
	}
}
