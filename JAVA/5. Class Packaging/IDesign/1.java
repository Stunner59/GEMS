// Main.java

import java.util.Scanner; 
public class Main {

	public static void main(String[] args){
	  Scanner sc = new Scanner(System.in);
        System.out.println("Enter the country name");
        String name = sc.nextLine();
        System.out.println("Enter the country code");
        String countryCode = sc.nextLine();
        System.out.println("Enter the isd code");
        String isdCode = sc.nextLine();
        Country country = new Country(name,countryCode,isdCode);
        System.out.println(String.format("Country Name:%s\nCountry Code:%s\nISD Code:%s",name,countryCode,isdCode));
        sc.close();
	}

}


// Country.java

public class Country{
    public String name,countryCode,isdCode;
    
    Country(String name, String countryCode, String isdCode) {
        this.name = name;
        this.countryCode = countryCode;
        this.isdCode = isdCode;
    }
}