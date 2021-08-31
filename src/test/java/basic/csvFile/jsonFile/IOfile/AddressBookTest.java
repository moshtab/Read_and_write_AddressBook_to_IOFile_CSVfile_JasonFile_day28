package basic.csvFile.jsonFile.IOfile;

import java.util.Arrays;

import org.junit.Test;

public class AddressBookTest {
	@Test
	public void given3ContactDetailsWhenWrittenToIOFileShouldMatchEmployeeEntries() {
		Contact[] arrOfContacts = {
				new Contact("Mohammad", "Mohsin", "Metpally", "Telangana", "abc@gmail.com", "9908514276", "505325"),
				new Contact("Mohammad", "Sumer", "Metpally", "Telangana", "abdc@gmail.com", "9908514277", "505325"),
				new Contact("Mohammad", "Sofyan", "Metpally", "Telangana", "abc@gmail.com", "9908514276", "505325")

		};
		AddressBook adressBook = new AddressBook(Arrays.asList(arrOfContacts));
		adressBook.writeIOContact();
		adressBook.readIOContact();
	}

	@Test
	public void given3ContactDetailsWhenWrittenToJASONFileShouldMatchEmployeeEntries() {
		Contact[] arrOfContacts = {
				new Contact("Mohammad", "Mohsin", "Metpally", "Telangana", "abc@gmail.com", "9908514276", "505325"),
				new Contact("Mohammad", "Sumer", "Metpally", "Telangana", "abdc@gmail.com", "9908514277", "505325"),
				new Contact("Mohammad", "Sofyan", "Metpally", "Telangana", "abc@gmail.com", "9908514276", "505325")

		};
		AddressBook adressBook = new AddressBook(Arrays.asList(arrOfContacts));
		adressBook.writeJsonContact();
		adressBook.readJsonContact();
	}

	@Test
	public void given3ContactDetailsWhenWrittenToCSVFileShouldMatchEmployeeEntries() {
		Contact[] arrOfContacts = {
				new Contact("Mohammad", "Mohsin", "Metpally", "Telangana", "abc@gmail.com", "9908514276", "505325"),
				new Contact("Mohammad", "Sumer", "Metpally", "Telangana", "abdc@gmail.com", "9908514277", "505325"),
				new Contact("Mohammad", "Sofyan", "Metpally", "Telangana", "abc@gmail.com", "9908514276", "505325")

		};
		AddressBook adressBook = new AddressBook(Arrays.asList(arrOfContacts));
		adressBook.writeContactToCSV();
		// adressBook.readContactToCSV();

	}
}
