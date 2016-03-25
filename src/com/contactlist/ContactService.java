package com.contactlist;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;

@Path("/ContactService")
public class ContactService {
	ContactDao contactDao = new ContactDao();
	private static final String SUCCESS_MESSAGE="<result>success</result>";
	private static final String FAILURE_MESSAGE="<result>failure</result>";

   @GET
   @Path("/contacts")
   @Produces(MediaType.APPLICATION_XML)
   public List<Contact> getContacts() {
      return contactDao.getAllContacts();
   }
   
   @GET
   @Path("/contacts/{id}")
   @Produces(MediaType.APPLICATION_XML)
   public Contact getContact(@PathParam("id") String id) {
	   //Validation checks
	   //Normalize number
	   return contactDao.getContact(id);
   }
   
   @PUT
   @Path("/contacts")
   @Produces(MediaType.APPLICATION_XML)
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public Contact createContact(@FormParam("name") String name,
		      @FormParam("number") String number,
		      @Context HttpServletResponse servletResponse) throws Exception { 
	   Contact contact = new Contact(name, number);
	   return contactDao.createContact(contact);	   
   }

   @POST
   @Path("/contacts")
   @Produces(MediaType.APPLICATION_XML)
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public String updateContact(@FormParam("id") String id,
		   	  @FormParam("name") String name,
		      @FormParam("number") String number,
		      @Context HttpServletResponse servletResponse) throws Exception {
	  Contact contact = new Contact(id, name, number);   
      if(contactDao.updateContact(contact) == 1){
         return SUCCESS_MESSAGE;
      }
      return FAILURE_MESSAGE;
   }

   @DELETE
   @Path("/contacts/{id}")
   @Produces(MediaType.APPLICATION_XML)
   public String deleteUser(@PathParam("id") String id) {
      if(contactDao.deleteContact(id) == 1){
         return SUCCESS_MESSAGE;
      }
      return FAILURE_MESSAGE;
   }
   
}