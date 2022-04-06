import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int tc;
        float tf;
        System.out.println("Temparature in Celsius:");
        tc = sc.nextInt();
        tf = (float)(9*tc)/5 + 32;
        System.out.println("Temparature in Fahrenheit is "+String.format("%.01f", tf)+"F");
        sc.close();
	}

}
