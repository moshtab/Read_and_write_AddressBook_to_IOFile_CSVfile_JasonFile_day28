package basic.csvFile.jsonFile.IOfile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook {
	public enum IOService {
		CONSOLE_IO, FILE_IO, DB_IO, REST_IO
	}

	List<Contact> list;

	public AddressBook(List<Contact> list2) {
		this.list = list2;
	}

	public static void main(String[] args) {

		ArrayList<Contact> list = new ArrayList<Contact>();

		AddressBook adressBook = new AddressBook(list);
		AddressBook adressBook2 = new AddressBook(list);

		// Adding contact1 in addressBook
		System.out.println("Adding contact1 details");
		adressBook.addContact();

		adressBook.writeContact();
		// Adding contact2 in addressBook
		System.out.println("Adding contact2 details");
		adressBook.addContact();

		// Editing contact1
		System.out.println("Editing Contact1 details");
		list.set(0, adressBook.editContact());
		// Delete contact1
		list.remove(0);

		// Added Multiple addressBooks
		System.out.println("Adding contact details for adressBook2");
		adressBook2.addContact();

		// searching for Name is present or not
		for (Contact i : list) {
			if (i.firstName.contains("Mohsin")) {
				System.out.println("Name found :" + i.firstName);
			} else {
				System.out.println("No match");
			}
		}

		// using stream to Display the contacts
		System.out.println("Displaying the contacts of contactPersons");
		List<Object> result = list.stream().collect(Collectors.toList());
		System.out.println(result);

	}

	private Contact editContact() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the First name");
		String firstName = s.nextLine();

		System.out.println("Enter the Last name");
		String lastName = s.nextLine();

		System.out.println("Enter the City name");
		String city = s.nextLine();

		System.out.println("Enter the State name");
		String state = s.nextLine();

		System.out.println("Enter the email");
		String email = s.nextLine();

		System.out.println("Enter the Phone number");
		String phoneNumber = s.nextLine();

		System.out.println("Enter the Zip");
		String zip = s.nextLine();
		Contact contact = new Contact(firstName, lastName, city, state, email, phoneNumber, zip);

		list.add(contact);
		return contact;

	}

	private void addContact() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the First name");
		String firstName = s.nextLine();

		System.out.println("Enter the Last name");
		String lastName = s.nextLine();

		System.out.println("Enter the City name");
		String city = s.nextLine();

		System.out.println("Enter the State name");
		String state = s.nextLine();

		System.out.println("Enter the email");
		String email = s.nextLine();

		System.out.println("Enter the Phone number");
		String phoneNumber = s.nextLine();

		System.out.println("Enter the Zip");
		String zip = s.nextLine();
		Contact contact = new Contact(firstName, lastName, city, state, email, phoneNumber, zip);

		list.add(contact);

	}

	public void writeContact() {
		new AddressBookIOServiceFile().writeData(list);

	}

	public void readContact() {
		new AddressBookIOServiceFile().readData();
		
	}
}