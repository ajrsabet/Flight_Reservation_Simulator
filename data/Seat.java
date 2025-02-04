package data;

public class Seat {
    private int seatId;
    private boolean isBooked;
    private int seatClass;
    // private char seatChar;
    // private int seatNum;

    public Seat(int seatClass, int seatId) {
        this.seatId = seatId;
        // this.seatChar = seatChar;
        // this.seatNum = seatNum;
        this.seatClass = seatClass;
        this.isBooked = false;
    }

    // get seat number
    public int[] getSeatPosition() {
        int seatRow = seatId / 4;
        char seatColumn = (char) (seatId % 4 + 65);
        int[] seatPosition = { seatRow, seatColumn };
        return seatPosition;
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

    // book seat
    public void bookSeat() {
        isBooked = true;
    }
}
