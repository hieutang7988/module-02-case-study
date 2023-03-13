package hieu.casestudy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;

public class InvoiceManager extends menu implements Managable {
    List<Invoice> invoices;


    public InvoiceManager(){
        invoices = new ArrayList<>();
    }
    public Invoice input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Invoice ID: ");
        String invoiceID = scanner.nextLine();
        System.out.println("Enter Customer CM: ");
        String customer = scanner.nextLine();
        System.out.println("Enter roomNumber: ");
        String roomNumber = scanner.nextLine();
        System.out.println("Enter numberDay: ");
        double numberDay = scanner.nextDouble();

        Invoice invoice1 = new Invoice(invoiceID, customer,roomNumber, numberDay);
        return invoice1;
    }
    public void add(){

            Invoice newInvoice = input();
            invoices.add(newInvoice);
           saveToFile();
    }
    public Invoice searchById(String searchID) {
        for (Invoice inv: invoices) {
            if(inv.getInvoiceName().equals(searchID)){
                return inv;
            }
        }
        return null;
    }
    public void search() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input id to search: ");
        String searchID = scanner.next();

        Invoice searchInvoice =searchById(searchID);
        if (searchInvoice!=null){
            System.out.println(searchInvoice);
        }
        else
            System.out.println("Invoice not found");
    }

    @Override
    public void update() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input id to update: ");
        String updateID = scanner.next();

        Invoice updateInvoice = searchById(updateID);
        if (updateInvoice!=null){
            System.out.println("Please enter new ID : ");
            String InvoiceName = scanner.nextLine();
            updateInvoice.setCustomerCM(InvoiceName);
            System.out.println(updateInvoice);
            saveToFile();
        }
        else
            System.out.println("Invoice not found");

    }

    @Override
    public void remove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input id to remove: ");
        String removeID = scanner.next();

        Invoice removeInvoice = searchById(removeID);
        if (removeInvoice!=null){
            invoices.remove(removeInvoice);
        }
        else
            System.out.println("Invoice not found");
    }

    public void displayAll() {
        for (Invoice inv: invoices) {
            System.out.println(inv );
        }
    }


    private void saveToFile() {
            try {
            FileWriter newFile = new FileWriter("invoice.csv",false);
            BufferedWriter bufferedWriter = new BufferedWriter(newFile);
            for (Invoice i:invoices) {
                bufferedWriter.write(i.toString2());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            newFile.close();
        }catch (Exception e){
            System.err.println(e);
        }
    }
}
