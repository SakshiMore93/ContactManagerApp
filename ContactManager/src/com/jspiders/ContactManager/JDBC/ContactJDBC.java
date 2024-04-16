package com.jspiders.ContactManager.JDBC;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ContactJDBC {
     private static Driver driver;
     private static PreparedStatement preparedStatement;
     private static Connection connection;
     private static ResultSet resultSet;
     private static String query;
     
     @SuppressWarnings("resource")
	public static void main(String[] args) {
    	 Scanner scanner = new Scanner(System.in);
    	 System.out.println("WELCOME TO CONTACT MANAGER.....!");
    	 System.out.println("Enter 1 to Add Contact: ");
    	 System.out.println("Enter 2 View Contact:");
    	 System.out.println("Enter 3 Update Contact");
    	 System.out.println("Enter 4 Delete Contact: ");
    	 System.out.println("Enter 5 Exit Contact");
    	 int choice = 0;
    	 try {
    		 choice = scanner.nextInt();
		  } catch (Exception e) {
			System.out.println("Invalid Choice");
			return;
		   }
    	switch (choice) {
		case 1:  addContact();
			break;
		case 2:  viewContact();
			break;
		case 3:  updateContact();
			break;
		case 4:  deleteContact();
			break;
		case 5: System.out.println("Exit Contact Manager");
            break;
		default:
			System.out.println("Invalid Choice");
		}
    	scanner.close();
     }
    
	

	private static void addContact() {
    	 Scanner scanner = new Scanner(System.in);
    	 System.out.print("Enter Id : ");
    	 int id = scanner.nextInt();
    	 scanner.nextLine();
    	 System.out.print("Enter first Name: ");
    	 String firstName = scanner.nextLine();
    	 System.out.print("Enter last Name:");
    	 String lastName = scanner.nextLine();
    	 System.out.print("Enter Email :");
    	 String email = scanner.nextLine();
    	 System.out.print("Enter phone Number: ");
    	 long phonenumber = scanner.nextLong();
    	 scanner.close();
    	 try {
			openConnection();
			query = "INSERT INTO contact VALUES(?,?,?,?,?)";
		    preparedStatement = connection.prepareStatement(query);
		    preparedStatement.setInt(1, id);
		    preparedStatement.setString(2, firstName);
		    preparedStatement.setString(3, lastName);
		    preparedStatement.setLong(4,phonenumber );
		    preparedStatement.setString(5, email);
		    int res = preparedStatement.executeUpdate();
		    if (res == 1) {
				System.out.println("Contact Saved");
			}else {
				System.out.println("Error");
			}
		  } catch (Exception e) {
			e.printStackTrace();
		 }finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
     
	
	  private static void viewContact() {
		    Scanner scanner = new Scanner(System.in);
			System.out.print("Enter id:");
			int id = scanner.nextInt();
			scanner.close();
			
			try {
				openConnection();
				query = "SELECT * FROM contact WHERE id = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, id);
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					System.out.println("ID: "+resultSet.getInt(1));
					System.out.println("FirstName: "+resultSet.getString(2));
					System.out.println("LastName: "+resultSet.getString(3));
					System.out.println("Email: "+resultSet.getString(4));
					System.out.println("PhoneNumber: "+resultSet.getLong(5));
		            System.out.println("Logged in");

				}else {
					System.out.println("Invalid ID");
					System.out.println("Try again...");
				}
			  } catch (Exception e) {
		        	}finally {
			        	try {
					      closeConnection();
			    	} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	 
	 private static void deleteContact() {
		    Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the id: ");
			int id = scanner.nextInt();
			scanner.close();
			try {
				openConnection();
				query ="DELETE FROM contact WHERE id = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, id);
				int res = preparedStatement.executeUpdate();
				if (res == 1) {
					System.out.println("Contact is deleted");
				}else {
					System.out.println("Contact doec not found");
				}
			} catch (Exception e) {
			}finally {
				try {
					closeConnection();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}

		private static void updateContact() {
			Scanner scanner = new Scanner(System.in);
	    	System.out.print("Enter Id:");
	    	int id = scanner.nextInt();
	    	scanner.nextLine();
	    	System.out.print("Enetr new firstName: ");
	    	String newFirstName = scanner.nextLine();
	    	System.out.print("Enetr new lastName: ");
	    	String newLastName = scanner.nextLine();
	    	System.out.print("Enetr new emailId: ");
	    	String newEmailId = scanner.nextLine();
	    	System.out.print("Enetr new phonenumber: ");
	    	long newPhonenumber = scanner.nextLong();
	    	scanner.close();
		  try {
			openConnection();
			query = "UPDATE contact SET firstName=?,lastName=?,email=?,phonenumber=? WHERE id = ? ";
			 preparedStatement = connection.prepareStatement(query);
			 preparedStatement.setString(1, newFirstName);
			 preparedStatement.setString(2, newLastName);
			 preparedStatement.setString(3, newEmailId);
			 preparedStatement.setLong(4, newPhonenumber);
			 preparedStatement.setInt(5, id);
			 int res = preparedStatement.executeUpdate();
			 System.out.println(res+ "row(s) affected");
		} catch (Exception e) {
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} 
     
     private static void openConnection() throws ClassNotFoundException, SQLException {
    	 Class.forName("com.mysql.cj.jdbc.Driver");
    	driver = new com.mysql.cj.jdbc.Driver();
    	DriverManager.registerDriver(driver);
    	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weje1","root","sakshi");
    		
     }
     
     private static void closeConnection() throws SQLException {
    	 if (connection != null) {
			connection.close();
		}
    	 if (preparedStatement != null) {
			preparedStatement.close();
		}
    	 if (resultSet != null) {
			resultSet.close();
		}
    	 if (driver != null) {
			DriverManager.deregisterDriver(driver);
		}
     }
   }

