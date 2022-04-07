// Main.java

import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Events");
        int n = sc.nextInt();
        Event[] events = new Event[n];
        System.out.println("Enter event details in CSV(Event Name,Start Date,End Date) Date:dd/MM/yyyy");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        sc.nextLine();
        for(int i=0;i<n;i++) {
            String[] details = (sc.nextLine()).split(",");
            try {
                Event event = new Event(details[0], formatter.parse(details[1]), formatter.parse(details[2]));
                events[i] = event;
            }
               
            catch(Exception e) {
                 e.printStackTrace();
            }
            
        }
        
        int flag = 0;
        System.out.println("1-day Events:");
        for (Event event : events) {
            if(event.getDifferenceDays() == 0) {
                System.out.println(event.getEventName());
                flag = 1;
            }
        }
        if(flag == 0) {
            System.out.println("No Events");
        }
            
        sc.close();
	}

}


// Event.java

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Event {
    
    private String eventName;
    private Date startDate,endDate;
    
    Event(){}
    Event(String eventName, Date startDate, Date endDate) {
        this.eventName = eventName;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public void setEventName(String eventName) { this.eventName = eventName; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }
    public String getEventName() { return eventName; }
    public Date getStartDate() { return startDate; }
    public Date getEndDate() { return endDate; }
    
    public long getDifferenceDays() {
        long diff = endDate.getTime() - startDate.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
}
