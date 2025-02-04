//     Flight reservation system:
//     A flight reservation system is a software application that helps customers book flights, hotels, and rental cars.

package main;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;

import data.*;
import ui.*;
import util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean session = true;
        Reservation reservation = new Reservation(0, null, null, null);
        Passenger passenger = new Passenger(0, "auto");
        Seat seat = new Seat(0, 0);
        Passenger thisUser = null;

        final Flight flight = new Flight(100, 20, 20);
        final PriorityQueue<Reservation> reservations = new PriorityQueue<>(new ReservationComparator());
        final ArrayList<Passenger> passengers = new ArrayList<Passenger>();
        ConsoleDisplay display = new ConsoleDisplay();

        // populate 50 passengers with random reservations
        flight.populatePassengers(passenger, passengers, reservation, reservations, seat);

        System.out.println("Welcome to the Flight Reservation System");

        while (session) {
            System.out.println("Main Menu");
            System.out.println("1. Book a flight");
            System.out.println("2. View your reservations");
            System.out.println("3. Cancel a reservation");
            System.out.println("4. Exit");
            System.out.println();
            System.out.println("5. Boarding simulation");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.println("Book a flight");
                    display.DisplayFlight(flight);
                    System.out.print("Enter the seat row: ");
                    int seatNum = scanner.nextInt();
                    System.out.print("Enter the seat letter: ");
                    char seatRow = scanner.next().charAt(0);
                    int seatIndex = (Character.toUpperCase(seatRow) - 65) * 4 + seatNum - 1;

                    if (flight.getSeat(seatIndex).getIsBooked()) {
                        System.out.println("Seat is already booked");
                    } else {
                        System.out.print("Enter your name: ");
                        String name = scanner.next();
                        thisUser = new Passenger(passengers.size() + 1, name);
                        passengers.add(thisUser);
                        seat = flight.getSeat(seatIndex);
                        seat.bookSeat();
                        reservation = new Reservation(reservations.size() + 1, flight, thisUser, seat);
                        reservations.add(reservation);
                        System.out.println("Your reservation has been made");

                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Your reservations:");
                    if (thisUser == null) {
                        System.out.println("No reservations found");
                    } else {
                        thisUser.getReservations(reservations);
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Your reservation has been cancelled");
                    System.out.println();
                    // press any key to continue

                    break;
                case 4:
                    System.out.println("Exiting the system");
                    session = false;
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        scanner.close();
    }

}
