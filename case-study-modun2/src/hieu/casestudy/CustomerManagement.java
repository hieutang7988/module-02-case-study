package hieu.casestudy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerManagement extends menu implements Managable {
    List<Customer> customers;
    Scanner scanner = new Scanner(System.in);
    public CustomerManagement () {
        customers = new ArrayList<>();
    }

    @Override
    public void add() {
        Customer c = input();
        customers.add(c);
    }
    public Customer
    input() {
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter CMND");
        String CM = scanner.nextLine();
        System.out.println("Enter address");
        String address = scanner.nextLine();
        return new Customer(name,CM,address);
    }

    @Override
    public void search() {
        System.out.println("Enter search CM");
        String CM = scanner.nextLine();
        Customer search = searchCM(CM);
        if(search!= null)
            System.out.println(search);
    }
    public Customer searchCM(String search) {
        for (Customer c: customers) {
            if(c.getCMND().equals(search))return c;
        }
        return null;
    }
    

    @Override
    public void update() {
        System.out.println("Enter search CM");
        String CM = scanner.nextLine();
        Customer update = searchCM(CM);
        if(update!= null) {
            System.out.println("Enter name");
            String name = scanner.nextLine();
            update.setName(name);
        }
    }

    @Override
    public void remove() {
        System.out.println("Enter search CM");
        String CM = scanner.nextLine();
        Customer remove = searchCM(CM);
        if(remove!= null) {
            customers.remove(remove);
        }
    }

    @Override
    public void displayAll() {
        for (Customer c: customers) {
            System.out.println(c);
        }
    }
}
