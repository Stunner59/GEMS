// Main.java

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the number of User details to be added");
        int n = sc.nextInt();
        UserBO userBO = new UserBO();
        userBO = UserBO.getList();
        sc.nextLine();
        List<User> users = new ArrayList<User>();
        for(int i=1;i<=n;i++) {
            System.out.println("Enter the user "+i+" detail in csv format");
            String[] details = sc.nextLine().split(",");
            User user = new User(details[0],details[1],details[2],details[3]);
            users.add(user);
        }
        userBO.addAll(users);
        System.out.println(getHeader());
        for(User user : userBO) {
            user.display();
        }
        System.out.println("Enter the range to be removed from array list");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        userBO.removeUser(n1,n2);
        
        System.out.println(getHeader());
        for(User user : userBO) {
            user.display();
        }
        
        sc.close();
	}
    
    static String getHeader() {
        return String.format("%-20s%-20s%-20s%-20s","Name","Contact Number","Username","Email");
    }
}


// UserBO.java

import java.util.ArrayList;

public class UserBO extends ArrayList<User>{
    public static UserBO getList(){
		UserBO u=new UserBO();
		u.add(new User("mohan Raja","9874563210","mohan","mohan@abc.in"));
		u.add(new User("arjun Ravi","4324237","arjun","arjun@abc.in"));
		u.add(new User("Arun kumar","9845671230","arun","arun@abc.in"));
		u.add(new User("prakash raj","7548921445","prakash","raj@abc.in"));
		return u;
	}
    
    void removeUser(int n1, int n2) {
        this.removeRange(n1,n2);
    }
    
}


// User.java

public class User{
    private String name,contactNumber,userName,email;
    
    User() {}
    User(String name, String contactNumber, String userName, String email) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.userName = userName;
        this.email = email;
    }
    
    public void setName(String name) { this.name = name ;}
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
    public void setUserName(String userName) {this.userName = userName; }
    public void setEmail(String email) { this.email = email; }
    public String getName() { return name; }
    public String getContactNumber() { return contactNumber; }
    public String getUserName() { return userName; }
    public String getEmail() { return email; }
    
    void display() {
        System.out.format("%-20s%-20s%-20s%-20s\n",name,contactNumber,userName,email);
    }
    
}