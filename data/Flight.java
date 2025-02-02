// This class represents the airplane AND the flight. In reality, it would be split so that each airplane can have many flights. 
package data;

public class Flight {
    private int flightId;
    private int capacity;
    private Seat[] seats;

    public Flight(int capacity, int firstClass, int businessClass, int economyClass) {
        this.capacity = capacity;
        this.seats = new Seat[capacity];
        this.flightId = 1234;

        for (int i = 0; i < seats.length; i++) {
            if (i < firstClass) {
                seats[i] = new Seat(i + 1, "First Class");
            } else if (i < firstClass + businessClass) {
                seats[i] = new Seat(i + 1, "Business Class");
            } else {
                seats[i] = new Seat(i + 1, "Economy Class");
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
}
