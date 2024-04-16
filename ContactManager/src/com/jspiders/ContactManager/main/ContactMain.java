package com.jspiders.ContactManager.main;

import java.util.Scanner;

import com.jspiders.ContactManager.operation.ContactOperations;

public class ContactMain {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		ContactOperations contactOperations = new ContactOperations();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("1. Add contacts\n" 
		                     + "2. Delete contacts\n"
					         + "3. for Edit the Contacts\n" 
		                     + "4. view All Contacts\n"
				           	 + "5. Search Contacts\n" 
		                     + "Enter 6 to EXIT\n" 
				           	 + "Enter your Choice:");
			int choice = scanner.nextInt();
			@SuppressWarnings("unused")
			String choice1 = scanner.nextLine();

			switch (choice) {
			case 1:
				  contactOperations.addContact(scanner);
				break;
			case 2:
                  contactOperations.deleteContact();
				break;
			case 3:
                  contactOperations.editContacts();
				break;
			case 4:
                 contactOperations.viewAllContacts();
				break;
			case 5:
				contactOperations.searchContacts();
				break;
			case 6:
				 System.out.println("Exit");
                 scanner.close();
                 System.exit(0);
				break;

			default:
				System.out.println("Invalid Choice");
			}
		}

	}

}
