// Main.java

import java.util.Scanner;

public class Main {
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        System.out.println("Enter the number of items:");
        Integer nItems = sc.nextInt();
        Item[] items = new Item[nItems];
        System.out.println("Enter the item details in the format(Item Name$Item Type$Item Cost$Item Availability)");
        sc.nextLine();
        for(int i=0;i<nItems;i++) {
            sb.setLength(0);
            sb.append(sc.nextLine());
            String[] details = (sb.toString()).split("\\$");
            Item item = new Item(details[0], details[1], Integer.parseInt(details[2]), Integer.parseInt(details[3]));
            items[i] = item;
        }
        System.out.println("Items:");
        for(Item item : items) {
            item.displayResult();
        }
       
        sc.close();
	}
}


// Item.java

public class Item {
	private String name,type;
    private Integer cost,availableQuantity;
    
    
    Item() {}
    
    Item(String name, String type, Integer cost, Integer availableQuantity) {
        this.name = name;
        this.type = type;
        this.cost = cost;
        this.availableQuantity = availableQuantity;
    }
    
    String getAvailability() {
        return availableQuantity > 0 ? "Available" : "Not Available";
    }
    
    void displayResult() {
        System.out.println(String.format("%s,%s,%d,%s",name,type,cost,getAvailability()));
    }
}
