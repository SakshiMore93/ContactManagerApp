package com.jspiders.ContactManager.entity;

public class Contact {
	private int id;
	private String firstName;
	private String lastname;
	private long phoneNumber;
	private String Email;

	public Contact(int id, String firstName, String lastName, long phoneNumber, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastname = lastName;
		this.phoneNumber = phoneNumber;
		this.Email = email;
		
	}
	public int getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public String getEmail() {
		return Email;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setContact(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setEmail(String email) {
		this.Email = email;
	}
	
}
