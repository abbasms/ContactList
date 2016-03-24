package com.contactlist;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ContactService")
public class ContactService {
	ContactDao contactDao = new ContactDao();


   @GET
   @Path("/contacts")
   @Produces(MediaType.APPLICATION_JSON)
   public List<Contact> getContacts(){
      return contactDao.getAllContacts();
   }	
}