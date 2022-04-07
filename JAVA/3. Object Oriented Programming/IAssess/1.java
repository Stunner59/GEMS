// Main.java

import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws Exception {
    	Scanner sc = new Scanner(System.in);
        String startDate,endDate;
        Double gst = 0.0;
        System.out.print("Enter your choice:\n1.Exhibition event\n2.Stage event\n");
        int ch = sc.nextInt();
        String[] details;
        sc.nextLine();
        switch(ch) {
            case 1:
                System.out.println("Enter the details of exhibition:");
                details = sc.nextLine().split(",");
                Exhibition ex = new Exhibition(details[0],details[1],details[2],details[3],Double.parseDouble(details[4]),Integer.parseInt(details[5]));
                System.out.println("Enter the starting date of the event:");
                startDate = sc.next();
                System.out.println("Enter the ending date of the event:");
                endDate = sc.next();
                gst = ex.calculateGST(startDate, endDate);
                break;
            case 2:
                System.out.println("Enter the details of stage event:");
                details = sc.nextLine().split(",");
                StageEvent se = new StageEvent(details[0],details[1],details[2],details[3],Double.parseDouble(details[4]),Integer.parseInt(details[5]));
                System.out.println("Enter the starting date of the event:");
                startDate = sc.next();
                System.out.println("Enter the ending date of the event:");
                endDate = sc.next();
                gst = se.calculateGST(startDate, endDate);
                break;
            default:
                System.out.println("Wrong Choice!");
                System.exit(0);
        }
        
        System.out.println("The GST to be paid is Rs."+String.format("%.01f", gst));
        
        sc.close();
	}
    
}


// Event.java

import java.util.Date;
import java.util.concurrent.TimeUnit;

public abstract class Event {
    private String name,detail,type,ownerName;
    private Double costPerDay;
    
    abstract Double calculateGST(String startDate, String endDate);
    
    protected static long getDifferenceDays(Date d1, Date d2) {
    long diff = d2.getTime() - d1.getTime();
    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
    
    void setName(String name) {this.name = name;}
    void setDetail(String detail) {this.detail = detail;}
    void setType(String type) {this.type = type;}
    void setOwnerName(String ownerName) {this.ownerName = ownerName;}
    void setCostPerDay(Double costPerDay) {this.costPerDay = costPerDay;}
    
    String getName() {return this.name;}
    String getDetail() {return this.detail;}
    String getType() {return this.type;}
    String getOwnerName() {return this.ownerName;}
    Double getCostPerDay() {return this.costPerDay;}
}


// Exhibition.java

import java.util.Date;
import java.text.SimpleDateFormat;

public class Exhibition extends Event {
    private Integer noOfStalls;
    
    Exhibition(String name, String detail, String type, String ownerName, Double costPerDay, Integer noOfStalls) {
        setName(name);
        setDetail(detail);
        setType(type);
        setOwnerName(ownerName);
        setCostPerDay(costPerDay);
        this.noOfStalls = noOfStalls;
    }
    
    Integer getNoOfStalls() {return noOfStalls;}
    
    @Override
    Double calculateGST(String startDate, String endDate) {
        Double gst = 0.0;
        try {
            Date startDatee = new SimpleDateFormat("dd-MM-yyyy").parse(startDate);
            Date endDatee = new SimpleDateFormat("dd-MM-yyyy").parse(endDate);
            Double totalCost = getDifferenceDays(startDatee,endDatee) * getCostPerDay();
            gst = 0.05 * totalCost;
        }
        catch (Throwable e) {
          e.printStackTrace();
        }
        return gst;
    }
}



// StageEvent.java

import java.util.Date;
import java.text.SimpleDateFormat;

public class StageEvent extends Event {
    Integer noOfSeats;
    
    StageEvent(String name, String detail, String type, String ownerName, Double costPerDay, Integer noOfSeats) {
        setName(name);
        setDetail(detail);
        setType(type);
        setOwnerName(ownerName);
        setCostPerDay(costPerDay);
        this.noOfSeats = noOfSeats;
    }
    
    Integer getNoOfSeats() {return noOfSeats;}
    
    @Override
    Double calculateGST(String startDate, String endDate) {
        Double gst = 0.0;
        try {
            Date startDatee = new SimpleDateFormat("dd-MM-yyyy").parse(startDate);
            Date endDatee = new SimpleDateFormat("dd-MM-yyyy").parse(endDate);
            Double totalCost = getDifferenceDays(startDatee,endDatee) * getCostPerDay();
            gst = 0.15 * totalCost;
        }
        catch (Throwable e) {
          e.printStackTrace();
        }
        return gst;
    }
}