package application;

import exception.ContactNotFoundException;
import repository.PhoneBook;

public class CommandExecutor {
    private final PhoneBook phoneBook;

    private static final String LIST = "list";
    private static final String DELETE = "delete";
    private static final String GET = "get";
    private static final String MAKE_CALL = "makeCall";
    private static final String LIST_CALLS = "listCalls";

    CommandExecutor(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    public void executeCommand(String line) {
        String[] split = line.trim().split("\\s+");
        String command = split[0].trim();
        switch (command) {
            case LIST:
                System.out.println(phoneBook.toString());
                break;
            case DELETE:
                if (split.length != 2) {
                    System.err.println("Invalid argument number");
                }
                phoneBook.deleteContact(split[1]);
                break;
            case GET:
                if (split.length != 2) {
                    System.err.println("Invalid argument number");
                }
                System.out.println(phoneBook.getContactByName(split[1]) + "\n");
                break;
            case MAKE_CALL:
                if (split.length != 2) {
                    System.err.println("Invalid argument number");
                }
                try {
                    phoneBook.makeCall(split[1]);
                    System.out.printf("Called %s \n", split[1]);
                } catch (ContactNotFoundException e) {
                    System.err.println(e.getMessage());
                }
                break;
            case LIST_CALLS:
                if (split.length != 1) {
                    System.err.println("Invalid argument number");
                }
                System.out.println(phoneBook.mostCalledContacts(5));
                break;
            default:
                System.err.println("Invalid command");
        }
    }

    public void printMenu() {
        System.out.println("Enter command to proceed:");
        System.out.println("Enter 'list' to list all numbers from the phone book:");
        System.out.println("Enter 'delete Name' if you want to delete a name from the repository: ");
        System.out.println("Enter 'get Name' to get specific contact:");
        System.out.println("Enter 'makeCall Name' to simulate a call to a specific contact name:");
        System.out.println("Enter 'listCalls' to list top 5 most called contacts:");
     }
}
