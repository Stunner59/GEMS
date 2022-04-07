// Main.java

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws Exception {
        
        EventBO eventBO = new EventBO();
        
        // Reading from input.txt
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));  
        List<Event> events = eventBO.readFromFile(br); 
        br.close();
        
        // Removing Duplicates : Creating a list of unique events;
        events = removeDuplicates(events);
            
        // Writing to output.txt  
        FileWriter fr = new FileWriter("output.txt");
        eventBO.writeFile(events, fr);
        fr.close();
	}
    
    public static List<Event> removeDuplicates(List<Event> events) {
        Set<Event> e = new LinkedHashSet<Event>(events);
        return new ArrayList<Event>(e);
    }
    
}


// Event.java

public class Event {
    private String eventName,ownerName;
    private Integer attendeesCount;
    
    Event() {}
    Event(String eventName, Integer attendeesCount, String ownerName) {
        this.eventName = eventName;
        this.attendeesCount = attendeesCount;
        this.ownerName = ownerName;
    }
    
    void setEventName(String eventName) { this.eventName = eventName; }
    void setAttendeesCount(Integer attendeesCount) { this.attendeesCount = attendeesCount; }
    void setOwnerName(String ownerName) { this.ownerName = ownerName; }
    String getEventName() { return this.eventName; }
    Integer getAttendeesCount() { return this.attendeesCount; }
    String getOwnerName() {return this.ownerName; }
    
    @Override
    public String toString() { return eventName+","+attendeesCount+","+ownerName+"\n"; }
    
    // Checking hashcode for better performance of equals
    @Override public int hashCode()
    { return this.ownerName.length() % 10; }
    
    // IMPORTANT !
    // Need to override the equals method to check if two events are same
    // Equality of events is decided by the equality of their ownerName
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Event e = (Event)obj;
        return this.ownerName.equals(e.ownerName);
    }
    
}


// EventBO.java

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class EventBO {
    
    public List<Event> readFromFile(BufferedReader br) throws IOException {
        List<Event> events = new ArrayList<Event>();
        String st;
        while( (st = br.readLine()) != null ) {
            String[] details = st.split(",");
            if(details.length != 3) break;
            Event event = new Event(details[0], Integer.parseInt(details[1]), details[2]);
            events.add(event);
        }
        return events;
	}
    
    void writeFile(List<Event> eventList, FileWriter fr) throws Exception {
        BufferedWriter bw = new BufferedWriter(fr);
        for (Event event : eventList)
            bw.write(event.toString());
        bw.flush();
        bw.close();
    }
     
}