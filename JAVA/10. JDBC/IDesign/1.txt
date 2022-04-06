// Main.java

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException,SQLException {
       BookDAO bookDAO = new BookDAO();
       List<Book> bookList = bookDAO.listBooks();
       System.out.println("List of Books");
       System.out.format("%-5s %-20s %-20s %-10s %s\n","Id","Title","Category","Author","Price");
       for(Book book : bookList) {
           System.out.print(book.toString());
       }
    }
}

// Book.java


public class Book {
	Integer id;
	String title;
	String category;
	String author;
	Double price;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(Integer id, String title, String category, String author, Double price) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.author = author;
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
    @Override
    public String toString() {
        return String.format("%-5d %-20s %-20s %-10s %.01f\n",id,title,category,author,price);
    }
}


// BookDAO.java

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookDAO {
	public ArrayList<Book> listBooks() throws ClassNotFoundException, SQLException{
    	ArrayList<Book> bookList = new ArrayList<Book>();
    	Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from book");  
        while(rs.next()) {
            Book book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5));
            bookList.add(book);
        }
        con.close();
		return bookList;
    }
}

// DBConnection.java

import java.sql.*;
import java.util.ResourceBundle;
public class DBConnection {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {        
        ResourceBundle rb = ResourceBundle.getBundle("oracle");
        String url = rb.getString("db.url");
        String username = rb.getString("db.username");
        String password = rb.getString("db.password");
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection con = DriverManager.getConnection(url,username,password);
        return con;
    }
}

