package data;

public class Seat {
    private int seatId;
    private boolean isBooked;
    private int seatClass;
    private char seatChar;
    private int seatNum;

    public Seat(int seatClass, int seatId) {
        this.seatId = seatId;
        this.seatChar = (char) (65 + (seatId / 25));
        this.seatNum = (seatId % 25) + 1;
        this.seatClass = seatClass;
        this.isBooked = false;
    }

    // get seat position (e.g. 1A)
    public String getSeatPosition() {
        return seatChar + Integer.toString(seatNum);
        // return Integer.toString(seatId);
    }

    // get seat ID
    public int getId() {
        return seatId;
    }

    // get is booked
    public boolean getIsBooked() {
        // System.out.println(isBooked);
        return isBooked;
    }

    // get class
    public int getSeatClass() {
        return seatClass;
    }

    // get class string
    public String getSeatClassString() {
        String classString = "";
        if (seatClass == 1) {
            classString = "First Class";
        } else if (seatClass == 2) {
            classString = "Business";
        } else {
            classString = "Economy";
        }
        return classString;
    }

    // book seat
    public void bookSeat() {
        isBooked = true;
    }

    // book seat
    public void unbookSeat() {
        isBooked = false;
    }
}
