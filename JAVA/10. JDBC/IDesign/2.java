// Main.java

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;


public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the name of TravelClass :");
        String name = br.readLine();
        System.out.println("Enter the description to update :");
        String description = br.readLine();
        TravelClassDAO travelClassDAO = new TravelClassDAO();
        travelClassDAO.updateDetail(name,description);
        System.out.println("Updated List of Travel Classes");
        System.out.format("%-25s %s\n","Name","Description");
        ArrayList<TravelClass> updatedList = travelClassDAO.listAllTravelClassess();
        for(TravelClass travelClass : updatedList) {
            System.out.format("%-25s %s\n",travelClass.getName(),travelClass.getDescription());
        }
        br.close();
    }
}


// TravelClass.java

public class TravelClass {
    String name,description;

    public TravelClass() {
    }

    public TravelClass(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}


// TravelClassDAO.java

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TravelClassDAO {
    ArrayList<TravelClass> listAllTravelClassess() throws ClassNotFoundException, SQLException {
        ArrayList<TravelClass> travelClassList = new ArrayList<TravelClass>();
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select name,description from travel_class ORDER BY name DESC");  
        while(rs.next()) {
            TravelClass travelClass = new TravelClass(rs.getString(1), rs.getString(2));
            travelClassList.add(travelClass);
        }
        con.close();
        return travelClassList;
    }
    public void updateDetail(String name, String description) throws ClassNotFoundException, SQLException {
    	Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        String query1 = String.format("Update travel_class Set description='%s' Where name = '%s'",description,name);
        stmt.executeUpdate(query1);
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