// Main.java

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the user details");
        String[] details = (sc.nextLine()).split(",");
        User user = new User(details[0],details[1],details[2],details[3]);
        UserBO userBO = new UserBO();
        
        try {
            userBO.validate(user);
            System.out.println(user.toString());
        } catch(WeakPasswordException e) {
            System.out.println(e);
        }
        sc.close();
	}
}



// UserBO.java

public class UserBO {
    static void validate(User u) throws WeakPasswordException {
        char[] chars = (u.getPassword()).toCharArray();
        int nd=0,nsc=0,nl=0,nw=0;
        for (char c : chars) {
            if(Character.isLetter(c)) nl+=1;
            else if(Character.isDigit(c)) nd+=1;
            else if(Character.isWhitespace(c)) nw+=1;
            else nsc+=1;
        }
        if(!( (chars.length >=10 && chars.length <=20) && nd>0 && nsc>0 && nl>0 )) {
            throw new WeakPasswordException("Your password is weak");  
        }
	}
}



// User.java

public class User {
    private String name,mobile,username,password;
    
    User() {}
    
    User(String name,String mobile,String username,String password) {
        this.name = name;
        this.mobile = mobile;
        this.username = username;
        this.password = password;
    }
    
    void setName(String name) {
        this.name = name;
    }
    
    void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    void setUserName(String username) {
        this.username = username;
    }
    
    void setPassword(String password) {
        this.password = password;
    }
    
    String getName() {
        return this.name;
    }
    
    String getMobile() {
        return this.mobile;
    }
    
    String getUsername() {
        return this.username;
    }
    
    String getPassword() {
        return this.password;
    }
    
    @Override
    public String toString() {
        return "Name:"+this.name+"\nMobile:"+this.mobile+"\nUsername:"+this.username+"\nPassword:"+this.password;  
    }
}


// WeakPasswordException.java

public class WeakPasswordException extends Exception {
    public WeakPasswordException(String errorMessage) {  
    super(errorMessage);  
    }  
}