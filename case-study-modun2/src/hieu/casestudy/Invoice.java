package hieu.casestudy;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;


public class Invoice  {
    private String invoiceName;
    private String customerCM;
    private String roomNumber;
    private Double numberDay;


    public Invoice(String invoiceName, String customerCM, String roomNumber, Double numberDay) {

        this.invoiceName = invoiceName;
        this.customerCM = customerCM;
        this.roomNumber = roomNumber;
        this.numberDay = numberDay;


    }



    public String getInvoiceName() {
        return invoiceName;
    }

    public void setInvoiceName(String invoiceName) {
        this.invoiceName = invoiceName;
    }

    public String getCustomerCM() {
        return customerCM;
    }

    public void setCustomerCM(String customerCM) {
        this.customerCM = customerCM;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Double getNumberDay() {
        return numberDay;
    }

    public void setNumberDay(Double numberDay) {
        this.numberDay = numberDay;
    }

    public double totalNumberOfDay ()  {
        String pattern = "dd/MM/yyyy";
        DateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Scanner scanner = new Scanner(System.in);

//        RoomManagement roomManagement = new RoomManagement();
//        Room r = roomManagement.searchByID(roomNumber);
//        DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = null;
        Date date2 = null;

        try {
            System.out.println("Input rent day again: ");
            String startDate = scanner.nextLine();

            date1 = simpleDateFormat.parse(startDate);

            System.out.println("Input return day again: ");
            String endDate = scanner.nextLine();

            date2 = simpleDateFormat.parse(endDate);

            double getDiff = date2.getTime() - date1.getTime();

            double getDaysDiff = getDiff / (24 * 60 * 60 * 1000);
            return getDaysDiff;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Double getTotal()  {
        RoomManagement roomManagement = new RoomManagement();
        Room r = roomManagement.searchByID(roomNumber);
        double total = r.getPrice()*totalNumberOfDay();
        return total;
    }

    public String toString2()  {
        return invoiceName + "\n"+customerCM + "\n"+ totalNumberOfDay() + "\n" +getTotal();
    }

    @Override
    public String toString() {
        String sout = null;

            sout = "invoiceName: "+ invoiceName+"\n"
                    + "customerCM: " + customerCM+"\n"
                    + "numberDay: " + totalNumberOfDay()+"\n"
                    +"==============\n"
                    +"total: " + getTotal();

        return sout;
    }
}
