package ui;

import java.util.PriorityQueue;

import data.Flight;
import data.Passenger;
import data.Reservation;
import data.Seat;
import util.TypeWriter;

public class ConsoleDisplay {
    private TypeWriter typeWriter = new TypeWriter(1);

    // print a 2d diagram of the flight with available seats using X for booked
    // seats and O for available seats
    public ConsoleDisplay() {
    }

    public void DisplayFlight(Flight flight) {
        Seat[] seats = flight.getSeats();
        int cols = seats.length / 4;
        int rows = 4;
        String dashes = "   -----------------------------------------------------------------------------------------------------------------------------------------";

        // print seat class tittles
        System.out.println("      First Class             ||   Business Class          ||   Economy Class");

        System.out.print("     ");
        for (int i = 0; i < cols; i++) {
            if (i == 5 || i == 10) {
                System.out.print("||  ");
            }
            System.out.print(String.format(" %-4d", i + 1));
        }

        try {
            System.out.println();
            // print flight diagram
            int seatIndex = 0;

            for (int i = 0; i < rows; i++) {
                if (i == 0 || i == 2) {
                    // print aisle with "---" to match length of seat diagram
                    System.out.println(dashes);
                }
                System.out.print((char) (65 + i) + " | ");

                for (int j = 0; j < cols; j++) {
                    // print separator for seat classes
                    if (seatIndex == 5 || seatIndex == 10 || seatIndex == 30 || seatIndex == 35 || seatIndex == 55
                            || seatIndex == 60 || seatIndex == 80 || seatIndex == 85) {
                        System.out.print(" || ");

                    }
                    if (seats[seatIndex].getIsBooked()) {
                        if (seats[seatIndex].getSeatClass() == 1) {
                            System.out.print(" [F] ");
                        } else if (seats[seatIndex].getSeatClass() == 2) {
                            System.out.print(" [B] ");
                        } else {
                            System.out.print(" [E] ");
                        }
                    } else {
                        System.out.print(" [ ] ");
                    }
                    seatIndex++;
                }
                System.out.println(" |");
            }
            System.out.println(dashes);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e);
        }
    }

    // display boarding queue
    public void DisplayBoardingQueue(PriorityQueue<Reservation> reservations) {
        typeWriter.PrintLn("Boarding Queue:");
        for (Reservation reservation : reservations) {
            DisplayReservation(reservation);
        }
    }

    // display reservation
    public void DisplayReservation(Reservation reservation) {
        // get passenger name
        String name = reservation.getPassenger().getName();
        // get seat position
        String seatPosition = reservation.getSeat().getSeatPosition();

        typeWriter.PrintLn("Reservation ID: " + reservation.getId());
        typeWriter.PrintLn("Passenger: " + name);
        typeWriter.PrintLn("Flight ID: " + reservation.getFlight().getId());
        typeWriter.PrintLn("Seat: " + seatPosition);
        typeWriter.PrintLn("Seat Class: " + reservation.getSeat().getSeatClassString());
        System.out.println();
    }
}
