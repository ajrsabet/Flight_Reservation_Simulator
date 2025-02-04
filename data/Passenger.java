package data;

// import java.util.ArrayList;
import java.util.PriorityQueue;

public class Passenger {
    private int id;
    private String name;

    public Passenger(int id, String name) {
        this.id = id;
        this.name = "Passenger ";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void getReservations(PriorityQueue<Reservation> reservations) {
        // get reservations for passenger
        for (Reservation reservation : reservations) {
            if (reservation.getPassenger().getId() == id) {
                System.out.println("Reservation ID: " + reservation.getId());
                System.out.println("Flight ID: " + reservation.getFlight().getId());
                System.out.println("Seat ID: " + reservation.getSeat().getId());
                System.out.println("Seat Class: " + reservation.getSeat().getSeatClass());
            }
        }
    }
}
