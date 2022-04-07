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