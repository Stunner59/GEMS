public class Main {

	public static void main(String[] args) {
		
        int memory_space = 0;
        float speed = 0.0f;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Name :");
        char[] name = sc.next().toCharArray();
        System.out.println("Enter the Creator Name :");
        char[] creator = sc.next().toCharArray();
        System.out.println("Enter the Purpose :");
        char[] purpose = sc.next().toCharArray();
        System.out.println("Memory Space :");
        memory_space = sc.nextInt();
        System.out.println("Speed :");
        speed = sc.nextFloat();
        
        System.out.println("My Details :");
        System.out.print("I am the Robot named ");
        for (int i = 0; i < name.length; i++) 
            System.out.print(name[i]);
        System.out.println(".");
        System.out.print("I was created by ");
        for (int i = 0; i < creator.length; i++) 
            System.out.print(creator[i]);
        System.out.println(".");
        System.out.print("I am created for the purpose of ");
        for (int i = 0; i < purpose.length; i++) 
            System.out.print(purpose[i]);
        System.out.println(".");
        System.out.println("My memory space is around "+memory_space+"Gb and my speed is "+speed+"Tb."); 
	}

}
