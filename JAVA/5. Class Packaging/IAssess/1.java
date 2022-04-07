// Main.java

import java.util.Scanner;

public class Main {

	public static void main(String[] args){
	  Scanner sc = new Scanner(System.in);
        String street,city,country;
        int pincode;
        System.out.println("Enter Customer Address");
        System.out.println("Enter the street");
        street = sc.nextLine();
        System.out.println("Enter the city");
        city = sc.nextLine();
        System.out.println("Enter the pincode");
        pincode = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the country");
        country = sc.nextLine();
        
        Address address = new Address(street,city,pincode,country);
        
        address.displayAddress();
        
        sc.close();
	}

}


// Address.java

public class Address{
    public String street,city,country;
    public int pincode;
    
    Address(){}
    Address(String street, String city, int pincode, String country) {
        this.street = street;
        this.city = city;
        this.pincode = pincode;
        this.country = country;
    }
    
    public void setStreet(String street) { this.street = street; }
    public void setCity(String city) { this.city = city; }
    public void setPincode(int pincode) { this.pincode = pincode; }
    public void setCountry(String country) { this.country = country; }
    public String getStreet() { return street; }
    public String getCity() { return city; }
    public int getPincode() { return pincode; }
    public String getCountry() { return country; }
    
    void displayAddress() {
        System.out.format("Street: %s\nCity: %s\nPincode: %d\nCountry: %s\n",street,city,pincode,country);
    }
}

