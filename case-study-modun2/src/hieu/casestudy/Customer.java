package hieu.casestudy;

import java.util.Scanner;

public class Customer {
    // thuoc tinh
    private String name;
   public String CMND;
    private String address;

    public Customer(String name, String CMND, String address) {
        this.name = name;
        this.CMND = CMND;
        this.address = address;
    }

    public Customer() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "Name='" + name + '\'' +
                ", cardID=" + CMND +
                ", address=" + address +
                '}';
    }

}