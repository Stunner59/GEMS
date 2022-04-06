import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the code");
        StringBuilder sb = new StringBuilder(sc.next());
        String cityCode = sb.substring(0,2);
        if(cityCode.equals("DH")) {
            sb.replace(0,2,"DEL");
        } else if(cityCode.equals("MB")) {
            sb.replace(0,2,"MUB");
        } else if(cityCode.equals("KL")) {
            sb.replace(0,2,"KOL");
        }
        
        int rem = 5-(sb.length()-3);
        for(int i=0;i<rem;i++) {
            sb.insert(3+i,"0");
        }
        
        System.out.print("Formatted code\n"+sb.toString());
        
        sc.close();
     }
}