// Main.java

import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of address:");
        int n = sc.nextInt();
	  sc.nextLine();
        
        Map<String,Map<String,Integer>> myMap = new TreeMap<>();
        List<Address> addressList = new ArrayList<Address>();
        
        for(int i=1;i<=n;i++) {
            System.out.println("Enter the address:");
            String[] details = (sc.nextLine()).split(",");
            Address address = new Address(details[0], details[1], details[2], Integer.parseInt(details[3]));
            addressList.add(address);
        }
        
        // Creating Map<Sate, Map<City,Count>>
        for (Address address : addressList) {
            String state = address.getState();
            String city = address.getCity();
            
            if(myMap.containsKey(state)) {
                Map<String,Integer> subMap = myMap.get(state);
                if(subMap.containsKey(city))
                    subMap.replace(city, subMap.get(city)+1);
                else
                    subMap.put(city,1);
            } else {
                Map<String,Integer> subMap = new TreeMap<>();
                subMap.put(city,1);
                myMap.put(state,subMap);
            }
        }
        
        System.out.println("Number of entries in city/state wise:");
        for(String state : myMap.keySet()) {
            System.out.println("\nState:"+state);
            Map<String,Integer> subMap = myMap.get(state);
            for(String city : subMap.keySet()) {
                System.out.println("City:"+city+" Count:"+subMap.get(city));
            }
        }
        
        sc.close();
	}
    

}


// Address.java ( ! Create this file )

public class Address {
    private String area,city,state;
    private Integer pincode;
    
    Address() {}
    Address(String area, String city, String state, Integer pincode) {
        this.area = area;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }
    
    void setArea(String area) { this.area = area; }
    void setCity(String city) { this.city = city; }
    void setState(String State) { this.state = state; }
    void setPincode(Integer pincode) { this.pincode = pincode; }
    String getArea() { return this.area; }
    String getCity() { return this.city; }
    String getState() { return this.state; }
    Integer getPincode() { return this.pincode; }

}