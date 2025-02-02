/*
    Flight reservation system:
    A flight reservation system is a software application that helps customers book flights, hotels, and rental cars.
*/

package main;

import java.util.Scanner;
import java.util.ArrayList;

import data.*;

public class Main {
    /*
     * -main.java
     * -Flight.java
     * -Passenger.java
     * -Ticket.java
     * -FlightReservation.java
     * -FlightReservationSystem.java
     * -FlightReservationSystemTest.java
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean session = true;
        Reservation reservation;
        Passenger passenger;
        Seat seat;

        final Flight flight = new Flight(100, 10, 20, 70);
        final ArrayList<Passenger> passengers = new ArrayList<Passenger>();
        final ArrayList<Reservation> reservations = new ArrayList<Reservation>();

        // populate 50 passengers with random reservations
        for (int i = 0; i < 50; i++) {
            boolean seatAvailable = false;
            while (!seatAvailable) {
                int seatIndex = (int) (Math.random() * flight.getCapacity());
                seat = flight.getSeat(seatIndex);
                if (!seat.getIsBooked()) {
                    seatAvailable = true;
                }
            }
            passenger = new Passenger(i + 1);
            passengers.add(passenger);

            int seatIndex = (int) (Math.random() * flight.getCapacity());
            seat = flight.getSeat(seatIndex);
            seat.bookSeat();

            reservation = new Reservation(i + 1, flight, passenger, seat);
            reservations.add(reservation);
        }

        System.out.println("Welcome to the Flight Reservation System");

        while (session) {
            System.out.println("1. Book a flight");
            System.out.println("2. Cancel a flight");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Book a flight");
                    char seatRow = scanner.next().charAt(0);
                    int seatNum = scanner.nextInt();
                    printFlightDiagram(flight);
                    break;
                case 2:
                    System.out.println("Your reservation has been cancelled");
                    break;
                case 3:
                    System.out.println("Exiting the system");
                    session = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        scanner.close();
    }

    // print a 2d diagram of the flight with available seats using X for booked
    // seats and O for available seats
    public static void printFlightDiagram(Flight flight) {
        Seat[] seats = flight.getSeats();
        int cols = seats.length / 4;
        int rows = 4;

        // print rows numbers
        System.out.print("  ");
        for (int i = 0; i < cols; i++) {
            System.out.print(i + 1 + "   ");
        }

        try {
            System.out.println();
            // print flight diagram
            int seatIndex = 0;

            for (int i = 0; i < rows; i++) {
                if (i == 0 || i == 2) {
                    // print aisle with "---" to match length of seat diagram
                    System.out.println(
                            "   ----------------------------------------------------------------------------------- ");
                }
                System.out.print((char) (65 + i) + " | ");

                for (int j = 0; j < cols; j++) {
                    // System.out.print("s");

                    if (seats[seatIndex].getIsBooked()) {
                        System.out.print("X | ");
                    } else {
                        System.out.print("O | ");
                    }
                    seatIndex++;
                }
                System.out.println();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e);
        }
    }

}