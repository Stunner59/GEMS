// Main.java

import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of users:");
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<User> userList = new ArrayList<>();
        for(int i=1;i<=n;i++) {
            System.out.println("Enter the details of user "+i);
            String[] details = sc.nextLine().split(",");
            userList.add(new User(details[0], details[1], details[2], details[3]));
        }
        
        System.out.println("Enter the number of cities:");
        int nc = Integer.parseInt(sc.nextLine());
        List<String> cities = new ArrayList<>(); 
    	for(int i=1;i<=nc;i++)
		{
			System.out.println("Enter the name of city " + i);
			cities.add(sc.next());
		}
        
        for(String city : cities) {
            CityCount cityCount = new CityCount(city, userList);
            cityCount.start();
            cityCount.join();
            System.out.println(cityCount.getCity()+"--"+cityCount.getCount());
        }
        
        sc.close();
	}
}


// User.java

public class User {
    private String name,mobileNumber,city,state;
    
    User() {}
    User(String name, String mobileNumber, String city, String state) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.city = city;
        this.state = state;
    }
    
    public void setName(String name) { this.name = name; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }
    public void setCity(String city) { this.city = city; }
    public void setState(String state) { this.state = state; }
    public String getName() { return this.name; }
    public String getMobileNumber() { return this.mobileNumber; }
    public String getCity() { return this.city; }
    public String getState() { return this.state; }
     
}


// CityCount.java

import java.util.List;
import java.util.ArrayList;

public class CityCount extends Thread {
    private String city;
    private Integer count;
    List<User> userList;
    
    public CityCount(String city, ArrayList<User> userList) {
        this.city = city;
        this.userList = userList;
        count = 0;
    }
    
    public void setCity(String city) { this.city = city; }
    public void setUserList(List<User> userList) { this.userList = userList; }
    public void setCount(Integer count) { this.count = count; }
    public String getCity() { return city; }
    public List<User> getUserList() { return userList; }
    public Integer getCount() { return count; }
    
    @Override
    public void run() {
        for(User user : userList) {
            if(user.getCity().equalsIgnoreCase(city))    count += 1;
        }
    }
    
}
