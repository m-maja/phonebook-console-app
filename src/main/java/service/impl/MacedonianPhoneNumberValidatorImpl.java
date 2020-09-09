package service.impl;

import service.PhoneNumberValidator;

public class MacedonianPhoneNumberValidatorImpl implements PhoneNumberValidator {
    public boolean isValid(String phoneNumber) {
        return phoneNumber != null &&
                (phoneNumber.matches("^\\+3897[01278]\\d{6}$") ||
                        phoneNumber.matches("^07[01278]\\d{6}$") ||
                        phoneNumber.matches("^003897[01278]\\d{6}$"));
    }
}
