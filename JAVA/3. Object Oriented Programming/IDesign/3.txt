// Main.java

import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
	    Scanner sc = new Scanner(System.in);
        String accNumber;
        Double balance,transfer;
        System.out.println("Enter your account number:");
        accNumber = sc.next();
        System.out.println("Enter the balance of the account:");
        balance = sc.nextDouble();
        System.out.print("Enter the type of transfer to be made:\n1.NEFT\n2.IMPS\n3.RTGS\n");
        int ch = sc.nextInt();
        System.out.println("Enter the amount to be transferred:");
        transfer = sc.nextDouble();
        switch(ch) {
            case 1:
                NEFTTransfer neft = new NEFTTransfer(accNumber,balance);
                if (!(neft.validate(transfer))) {
                    System.out.println("Account number or transfer amount seems to be wrong");
                    return;
                } 
                if (neft.transfer(transfer)) {
                    System.out.println("Transfer occurred successfully");
                    System.out.println("Remaining balance is "+String.format("%.01f",neft.getBalance()));
                } else {
                    System.out.println("Transfer could not be made");
                }
                break;
            case 2:
                IMPSTransfer imps = new IMPSTransfer(accNumber,balance);
                if (!(imps.validate(transfer))) {
                    System.out.println("Account number or transfer amount seems to be wrong");
                    return;
                } 
                if (imps.transfer(transfer)) {
                    System.out.println("Transfer occurred successfully");
                    System.out.println("Remaining balance is "+String.format("%.01f",imps.getBalance()));
                } else {
                    System.out.println("Transfer could not be made");
                }
                break;
            case 3:
                RTGSTransfer rtgs = new RTGSTransfer(accNumber,balance);
                if (!(rtgs.validate(transfer))) {
                    System.out.println("Account number or transfer amount seems to be wrong");
                    return;
                } 
                if (rtgs.transfer(transfer)) {
                    System.out.println("Transfer occurred successfully");
                    System.out.println("Remaining balance is "+String.format("%.01f",rtgs.getBalance()));
                } else {
                    System.out.println("Transfer could not be made");
                }
                break;
            default:
                System.out.println("Wrong choice!");
            
        }
        
        
        
        sc.close();
	}
}


// FundTransfer.java


public abstract class FundTransfer {
    private String accountNumber;
    private Double balance;
    
    Boolean validate(Double transfer) {
        return accountNumber.length() == 10 && (transfer>=0 && transfer<balance);
    }

    abstract Boolean transfer(Double transfer);
    
    void setAccountNumber(String accountNumber) {this.accountNumber = accountNumber;}
    void setBalance(Double balance) {this.balance = balance;}
    String getAccountNumber() {return accountNumber;}
    Double getBalance() {return balance;}
    
}


// RTGSTransfer.java


public class RTGSTransfer extends FundTransfer {
    
    RTGSTransfer(String accountNumber, Double balance) {
        super.setAccountNumber(accountNumber);
        super.setBalance(balance);
    }
	
    @Override
    Boolean transfer(Double transfer) {
        if (transfer>10000) {
            super.setBalance(super.getBalance() - transfer);
            return true;
        }
        return false;
    }	
    
}


// NEFTTransfer.java


public class NEFTTransfer extends FundTransfer {
    
    NEFTTransfer(String accountNumber, Double balance) {
        super.setAccountNumber(accountNumber);
        super.setBalance(balance);
    }
    
    @Override
    Boolean transfer(Double transfer) {
        if (transfer+0.05*transfer < super.getBalance()) {
            super.setBalance(super.getBalance() - (transfer+0.05*transfer));
            return true;
        }
        return false;
    }
    
}


// IMPSTransfer.java

public class IMPSTransfer extends FundTransfer {
    
    IMPSTransfer(String accountNumber, Double balance) {
        super.setAccountNumber(accountNumber);
        super.setBalance(balance);
    }
    
    @Override
    Boolean transfer(Double transfer) {
        if (transfer+0.02*transfer < super.getBalance()) {
            super.setBalance(super.getBalance() - (transfer+0.02*transfer));
            return true;
        }
        return false;
    }
    
}
