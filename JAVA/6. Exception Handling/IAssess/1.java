import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class Main {

	public static void main(String[] args) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH:mm:ss");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the stage event start date and end date");
        try {
        Date startDate = formatter.parse(sc.nextLine());
        Date endDate = formatter.parse(sc.nextLine());
        System.out.println("Start date:"+formatter.format(startDate));
        System.out.println("End date:"+formatter.format(endDate));
        } catch(ParseException e) {
            System.out.println("Input dates should be in the format 'dd-MM-yyyy-HH:mm:ss'");
        }
        
        sc.close();
	}

}