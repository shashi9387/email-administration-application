package emailapplication;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "tcs.com";

	// Constructor to receive the firstName, lastName
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;

		// call a method asking for the department - return the department
		this.department = setDepartment();

		// call a method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is " + this.password);

		// Combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + companySuffix;
	}

	// Ask for the department
	private String setDepartment() {
		System.out.println("New employee: " + firstName
				+ "\nEnter the department codes: \n	1 for Sales\n	2 for Development\n	3 for Accounting\n	0 for none\nEnter department code: ");
		Scanner sc = new Scanner(System.in);
		int depChoice = sc.nextInt();
		sc.close();
		if (depChoice == 1) {
			return "sales.";
		} else if (depChoice == 2) {
			return "dev.";
		} else if (depChoice == 3) {
			return "acct.";
		} else {
			return "";
		}
	}

	// Generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ012345679!@#$%";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}

	// Set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}

	// Set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}

	// change the password
	public void changePassword(String password) {
		this.password = password;
	}

	public int getMailboxCapacity() {
		return mailboxCapacity;
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}

	public String getPassword() {
		return password;
	}

	public String toString() {
		return "Employee Name: " + firstName + " " + lastName + "\nCompany email: " + email + "\nMailbox Capacity: "
				+ mailboxCapacity + "mb";
	}
}
