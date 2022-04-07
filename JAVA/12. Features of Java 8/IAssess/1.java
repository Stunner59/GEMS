// Main.java

import java.util.*; 
import java.util.stream.*;

class Main
{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of bookings");
        int n = Integer.parseInt(sc.nextLine());
        List<TicketBooking> bookings = new ArrayList<>();
        for(int i=1;i<=n;i++) {
            System.out.println("Enter customer name");
            String name = sc.nextLine();
            System.out.println("Enter number of tickets");
            int nt = Integer.parseInt(sc.nextLine());
            System.out.println("Enter the price");
            Double price = Double.parseDouble(sc.nextLine());
            bookings.add(new TicketBooking(name,nt,price));
        }
        System.out.format("%-10s %-15s %-15s\n", "Customer", "No Of Tickets", "Price");
        bookings.stream().sorted((p1, p2)->p1.getPrice().compareTo(p2.getPrice())).forEach(System.out::println);
        sc.close();
    }
}


// TicketBooking.java

class TicketBooking{
    private String customerName;
    private Integer noOfTickets;
    private Double price;
    
    TicketBooking(String customerName, Integer noOfTickets, Double price){
        this.customerName = customerName;
        this.noOfTickets = noOfTickets;
        this.price = price;
    }
    String getCustomerName(){
        return this.customerName;
    }
    Integer getNoOfTickets(){
        return this.noOfTickets;
    }
    Double getPrice(){
        return this.price;
    }
    @Override
    public String toString() {
        return String.format("%-10s %-15d %-15.1f\n",customerName,noOfTickets,price);
    } 
}
