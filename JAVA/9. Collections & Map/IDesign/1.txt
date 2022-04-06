import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception{
		List<String> halls = new ArrayList<String>();
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of halls:");
        n = sc.nextInt();
        sc.nextLine();
        for(int i=1;i<=n;i++) {
            System.out.println("Enter the Hall Name "+i);
            String hallName = sc.nextLine();
            halls.add(hallName);
        }
        System.out.println("Enter the hall name to be searched:");
        String toSearch = sc.nextLine();
        if(halls.contains(toSearch))
            System.out.println(toSearch+" hall is found in the list at position "+halls.indexOf(toSearch));
        else
            System.out.println(toSearch+" hall is not found");
        sc.close();
	}
}
