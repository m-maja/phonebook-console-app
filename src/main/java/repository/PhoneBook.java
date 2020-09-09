package repository;

import comparator.NumberOfCallsComparator;
import exception.ContactNotFoundException;
import model.Contact;
import model.OutgoingCall;

import java.util.*;
import java.util.stream.Collectors;

public class PhoneBook {
    private final Map<String, Contact> contacts;
    private final List<OutgoingCall> outgoingCalls;

    public PhoneBook(Map<String, Contact> contacts, List<OutgoingCall> outgoingCalls) {
        this.contacts = contacts;
        this.outgoingCalls = outgoingCalls;
    }

    public Contact getContactByName(String name) {
        Contact contact = contacts.get(name);
        if (contact == null) {
            throw new ContactNotFoundException("Contact " + name + " not found in the phonebook");
        }
        return contact;
    }

    public void deleteContact(String name) {
        contacts.remove(name);
    }

    public void makeCall(String name) {
        Optional<OutgoingCall> optionalOutgoingCall = outgoingCalls.stream()
                .filter(outgoingCall -> name.equals(outgoingCall.getContact().getName()))
                .findFirst();
        if (optionalOutgoingCall.isPresent()) {
            optionalOutgoingCall.get().makeCall();
        } else {
            Contact contact = getContactByName(name);
            OutgoingCall newCall = new OutgoingCall(contact);
            newCall.makeCall();
            outgoingCalls.add(newCall);
        }
    }

    public List<Contact> mostCalledContacts(int numberOfContacts) {
        return outgoingCalls.stream()
                .sorted(new NumberOfCallsComparator())
                .limit(numberOfContacts)
                .map(OutgoingCall::getContact)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PhoneBook: \n");
        contacts.values().forEach(contact -> stringBuilder.append(contact.toString() + "\n"));
        return stringBuilder.toString();
    }
}
