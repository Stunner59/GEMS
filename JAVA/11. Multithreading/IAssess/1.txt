// Main.java

import java.util.*;

class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number of Counters :");
        int n = sc.nextInt();
        sc.nextLine();
    
        List<CharCount> charCountList = new ArrayList<>();
        for(int i=1;i<=n;i++) {
            System.out.println("Enter text for counter "+i+" :");
            charCountList.add(new CharCount(sc.nextLine()));
        }
        
        int i = 1;
        for(CharCount charCount : charCountList) {
            System.out.format("Counter %d Result :\n",i++);
            charCount.start();
            Thread.sleep(1000);
            System.out.println(charCount);
        }
            
        sc.close();
    }
}


// CharCount.java ( ! Create this file )

import java.util.*;

class CharCount extends Thread {
    private String word;
    private TreeMap<Character,Integer> countMap;
    
    CharCount() {}
    CharCount(String word) {
        this.word = word; 
        countMap = new TreeMap<Character,Integer>();
    }
    
    @Override
    public void run() {
        TreeMap<Character,Integer> temp = new TreeMap<Character, Integer>();
        
        for(char ch : word.toCharArray() ) {
            if(temp.containsKey(ch))
                temp.put(ch, temp.get(ch) + 1);
            else 
                temp.put(ch, 1);    
        }
        countMap = temp;
    }
    
     @Override
    public String toString() {
    StringBuilder m = new StringBuilder("");
         for (Map.Entry entry : countMap.entrySet()) {
            m.append(entry.getKey() + ":" + entry.getValue()+" ");
        }
    return m.toString();
    }
	
}
    
   