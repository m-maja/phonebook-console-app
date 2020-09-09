package model;

public class Contact {
    private String name;
    private PhoneNumber phoneNumber;

    public Contact(String name, PhoneNumber phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return name + "\t" + phoneNumber.toString();
    }
}
