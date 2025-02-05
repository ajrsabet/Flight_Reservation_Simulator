package data;

// import java.util.ArrayList;
import java.util.PriorityQueue;
import ui.ConsoleDisplay;

import util.ReservationComparator;

public class Passenger {
    private ConsoleDisplay display = new ConsoleDisplay();
    private int id;
    private String name;

    public Passenger(int id, String name) {
        this.id = id;
        this.name = name;
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
                display.DisplayReservation(reservation);
            }
        }
    }

    // cancel reservation
    public static void cancelReservation(PriorityQueue<Reservation> reservations, int reservationId,
            Reservation reservation) {
        PriorityQueue<Reservation> tempQueue = new PriorityQueue<>(new ReservationComparator());
        while (!reservations.isEmpty()) {
            Reservation res = reservations.poll();
            if (reservation.getId() != reservationId) {
                tempQueue.add(res);
            }
        }
        reservations.addAll(tempQueue);
    }
}
