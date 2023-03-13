package hieu.casestudy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class RoomManagement implements Managable {
    String pattern = "MM/dd/yyyy HH:mm:ss";
    DateFormat df = new SimpleDateFormat(pattern);

    List<Room> rooms;
    public RoomManagement() {
        rooms = new ArrayList<>();
        Room r = new Room("p001",);
        Room r1 = new Room("p002");
        rooms.add(r);
        rooms.add(r1);
    }
    public Room input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter RoomNumber: ");
        String roomNumber = scanner.next();
        System.out.println("Enter Type: ");
        String type  = scanner.next();
        System.out.println("Enter Price: ");
        Double price = scanner.nextDouble();
        Room newRoom = new Room(roomNumber);
        return newRoom;
    }
    public void add(){
        Room newRoom = input();
        rooms.add(newRoom);
    }
    public void thue(){
        displaytrue();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter RoomNumber: ");
        String option = scanner.next();

        Room room = searchByID(option);

        Date today = Calendar.getInstance().getTime();
        String rentDay = df.format(today);
        room.setThue(rentDay);

        room.setStatus(false);
    }
    public void displaytrue(){
        for (Room r : rooms){
            if (r.getStatus()==true){
                System.out.println(r);
            }
        }
    }
    public Room searchByID(String searchID){
        for (Room newR: rooms) {
            if(newR.getRoomNumber().equals(searchID)){
                return  newR;
            }
        }
        return null;
    }
    public void search() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter RoomNumber: ");
        String searchID = scanner.next();
        Room searchRoom = searchByID(searchID);
        if(searchRoom.getRoomNumber().equals(searchID)){
            System.out.println(searchRoom);
        }else
            System.out.println("Room not found");
    }

    @Override
    public void update() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter RoomNumber: ");
        String option = scanner.next();

        Room room = searchByID(option);
        Date today = Calendar.getInstance().getTime();
        String returnDay = df.format(today);
        room.setTra(returnDay);

        room.setStatus(true);
    }

    @Override
    public void remove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter RoomNumber: ");
        String option = scanner.next();
        Room removeRoom = searchByID(option);
        rooms.remove(removeRoom);
    }

    public void displayAll() {
        for (Room newR: rooms) {
            System.out.println(newR);
        }
    }

    @Override
    public void menu(String displayMenu) {
        String option = "-1";
        while (!option.equals("0")) {
            showMenu(displayMenu);
            Scanner sc = new Scanner(System.in);
            option = sc.nextLine();
            switch (option) {
                case "1":
                    add();
                    break;
                case "2":
                    thue();
                    break;
                case "3":
                    update();
                    break;
                case "4":
                    search();
                    break;
                case "5":
                    remove();
                    break;
                case "6":
                    displayAll();
                    break;
                default:
                    System.out.println("Please choice again");
            }
        }

    }
        public void showMenu(String displayMenu) {
            System.out.println("======"+displayMenu+"=======");
            System.out.println("1.Add : ");
            System.out.println("2.thue :");
            System.out.println("3.update: ");
            System.out.println("4.Search :");
            System.out.println("5.Remove: ");
            System.out.println("6.DisplayAll: ");
            System.out.println("0.Exit:");
            System.out.println("======"+displayMenu+"========");
            System.out.println("Select option: ");
        }




}
