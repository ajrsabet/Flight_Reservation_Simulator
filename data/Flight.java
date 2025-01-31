package data;

public class Flight {
    // private String flightNumber;
    // private String airline;
    // private String origin;
    // private String destination;
    // private String departureTime;
    // private String arrivalTime;
    private int capacity;

    public Flight(int capacity, int firstClass, int businessClass, int economyClass) {
        this.capacity = capacity;

        Seat[] seats = new Seat[capacity];

        for (int i = 0; i < capacity; i++) {
            if (i < firstClass) {
                seats[i] = new Seat(i + 1, false, "First Class");
            } else if (i < firstClass + businessClass) {
                seats[i] = new Seat(i + 1, false, "Business Class");
            } else {
                seats[i] = new Seat(i + 1, false, "Economy Class");
            }
        }
    }

    public int getCapacity() {
        return capacity;
    }
}
