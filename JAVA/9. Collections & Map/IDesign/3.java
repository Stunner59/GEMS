// Main.java

import java.util.*;

public class Main {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
        Map<String,List<Address>> myMap = new HashMap<String,List<Address>>();
        System.out.println("Enter the number of address");
        Integer n = sc.nextInt();
        List<Address> addressList = new ArrayList<Address>();
        sc.nextLine();
        for(int i=1;i<=n;i++) {
            System.out.println("Enter the address "+i+" detail");
            String[] details = (sc.nextLine()).split(",");
            Address address = new Address(details[0], details[1], details[2], details[3], Integer.parseInt(details[4]));
            addressList.add(address);
        }
        
        System.out.println("Enter the city to be searched");
        String searchCity = sc.nextLine();
        
        // Creating Map<String,List<Address>>
        for (Address address : addressList) {
            String city = address.getCity();
            if(myMap.get(city) == null)
                myMap.put(city, new ArrayList<Address>()); 
            myMap.get(city).add(address);
        }
        // Searching
        if(myMap.containsKey(searchCity)) {
            List<Address> found = myMap.get(searchCity);
            System.out.print(String.format("%-15s %-15s %-15s %-15s %s\n","Line 1","Line 2","City","State","Pincode"));
            for (Address address : found) {
                System.out.print(address);
            }
        } else {
            System.out.println("Searched city not found");
        }
        
        sc.close();
	
	}

}


// Address.java

public class Address {
    private String addressLine1,addressLine2,city,state;
    private Integer pincode;
    
    // Constructors
    Address() {}
    Address(String addressLine1, String addressLine2, String city, String state, Integer pincode) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }
    
    // Setters
    
    void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }
    
    void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }
    
    void setCity(String city) {
        this.city = city;
    }
    
    void setState(String State) {
        this.state = state;
    }
    
    void setPincode(Integer pincode) {
        this.pincode = pincode;
    }
    
    // Getters
    
    String getAddressLine1() {
        return this.addressLine2;
    }
    
   String getAddressLine2() {
        return this.addressLine2;
    }
    
    String getCity() {
        return this.city;
    }
    
    String getState() {
        return this.state;
    }
    
    Integer getPincode() {
        return this.pincode;
    }
    
    @Override
    public String toString() {
        return String.format("%-15s %-15s %-15s %-15s %s\n",this.addressLine1,this.addressLine2,this.city,this.state,this.pincode);
    }


}