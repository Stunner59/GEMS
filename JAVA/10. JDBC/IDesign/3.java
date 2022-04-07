// Main.java


import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String countryName,airportCode,airportName,city;
        System.out.println("Enter the Airport Code :");
        airportCode = br.readLine();
        System.out.println("Enter the Airport name :");
        airportName = br.readLine();
        System.out.println("Enter the City :");
        city = br.readLine();
	    System.out.println("Enter the Country name :");
        countryName = br.readLine();
        Airport airport = new Airport(airportCode,airportName,city,countryName);
        AirportDAO airportDAO = new AirportDAO();
        airportDAO.insertAirport(airport);
        System.out.format("%-10s %-40s %-10s %s\n","IATA Code","Name","City","Country");
        ArrayList<Airport> airportList = airportDAO.listAirport();
        for(Airport airportt : airportList) {
            System.out.format("%-10s %-40s %-10s %s\n",airportt.getIataAirportCode(), airportt.getName(),airportt.getCity(),airportt.getCountry());
        }
        br.close();
    }
}



// Airport.java

public class Airport {
	String iataAirportCode,name,city,country;

	public Airport() {}

	public Airport(String iataAirportCode, String name, String city, String country) {
		super();
		this.iataAirportCode = iataAirportCode;
		this.name = name;
		this.city = city;
		this.country = country;
	}

	public String getIataAirportCode() {
		return iataAirportCode;
	}

	public void setIataAirportCode(String iataAirportCode) {
		this.iataAirportCode = iataAirportCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
    
}


// AirportDAO.java

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AirportDAO {

    public void insertAirport(Airport airportIns) throws ClassNotFoundException, SQLException{
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        String query1 = String.format("INSERT INTO airport (iata_airport_code, name, city, country_name) VALUES ('%s', '%s', '%s', '%s')",airportIns.getIataAirportCode(),airportIns.getName(),airportIns.getCity(),airportIns.getCountry());
        stmt.executeUpdate(query1);
        con.close();
    }
    
    public ArrayList<Airport> listAirport() throws ClassNotFoundException, SQLException{  
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ArrayList<Airport> airportList = new ArrayList<Airport>();
        ResultSet rs = stmt.executeQuery("select iata_airport_code,name,city,country_name from airport");  
        while(rs.next()) {
            Airport airport = new Airport(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            airportList.add(airport);
        }
        con.close();
        return airportList;
    }
}


// DBConnection.java

import java.sql.*;
import java.util.ResourceBundle;
public class DBConnection {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {        
        ResourceBundle rb = ResourceBundle.getBundle("oracle");
        String url = rb.getString("db.url");
        String username = rb.getString("db.username");
        String password = rb.getString("db.password");
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection con = DriverManager.getConnection(url,username,password);
        return con;
    }
}