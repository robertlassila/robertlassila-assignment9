package com.coderscampus.assignment9.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

@Service
public class FileService {

    public List<CSVRecord> readFile(String filename) {
        List<CSVRecord> records = null;
        try (Reader in = new FileReader(filename)) {
            records = CSVFormat.DEFAULT
                    .withIgnoreSurroundingSpaces()
                    .withHeader()
                    .withSkipHeaderRecord()
                    .withTrim()
                    .withEscape('\\')
                    .withQuote('"')
                    .parse(in)
                    .getRecords();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return records;
    }
}
