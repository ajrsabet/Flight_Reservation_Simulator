package data;

public class Reservation {
    private int reservationId;
    private Flight flight;
    private Passenger passenger;
    private Seat seat;

    public Reservation(int reservationId, Flight flight, Passenger passenger, Seat seat) {
        this.reservationId = reservationId;
        this.flight = flight;
        this.passenger = passenger;
        this.seat = seat;
    }

    // get reservation id
    public int getId() {
        return reservationId;
    }

    // get flight id
    public Flight getFlight() {
        return flight;
    }

    // get passenger id
    public Passenger getPassenger() {
        return passenger;
    }

    // get seat class
    public Seat getSeat() {
        return seat;
    }
}
