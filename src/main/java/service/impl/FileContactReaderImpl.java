package service.impl;

import model.Contact;
import service.ContactParser;
import service.ContactReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FileContactReaderImpl implements ContactReader {
    ContactParser contactParser;

    public FileContactReaderImpl(ContactParser contactParser) {
        this.contactParser = contactParser;
    }

    public Map<String, Contact> readContacts() {
        String fileName = "contacts.txt";
        Map<String, Contact> contacts = new TreeMap<>();
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                try {
                    Contact contact = contactParser.parseContact(line);
                    contacts.put(contact.getName(), contact);
                } catch (RuntimeException e) {
                    System.err.println(e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return contacts;
    }
}
