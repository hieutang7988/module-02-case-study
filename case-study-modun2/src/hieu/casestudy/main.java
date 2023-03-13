package hieu.casestudy;

import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

class Main {
    public static void main(String[] args) {
       menu();



    }

    public static void showMenu() {
        System.out.println("1. room Management");
        System.out.println("2. Customer Management");
        System.out.println("3. Invoice Management");
        System.out.println("0. exit");
        System.out.println("Enter option: ");
    }

    public static void menu() {

        Managable roomManagement = new RoomManagement();
        Managable customerManagement = new CustomerManagement();
        Managable invoiceManagement = new InvoiceManager();

        String option = "";
        Scanner scanner = new Scanner(System.in);
        while (!option.equals("0")) {
            showMenu();
            option = scanner.next();
            scanner.nextLine();
            switch (option) {
                case "1":
                 roomManagement.menu("Room Management");
                    break;
                case "2":
                    customerManagement.menu("Customer Management");
                    break;
                case "3":
                    invoiceManagement.menu("Invoice Management");
                    break;
                case "0":
                    System.exit(0);
                default:
                    System.out.println("The word entered is incorrect, please re-enter");
                    break;
            }
        }
    }
}
