package com.coderscampus.assignment9;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

@SpringBootApplication
public class Assignment9Application {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Assignment9Application.class, args);

//		Reader in = new FileReader("recipes.txt");
//		Iterable<CSVRecord> records = CSVFormat.DEFAULT
//				.withIgnoreSurroundingSpaces()
//				.withHeader()
//				.withSkipHeaderRecord()
//				.parse(in);
//		for (CSVRecord record : records) {
//			int cookingMinutes = Integer.parseInt(record.get("Cooking Minutes"));
//			boolean dairyFree = Boolean.parseBoolean(record.get("Dairy Free"));
//		}
	}


}
