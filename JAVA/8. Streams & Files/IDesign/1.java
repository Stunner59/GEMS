// Main.java

import java.io.*;
import java.util.List;

public class Main {

	public static void main(String[] args) throws FileNotFoundException,IOException {
		UserBO userBO = new UserBO();
		List<User> users = userBO.readFromFile(new BufferedReader(new FileReader("input.csv")));
        if(users.size()>0) {
            System.out.print(String.format("%-15s %-20s %-15s %s\n","Name","Email","Username","Password"));
            userBO.display(users);
        } else {
            System.out.println("The list is empty");
        }
	}
}


// User.java


public class User {
	
    private String name,email,username,password;
    
    User() {}
    
    User (String name, String email, String username, String password) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }
    
    void setName(String name) {
        this.name = name;
    }
    
    void setEmail(String email) {
        this.email = email;
    }
    
    void setUsername(String username) {
        this.username = username;
    }
    
    void setPassword(String password) {
        this.password = password;
    }
    
    String getName() {
        return this.name;
    }
    
    String getEmail() {
        return this.email;
    }
    
    String getUsername() {
        return this.username;
    }
    
    String getPassword() {
        return this.password;
    }
    
    @Override
    public String toString() {
        return String.format("%-15s %-20s %-15s %s\n",this.name,this.email,this.username,this.password);
    }

}


// UserBO.java

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserBO {
	public List<User> readFromFile(BufferedReader br) throws IOException {
        List<User> users = new ArrayList<User>();
        String st;
        while((st = br.readLine()) != null) {
            String[] details = st.split(",");
            User user = new User(details[0], details[1], details[2], details[3]);
            users.add(user);
        }
        return users;
	}
    
    public void display(List<User> list) {
        for(User user : list) {
            System.out.print(user);    
        }
    }
}

