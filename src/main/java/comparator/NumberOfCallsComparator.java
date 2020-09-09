package comparator;

import model.OutgoingCall;

import java.util.Comparator;

public class NumberOfCallsComparator implements Comparator<OutgoingCall> {
    @Override
    public int compare(OutgoingCall o1, OutgoingCall o2) {
        return Integer.compare(o2.getNumberOfCalls(), o1.getNumberOfCalls());
    }
}
