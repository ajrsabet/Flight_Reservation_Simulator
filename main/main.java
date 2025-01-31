/*
    Flight reservation system:
    A flight reservation system is a software application that helps customers book flights, hotels, and rental cars.
*/

package main;

import java.util.Scanner;

public class main {
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

        Flight flight = new Flight(100, 10, 20, 70);

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
                    break;
                case 2:
                    System.out.println("Cancel a flight");
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

}