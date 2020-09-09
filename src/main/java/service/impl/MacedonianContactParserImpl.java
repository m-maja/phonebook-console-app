package service.impl;

import exception.InvalidContactInputException;
import exception.InvalidPhoneNumberException;
import model.Contact;
import model.PhoneNumber;
import service.ContactParser;
import service.PhoneNumberValidator;

public class MacedonianContactParserImpl implements ContactParser {
    private final PhoneNumberValidator validator;

    public MacedonianContactParserImpl() {
        this.validator = new MacedonianPhoneNumberValidatorImpl();
    }

    public Contact parseContact(String input) {
        String[] contactValues = input.trim().split("\\s+");
        if (contactValues.length != 2) {
            throw new InvalidContactInputException(String.format("Input %s is invalid contact input, therefore it will be skipped", input));
        }

        return createContact(contactValues[0], contactValues[1]);
    }

    private Contact createContact(String name, String phoneNumber) {
        if (validator.isValid(phoneNumber)) {
            String mkCountryCode = "+389";
            PhoneNumber phone = new PhoneNumber(mkCountryCode, phoneNumber.substring(phoneNumber.length() - 8));
            return new Contact(name, phone);
        }
        throw new InvalidPhoneNumberException("Invalid phone number: " + phoneNumber);
    }
}
