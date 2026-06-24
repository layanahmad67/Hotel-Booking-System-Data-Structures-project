
package project;


public class Booking {
    private int bookingNum;
    public static int bookNum= 1;
    private boolean Status;
    private Room room;
    private Guest guest;
    private int numberOfDays;

    public Booking(Room room, Guest guest, int numberOfDays) {
        this.room = room;
        this.guest = guest;
        this.numberOfDays = numberOfDays;
        this.bookingNum = bookNum++;
         this.Status = true;
    }

    public int getBookingNum() {
        return bookingNum;
    }

    public void setBookingNum(int bookingNum) {
        this.bookingNum = bookingNum;
    }

    public static int getBookNum() {
        return bookNum;
    }

    public static void setBookNum(int bookNum) {
        Booking.bookNum = bookNum;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    @Override
    public String toString() {
        return "Booking{" + "bookingNum=" + bookingNum + ", Status=" + Status + ", room=" + room + ", guest=" + guest + ", numberOfDays=" + numberOfDays + '}';
    }
    
    

    

}