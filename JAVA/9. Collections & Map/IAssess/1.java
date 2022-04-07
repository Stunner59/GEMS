// Main.java

import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        Set<User> users = new HashSet<User>();
        System.out.println("Enter number of users:");
        int n = sc.nextInt();
        String username,bankname;
        sc.nextLine();
        for(int i=1;i<=n;i++) {
            System.out.println("Enter details of user"+i);
            System.out.println("Username:");
            username = sc.nextLine();
            System.out.println("Bank name:");
            bankname = sc.nextLine();
            User user = new User(username,bankname);
            users.add(user);
        }
        
        List<User> usersList = new ArrayList<User>(users);
        Collections.sort(usersList);
    
        
        List<User> expiringUsers = new ArrayList<User>();
        System.out.println("Enter username(Expire in one month) seperated by comma");
        String[] unameList = (sc.nextLine()).split(",");
        for(String name : unameList) {
            User user = new User(name,null);
            expiringUsers.add(user);
        }
        
        usersList.retainAll(expiringUsers);
        
        System.out.println("Users going to expire within a month");
        int i = 1;
        for (User user : usersList) {
            System.out.println("User "+i++);
            System.out.print(user);
        }
        sc.close();
	}
}


// User.java

public class User implements Comparable<User> {
    private String username;
	private String bankname;
	
	public User(){
	}

	public User(String username, String bankname) {
		super();
		this.username = username;
		this.bankname = bankname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	
   @Override
    public boolean equals(Object obj) {
        if(obj instanceof User)
        {
            User temp = (User) obj;
            return this.username.equals(temp.username);
        }
        return false;
    }

    @Override
    public int hashCode() { 
        return this.username.length() % 10;        
    }
    
    // For Sorting based on username
    @Override 
    public int compareTo(User compareUser)
    {
        return this.username.compareTo(compareUser.getUsername());
    }
    
    @Override
    public String toString() {
        return String.format("User Name = %s\nBank Name = %s\n",this.username,this.bankname);
    }
 
}