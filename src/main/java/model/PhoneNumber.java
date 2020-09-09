package model;

public class PhoneNumber {
    private String countryCode;
    private String phoneNumberValue;

    public PhoneNumber(String countryCode, String phoneNumberValue) {
        this.countryCode = countryCode;
        this.phoneNumberValue = phoneNumberValue;
    }

    @Override
    public String toString() {
        return countryCode + phoneNumberValue;
    }
}
