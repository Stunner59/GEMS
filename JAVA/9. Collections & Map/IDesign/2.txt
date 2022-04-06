import java.util.*;
public class Main {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		Set<String> emails = new LinkedHashSet<String>();
        String res;
        do {
            System.out.println("Enter Email address");
            emails.add(sc.nextLine());
            System.out.println("Do you want to Continue?(yes/no)");
            res = sc.nextLine(); 
        } while(res.equals("yes"));
        System.out.println("Enter the email addresses to be searched separated by comma");
        String[] search = (sc.nextLine()).split(",");
        List<String> searchList = new ArrayList<String>();
        Collections.addAll(searchList,search);
        if(emails.containsAll(searchList)) {
            System.out.println("Email addresses are present");
        } else {
            System.out.println("Email addresses are not present");
        } 
        sc.close();
	}

}
