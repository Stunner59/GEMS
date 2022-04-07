// Main.java

import java.io.*;
public class Main {
	public static void main(String[] args)throws Exception{
		
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the contact details");
        String st=br.readLine();
        String[] str=st.split(",");
        ContactDetail contactDetail = new ContactDetail(str[0], str[1], str[2], str[3], str[4]);
        try {
            ContactDetailBO.validate(str[0], str[1]);
            System.out.println(contactDetail.toString()); 
        } catch(Exception e) {
            System.out.print(e);
        }
        
    
	}
}


// ContactDetail.java


public class ContactDetail {
	
    private String mobile;
	private	String alternateMobile;
	private	String landLine;
	private	String email;
	private String address;
	public ContactDetail(String mobile, String alternateMobile, String landLine, String email, String address) {
		this.mobile = mobile;
		this.alternateMobile = alternateMobile;
		this.landLine = landLine;
		this.email = email;
		this.address = address;
	}
	public ContactDetail()
	{
		
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAlternateMobile() {
		return alternateMobile;
	}
	public void setAlternateMobile(String alternateMobile) {
		this.alternateMobile = alternateMobile;
	}
	public String getLandLine() {
		return landLine;
	}
	public void setLandLine(String landLine) {
		this.landLine = landLine;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
    public String toString()
    {
        return "Mobile:"+this.mobile+"\nAlternate mobile:"+this.alternateMobile+"\nLandLine:"+this.landLine+"\nEmail:"+this.email+"\nAddress:"+this.address;
    }
}


// ContactDetailBO.java

public class ContactDetailBO {
		
	public static void validate(String mobile,String AlternateMobile) throws DuplicateMobileNumberException {
       if(mobile.equals(AlternateMobile)) {
        throw new DuplicateMobileNumberException("Mobile number and alternate mobile number are same");
       }
    }
}


// DuplicateMobileNumberException.java


public class DuplicateMobileNumberException extends Exception {
    
    public DuplicateMobileNumberException(String errorMessage) {  
    super(errorMessage);  
    }  
    
}
    
