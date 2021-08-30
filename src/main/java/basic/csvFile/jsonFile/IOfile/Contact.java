package basic.csvFile.jsonFile.IOfile;

public class Contact {
	public String firstName;
	public String lastName;
	public String city;
	public String state;
	public String email;
	public String phoneNumber;
	public String zip;

	public Contact(String firstName, String lastName2, String city2, String state2, String email2, String phoneNumber2,
			String zip2) {
		this.firstName = firstName;
		this.lastName = lastName2;
		this.city = city2;
		this.state = state2;
		this.email = email2;
		this.phoneNumber = phoneNumber2;
		this.zip = zip2;

	}

	public String toString() {
		return "\nFirstName=" + firstName + ", LastName=" + lastName + ", city=" + city + ", state=" + state
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", zip=" + zip + "\n";
	}

}
