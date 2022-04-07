// Main.java

import java.util.*;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of lines");
        int n = Integer.parseInt(sc.nextLine());
        List<Article> articles = new ArrayList<>();
        int c = 0;
        for(int i=1;i<=n;i++) {
            System.out.println("Enter line "+i);
            Article article = new Article(sc.nextLine());
            articles.add(article);
            article.start();
            article.join();
        }
        
        for(Article article : articles) c += article.getCount();
        
        System.out.println("There are "+c+" articles in the given input");
        sc.close();
	}
}


// Article.java

public class Article extends Thread {
	private String line;
    private Integer count;
    
    Article() {}
    Article(String line) {
        this.line = line;
    }
    
    public void setLine(String line) { this.line = line; }
    public void setCount(Integer count) { this.count = count; }
    public String getLine() { return this.line; }
    public Integer getCount() { return this.count; }

    @Override
    public void run() {
        int c = 0;
        String[] words = this.line.split("[\\s,]+");
        for(String word : words) {
            if( (word.equals("a")) || (word.equals("A")) || (word.equals("an")) || (word.equals("An")) || (word.equals("the")) || (word.equals("The")) )    c++;
        }
        this.count = c;
    }
}
