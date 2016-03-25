package com.contactlist;

import java.util.UUID;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "contact")
public class Contact {
	
	private String id;
	private String name;
	private String number;
	
	public Contact() {}
	
	public Contact(String name, String number) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.number = number;
	}
	
	public Contact(String id, String name, String number) {
		this.id = id;
		this.name = name;
		this.number = number;
	}
	
	@XmlElement
	public void setId(String id) {
		this.id = id;
	}
	
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getNumber() {
		return number;
	}
	
   @Override
   public boolean equals(Object object){
      if(object == null){
         return false;
      }else if(!(object instanceof Contact)){
         return false;
      }else {
         Contact contact = (Contact) object;
         if(id.equals(contact.getId())
        	&& name.equals(contact.getName())
            && number.equals(contact.getNumber())
         ){
            return true;
         }			
      }
      return false;
   }	

}
