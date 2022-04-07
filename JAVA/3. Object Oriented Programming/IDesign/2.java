// Main.java


import java.util.*;

public class Main {
	public static void main(String[] args){
        int ch;
        String[] inpArray;
		Scanner sc = new Scanner(System.in);
        System.out.print("Choose Account Type\n1.Savings Account\n2.Current Account\n");
        ch = sc.nextInt();
        sc.nextLine(); // This line is important!!!!
        
        switch(ch) {
            case 1:
                System.out.println("Enter Account details in comma separated(Account Name,Account Number,Bank Name,Organisation Name)");
                inpArray = sc.nextLine().split(",");
                SavingsAccount sacc = new SavingsAccount(inpArray[0],inpArray[1],inpArray[2],inpArray[3]);
                sacc.display();
                break;
            case 2:
                System.out.println("Enter Account details in comma separated(Account Name,Account Number,Bank Name,TIN Number)");
                inpArray = sc.nextLine().split(",");
                CurrentAccount cacc = new CurrentAccount(inpArray[0],inpArray[1],inpArray[2],inpArray[3]);
                cacc.display();
                break;
            default:
                System.out.println("Wrong Choice!");
        }
        
        sc.close();
	}
}

// Account.java


public class Account {
	protected String accName,accNo,bankName;
    
    Account() {}
    Account(String accName,String accNo, String bankName) {
        this.accName = accName;
        this.accNo = accNo;
        this.bankName = bankName;
    }
    
    void setAccName(String accName) {this.accName = accName;}
    void setAccNo(String accNo) {this.accNo = accNo;}
    void setBankName(String bankName) {this.bankName = bankName;}
    String getAccName() {return this.accName;}
    String getAccNo() {return this.accNo;}
    String getBankName() {return this.bankName;}

    protected void display() {
        System.out.println("Account Name:"+accName);
        System.out.println("Account Number:"+accNo);
        System.out.println("Bank Name:"+bankName);
    }
}


// SavingsAccount.java


public class SavingsAccount extends Account {
	private String orgName;
    
    SavingsAccount() {}
    
    SavingsAccount(String accName, String accNo, String bankName, String orgName) {
        super(accName,accNo,bankName);
        this.orgName = orgName;
    }
    
    void setAccName(String accName) {this.accName = accName;}
    void setAccNo(String accNo) {this.accNo = accNo;}
    void setBankName(String bankName) {this.bankName = bankName;}
    void setOrgName(String orgName) {this.orgName = orgName;}
    String getAccName() {return this.accName;}
    String getAccNo() {return this.accNo;}
    String getBankName() {return this.bankName;}
    String getOrgName() {return this.orgName;}
    
    public void display() {
        super.display();
        System.out.println("Organisation Name:"+orgName);
    }
}

// CurrentAccount.java


public class CurrentAccount extends Account {
	private String tinNumber;
    
    CurrentAccount() {}
    
    CurrentAccount(String accName, String accNo, String bankName, String tinNumber) {
        super(accName,accNo,bankName);
        this.tinNumber = tinNumber;
    }
    
    void setAccName(String accName) {this.accName = accName;}
    void setAccNo(String accNo) {this.accNo = accNo;}
    void setBankName(String bankName) {this.bankName = bankName;}
    void setTinNumber(String tinNumber) {this.tinNumber = tinNumber;}
    String getAccName() {return this.accName;}
    String getAccNo() {return this.accNo;}
    String getBankName() {return this.bankName;}
    String getTinNumber() {return this.tinNumber;}
    
    public void display() {
        super.display();
        System.out.println("TIN Number:"+tinNumber);
    }
}
