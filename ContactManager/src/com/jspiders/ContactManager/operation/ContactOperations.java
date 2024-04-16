package com.jspiders.ContactManager.operation;

import java.util.ArrayList;
import java.util.Scanner;

import com.jspiders.ContactManager.entity.Contact;

public class ContactOperations {
	
		private static ArrayList<Contact> contacts = new ArrayList<>();

//Delete the contacts
	public static void deleteContact() {
		viewAllContacts();
		System.out.println("Enter id");
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		int id=scanner.nextInt();
		Contact contactToBeDeleted=null;
		for (Contact contact : contacts) {
			if (contact.getId()==id) {
				contactToBeDeleted=contact;
						break;
			}
		}
		if (contactToBeDeleted != null) {
			contacts.remove(contactToBeDeleted);
			System.out.println("Contact deleted");
		} else {
			System.out.println("Contact not found");
		}
		
		
		
	}

//View all Contacts
	public static void viewAllContacts() {
		
		for (Contact contact : contacts) {
			System.out.println("ID:"+contact.getId()+", FIRSTNAME:"+contact.getFirstName()+", LASTNAME:"+contact.getLastname()+", CONTACT:"+ contact.getPhoneNumber()+", Email:"+contact.getEmail());
		}
	}



//Add the contacts
	public void addContact(Scanner scanner1){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter ID:"); 
		int id = scanner.nextInt();
         scanner.nextLine();
        System.out.print("Enter First Name:");
        String firstName = scanner.nextLine();
        
        System.out.print("Enter Last Name:");
        String lastName = scanner.nextLine();
        
        System.out.print("Enter Phone Number:");
		long phoneNumber = scanner.nextLong();
		scanner.nextLine();
		System.out.print("Enter the Email Address:");
		String Email = scanner.nextLine();		
		Contact contact = new Contact(id,firstName,lastName,phoneNumber,Email);
  	    contacts.add(contact);
      
        System.out.println("Contact added Successfully");  
        		
	}


//Edit the contacts
	public void editContacts() {
		viewAllContacts();
		System.out.println("Enter ID of the contact to edit:");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();
		Contact contactToBeEdited = null;
		for (Contact contact : contacts) {
			if (contact.getId()== id) {
				contactToBeEdited = contact;
				break;
			}
			}
		if (contactToBeEdited != null) {
			System.out.println("Enter new first name:");
			String newFirstName = scanner.next();
			contactToBeEdited.setFirstName(newFirstName);
			System.out.println("Enter new last name:");
			String newLastName = scanner.next();
			contactToBeEdited.setLastname(newLastName);
			System.out.println("Enter new contact:");
			long newPhoneNumber = scanner.nextLong();
			contactToBeEdited.setContact(newPhoneNumber);
			System.out.println("Contact edited Successfully");
			
		} else {
            System.out.println("Contact not found!!");
		}
		
	}

//Search Contacts
	public void searchContacts() {
		System.out.println("Enter Id ,First Name, or Last Name to search contact:");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		 String searchCriteria = scanner.nextLine();
		
		 boolean f= false;
		 for (Contact contact : contacts) {
			if (searchCriteria.equalsIgnoreCase(String.valueOf(contact.getId()))||
				searchCriteria.equalsIgnoreCase(contact.getFirstName())||
				searchCriteria.equalsIgnoreCase(contact.getLastname())) {
				System.out.println("Contact found:");
				System.out.println("ID:"+contact.getId()+", FIRSTNAME:"+contact.getFirstName()+", LASTNAME:"+contact.getLastname()+", CONTACT:"+ contact.getPhoneNumber());
				f = true;
			}	
		}
		 
		 if (!f) {
			System.out.println("No contact matching criteria" +searchCriteria);
		}
	 }

	

	

}
