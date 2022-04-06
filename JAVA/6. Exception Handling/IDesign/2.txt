import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
        int n;
        int[] seat = new int[100];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of seats to be booked:");
        n = sc.nextInt();
        try {
            for(int i=0;i<n;i++) {
                System.out.println("Enter the seat number "+(i+1));
                int sn = sc.nextInt();
                seat[sn-1] = 1;
            }
            System.out.println("The seats booked are:");
            int c = 0;
            for(int s : seat) {
                c += 1;
                if(s!=0)    {System.out.println(c);}
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
       
        sc.close();
	}
}
