package basic.csvFile.jsonFile.IOfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.google.gson.Gson;
import com.opencsv.CSVWriter;

public class AddressBookIOServiceFile {
	public String iOFileName = "src/main/java/resources/iOfile.txt";
	public String jasonFileName = "src/main/java/resources/jasonFile.txt";
	public String csvFileName = "src/main/java/resources/CSVFile.txt";

	public void writeData(List<Contact> list) {
		StringBuffer empBuffer = new StringBuffer();
		list.forEach(contact -> {
			String data = contact.toString().concat("\n");
			empBuffer.append(data);
		});
		try {
			Files.write(Paths.get(iOFileName), empBuffer.toString().getBytes());
		} catch (IOException e) {
			e.getStackTrace();
		}

	}

	public void readData() {
		try {
			System.out.println(new String(Files.readAllBytes(Paths.get(iOFileName))));
		} catch (IOException e) {
			e.getStackTrace();
		}

	}

	public void writeJasonData(List<Contact> list) {
		StringBuffer empBuffer = new StringBuffer();
		list.forEach(contact -> {
			String data = contact.toString().concat("\n");
			empBuffer.append(data);
		});
		Gson gson = new Gson();
		String jason = gson.toJson(empBuffer.toString());
		try {
			FileWriter writer = new FileWriter(jasonFileName);
			writer.write(jason);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readJasonData() {
		Gson gson = new Gson();
		try {
			System.out.println("Reading Jason from a file");
			BufferedReader br = new BufferedReader(new FileReader(jasonFileName));
			Contact contactObj = gson.fromJson(br, Contact.class);
			System.out.println("Firstname :" + contactObj.firstName.toString());
			System.out.println("Lastname :" + contactObj.lastName.toString());
			System.out.println("city :" + contactObj.city.toString());
			System.out.println("state :" + contactObj.state.toString());
			System.out.println("email :" + contactObj.email.toString());
			System.out.println("phoneNumber :" + contactObj.phoneNumber.toString());
			System.out.println("zip :" + contactObj.zip.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void writeCSVData(List<Contact> list) {

		try (Writer writer = Files.newBufferedWriter(Paths.get(csvFileName));
				CSVWriter csvWriter = new CSVWriter(writer);) {
			StringBuffer empBuffer = new StringBuffer();
			list.forEach(contact -> {
				String[] data = { contact.toString().concat("\n") };
				empBuffer.append(data);
			});
			writer.write(empBuffer.toString());
			writer.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
