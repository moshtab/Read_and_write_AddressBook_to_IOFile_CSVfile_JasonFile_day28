package basic.csvFile.jsonFile.IOfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class AddressBookIOServiceFile {
	public String iOFileName = "src/main/java/resources/iOfile.txt";
	public String jasonFileName = "src/main/java/resources/jasonFile.json";
	public String csvFileName = "src/main/java/resources/CSVFile.csv";

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
		
		Gson gson = new Gson();
		String jason = gson.toJson(list);
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
				) {
         StatefulBeanToCsv<Contact> beanToCsv = new StatefulBeanToCsvBuilder<Contact>(writer)
        		 .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
        		 .build();
			try {
				beanToCsv.write(list);
			} catch (CsvDataTypeMismatchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CsvRequiredFieldEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
