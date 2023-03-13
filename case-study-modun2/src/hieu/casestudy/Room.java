package hieu.casestudy;

public class Room {
    private String roomNumber;
    private String type;
    private double price;
    private String thue;
    private static String tra;
    private Boolean status;

    public Room(String roomNumber, String type, double price, String thue, Boolean status) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.thue = thue;
        this.status = status;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getThue() {
        return thue;
    }

    public void setThue(String thue) {
        this.thue = thue;
    }

    public static String getTra() {
        return tra;
    }

    public void setTra(String tra) {
        this.tra = tra;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", thue='" + thue + '\'' +
                ", tra=" + tra +
                ", status=" + status +
                '}';
    }
}

