// This class represents the airplane AND the flight. In reality, it would be split so that each airplane can have many flights. 
package data;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Flight {
    private int flightId;
    private int capacity;
    private Seat[] seats;

    public Flight(int capacity, int firstClass, int businessClass) {
        this.capacity = capacity;
        this.seats = new Seat[capacity];
        this.flightId = 1234;

        for (int i = 0; i < seats.length; i++) {
            if ((i + 1) % 25 <= firstClass / 4) {
                seats[i] = new Seat(1, i);
            } else if ((i + 1) % 25 <= (businessClass + firstClass) / 4) {
                seats[i] = new Seat(2, i);
            } else {
                seats[i] = new Seat(3, i);
            }
        }
    }

    // get available seats
    public Seat[] getAvailableSeats() {
        Seat[] availableSeats = new Seat[getAvailableSeatCount()];
        try {
            int j = 0; // index for availableSeats

            // loop through seats and add available seats to availableSeats array
            for (int i = 0; i < seats.length; i++) {
                if (!seats[i].getIsBooked()) {
                    availableSeats[j] = seats[i];
                    j++;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e);
        }
        return availableSeats;
    }

    // populate passengers with random reservations
    public void populatePassengers(Passenger passenger, ArrayList<Passenger> passengers, Reservation reservation,
            PriorityQueue<Reservation> reservations, Seat seat) {
        for (int i = 0; i < 50; i++) {
            boolean seatAvailable = false;
            while (!seatAvailable) {
                int seatIndex = (int) (Math.random() * getCapacity());
                seat = getSeat(seatIndex);
                if (!seat.getIsBooked()) {
                    seatAvailable = true;
                }
            }
            passenger = new Passenger(i + 1, "auto");
            passengers.add(passenger);

            int seatIndex = (int) (Math.random() * getCapacity());
            seat = getSeat(seatIndex);
            seat.bookSeat();

            reservation = new Reservation(i + 1, this, passenger, seat);
            reservations.add(reservation);
        }
    }

    // get number of available seats
    public int getAvailableSeatCount() {
        int availableSeats = 0;
        for (Seat seat : seats) {
            if (!seat.getIsBooked()) {
                availableSeats++;
            }
        }
        return availableSeats;
    }

    public int getCapacity() {
        return capacity;
    }

    public Seat getSeat(int seatIndex) {
        return seats[seatIndex];
    }

    public Seat[] getSeats() {
        return seats;
    }

    public int getId() {
        return flightId;
    }

    public int getRows() {
        return 4;
    }

    public int getCols() {
        return seats.length / 4;
    }
}
