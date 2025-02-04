package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import data.*;

public class SwingDisplay extends JFrame {
    private Flight flight;
    private JTextArea displayArea;

    public SwingDisplay(Flight flight) {
        this.flight = flight;
        setTitle("Flight Reservation System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        JButton bookButton = new JButton("Book a Flight");
        JButton cancelButton = new JButton("Cancel a Flight");
        JButton exitButton = new JButton("Exit");

        // Add action listeners
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookFlight();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelFlight();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Layout components
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(bookButton);
        buttonPanel.add(cancelButton);
        buttonPanel.add(exitButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void bookFlight() {
        // Implement booking logic here
        displayArea.append("Booking a flight...\n");
        // Example: display flight diagram
        displayFlightDiagram();
    }

    private void cancelFlight() {
        // Implement cancellation logic here
        displayArea.append("Cancelling a flight...\n");
    }

    private void displayFlightDiagram() {
        int rows = flight.getRows();
        int cols = flight.getCols();

        displayArea.append("    ");
        for (int i = 0; i < cols; i++) {
            displayArea.append(String.format("%-4d", i + 1));
        }
        displayArea.append("\n");

        for (int i = 0; i < rows; i++) {
            displayArea.append(String.format("%-4d", i + 1));
            for (int j = 0; j < cols; j++) {
                Seat seat = flight.getSeat(i * cols + j);
                if (seat.getIsBooked()) {
                    displayArea.append("[X] ");
                } else {
                    displayArea.append("[ ] ");
                }
            }
            displayArea.append("\n");
        }
    }

}