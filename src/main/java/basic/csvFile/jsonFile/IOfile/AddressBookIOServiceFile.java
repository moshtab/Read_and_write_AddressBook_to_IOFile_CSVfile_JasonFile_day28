package basic.csvFile.jsonFile.IOfile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AddressBookIOServiceFile {
	public String iOFileName = "src/main/java/resources/iOfile.txt";

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
			Files.lines(new File(iOFileName).toPath()).forEach(System.out::println);
		} catch (IOException e) {
			e.getStackTrace();
		}

	}

}
