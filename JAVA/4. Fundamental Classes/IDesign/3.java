import java.util.*;
import java.text.SimpleDateFormat;

public class Main {
	public static void main(String []args) {
	  Scanner sc = new Scanner(System.in);
        SimpleDateFormat format1 = new SimpleDateFormat("EEE, MMM d, yy"); 
        SimpleDateFormat format2 = new SimpleDateFormat("dd.MM.yyyy"); 
        SimpleDateFormat format3 = new SimpleDateFormat("dd/MM/yyyy"); 
        try {
            System.out.println("Enter the date to be formatted:(MM-dd-yyyy)");
            String inpDate = sc.next();
            Date date = new SimpleDateFormat("MM-dd-yyyy").parse(inpDate);
            System.out.println("Date Format with EEE,MMM d,yy:"+format1.format(date));
            System.out.println("Date Format with dd.MM.yyyy:"+format2.format(date));
            System.out.println("Date Format with dd dd/MM/yyyy:"+format3.format(date));
        } catch(Exception e) {
            e.printStackTrace();
        }
        sc.close();
	}
}
