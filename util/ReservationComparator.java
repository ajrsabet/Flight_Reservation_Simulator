package util;

import java.util.Comparator;
// import data.Passenger;
import data.Reservation;
// import data.Seat;

public class ReservationComparator implements Comparator<Reservation> {
    @Override
    public int compare(Reservation r1, Reservation r2) {
        return Integer.compare(r1.getSeat().getSeatClass(), r2.getSeat().getSeatClass());
    }
}