package application;

import repository.PhoneBook;
import service.ContactParser;
import service.ContactReader;
import service.impl.FileContactReaderImpl;
import service.impl.MacedonianContactParserImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBookConsoleApplication {
    public static void main(String[] args) {
        ContactParser contactParser = new MacedonianContactParserImpl();
        ContactReader contactReader = new FileContactReaderImpl(contactParser);

        PhoneBook phoneBook = new PhoneBook(contactReader.readContacts(), new ArrayList<>());

        Scanner scanner = new Scanner(System.in);
        CommandExecutor commandExecutor = new CommandExecutor(phoneBook);
        while (true) {
            commandExecutor.printMenu();
            String line = scanner.nextLine();
            commandExecutor.executeCommand(line);
        }
    }
}
