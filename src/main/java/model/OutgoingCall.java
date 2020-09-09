package model;

public class OutgoingCall {
    Contact contact;
    int numberOfCalls;

    public OutgoingCall(Contact contact) {
        this.contact = contact;
        numberOfCalls = 0;
    }

    public void makeCall() {
        numberOfCalls++;
    }

    public Contact getContact() {
        return contact;
    }

    public int getNumberOfCalls() {
        return numberOfCalls;
    }
}
