// Main.java

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of events");
        int n = sc.nextInt();
        sc.nextLine();
        List<Event> events = new ArrayList<>();
        System.out.println("Enter event details in CSV(Event Name,Organiser Name,Event Cost)");
        for(int i=1;i<=n;i++) {
            String[] details = sc.nextLine().split(",");
            events.add(new Event(details[0],details[1],Double.parseDouble(details[2])));
        }
        Event event = new Event();
        event.display(events); 
        sc.close();
    }   
    
    
}

// Event.java

import java.util.List;

class Event {
    private String eventName,organiserName;
    private Double eventCost;
    
    Event(){}
    Event(String eventName,String organiserName,Double eventCost) {
        this.eventName = eventName;
        this.organiserName = organiserName;
        this.eventCost = eventCost;
    }
    
    public void setEventName(String eventName) { this.eventName = eventName; }
    public void setOrganiserName(String organiserName) { this.organiserName = organiserName; }
    public void setEventCost(Double eventCost) { this.eventCost = eventCost; }
    public String getEventName() { return eventName; }
    public String getOrganiserName() { return organiserName; }
    public Double getEventCost() { return eventCost; }
    
    void display(List<Event> eventList) {
        eventList.forEach(event -> {
            System.out.println(event);
        });
    }
    
    @Override
    public String toString() {
        return String.format("%s|%s|%.1f",this.getEventName(),this.getOrganiserName(),this.getEventCost());
    }
    
}


