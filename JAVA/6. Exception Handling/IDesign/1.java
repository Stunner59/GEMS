// Main.java

import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name;
        Double deposit,costPerDay;
        System.out.println("Enter the Item type details:");
        System.out.println("Enter the name:");
        name = br.readLine();
        
        try {
            System.out.println("Enter the deposit:");
            deposit = Double.parseDouble(br.readLine());
            System.out.println("Enter the cost per day:");
            costPerDay = Double.parseDouble(br.readLine());
            ItemType itemType = new ItemType(name,deposit,costPerDay);
            System.out.println("The details of the item type are:");
            System.out.println(itemType.toString());
        } catch(NumberFormatException e) {
            System.out.println(e);
        }
        
        br.close();
	}
}


// ItemType.java

public class ItemType {
    String name;
    Double deposit,costPerDay;
    
    ItemType() {}
    
    public ItemType(String name, Double deposit, Double costPerDay) {
        this.name = name;
        this.deposit = deposit;
        this.costPerDay = costPerDay;
    }
    
    @Override
    public String toString()
    {
        return "Name:"+this.name+"\nDeposit:"+String.format("%.01f",this.deposit)+"\nCost Per Day:"+String.format("%.01f",this.costPerDay);
    }
}