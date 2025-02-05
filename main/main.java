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
        InputTest inputTest = new InputTest();
        Scanner scanner = new Scanner(System.in);
        TypeWriter typeWriter = new TypeWriter(1);
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

        typeWriter.PrintLn("\nWelcome to the Flight Reservation System");

        while (session) {
            typeWriter.PrintLn("\nMain Menu");
            typeWriter.PrintLn("1. Book a flight");
            typeWriter.PrintLn("2. View your reservations");
            typeWriter.PrintLn("3. Cancel a reservation");
            typeWriter.PrintLn("4. Boarding simulation");
            typeWriter.PrintLn("5. Exit");

            // get user choice
            typeWriter.Print("\nEnter your choice: ");
            int choice = inputTest.Int();
            System.out.println();

            switch (choice) {
                // book a flight
                case 1:
                    typeWriter.PrintLn("\nBook a flight");
                    display.DisplayFlight(flight);
                    typeWriter.Print("Enter the seat row: ");
                    int seatNum = inputTest.Int();
                    typeWriter.Print("Enter the seat letter: ");
                    char seatRow = inputTest.Char();
                    int seatIndex = (Character.toUpperCase(seatRow) - 65) * 4 + seatNum - 1;

                    if (flight.getSeat(seatIndex).getIsBooked()) {
                        typeWriter.PrintLn("Seat is already booked");
                    } else {
                        typeWriter.Print("Enter your name: ");
                        String name = inputTest.String();
                        thisUser = new Passenger(passengers.size() + 1, name);
                        passengers.add(thisUser);
                        seat = flight.getSeat(seatIndex);
                        seat.bookSeat();
                        reservation = new Reservation(reservations.size() + 1, flight, thisUser, seat);
                        reservations.add(reservation);
                        typeWriter.PrintLn("Your reservation has been made");

                    }
                    System.out.println();
                    break;

                // view reservations
                case 2:
                    typeWriter.PrintLn("Your reservations:");
                    if (thisUser == null) {
                        typeWriter.PrintLn("No reservations found");
                    } else {
                        thisUser.getReservations(reservations);
                    }
                    System.out.println();
                    break;

                // cancel reservation
                case 3:
                    typeWriter.PrintLn("Your reservations:");
                    if (thisUser == null) {
                        typeWriter.PrintLn("No reservations found");
                    } else {
                        thisUser.getReservations(reservations);
                        typeWriter.Print("Enter the reservation ID to cancel: ");
                        int reservationId = inputTest.Int();
                        Passenger.cancelReservation(reservations, reservationId, reservation);
                        typeWriter.PrintLn("Your reservation has been cancelled");
                        typeWriter.PrintLn("Press any key to continue");
                        // press any key to continue
                    }
                    break;

                // exit
                case 5:
                    typeWriter.PrintLn("\nExiting the system");
                    session = false;
                    break;

                // boarding queue simulation
                case 4:
                    typeWriter.PrintLn("\nPrinting the boarding queue");
                    display.DisplayBoardingQueue(reservations);
                    break;
                default:
                    typeWriter.PrintLn("\nInvalid choice");
                    break;
            }
        }
    }

}
