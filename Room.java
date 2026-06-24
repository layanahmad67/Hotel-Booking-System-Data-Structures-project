
package project;


public class Room {
    private String roomType;
    private int roomNum;
    public static int NumOfRoom;
    private int numOfGuest;

    public Room(String roomType, int numOfGuest) {
        this.roomType = roomType;
        this.roomNum = NumOfRoom;
        this.numOfGuest = numOfGuest;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public int getNumOfGuest() {
        return numOfGuest;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public void setNumOfGuest(int numOfGuest) {
        this.numOfGuest = numOfGuest;
    }

    @Override
    public String toString() {
        return "Room{" + "roomType=" + roomType + ", roomNum=" + roomNum + ", numOfGuest=" + numOfGuest + '}';
    }
    
    
}
