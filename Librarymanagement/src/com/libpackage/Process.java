package com.libpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Process extends Exception{
	final static Logger logger=Logger.getLogger(Process.class);
	static ArrayList<Book> booklist = new ArrayList<>();
	public static int count;
	Scanner input = new Scanner(System.in);

	void addBook() {
		try {
		Scanner sc = new Scanner(System.in);
		Book b = new Book();
		//System.out.println("Enter Serial No of Book:");
		//b.setsN0(sc.nextInt());

		logger.info("Enter Book Name:");
		b.setBookName(sc.nextLine());

		logger.info("Enter Author Name:");
		b.setAuthorName(sc.nextLine());

		logger.info("Published year:");
		b.setPublishedYear(sc.nextInt());
		Connection con=DriverManager.getConnection(  
				"jdbc:mysql://127.0.0.1:3306/database1", "root", "10decoders");
		Statement stmt=con.createStatement();
		String stt="insert into BOOK (bookName,authorName,publishedYear) values('"+b.getBookName()+"','"+b.getAuthorName()+"',"+b.getPublishedYear()+")";
		PreparedStatement stm=con.prepareStatement(stt);
		stm.executeUpdate();
		booklist.add(b);

		logger.info("Book Added Succesfully");
	}
		catch(Exception e) {
			logger.error(e);
		}
	}

	public void listAllBooks() {
		try {
			logger.info("S.No\t\tName\t\t\tAuthor\t\t\tPublished Year");
		Connection con=DriverManager.getConnection(  
				"jdbc:mysql://127.0.0.1:3306/database1", "root", "10decoders");  
				Statement stmt=con.createStatement(); 
		ResultSet rs=stmt.executeQuery("select * from BOOK");  
		while(rs.next())  
			logger.info(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t\t"+rs.getString(3)+"\t\t\t"+rs.getInt(4));  
		con.close();
		}
		catch(Exception e) {
			logger.error(e);
		}
	}
	void display() {
		logger.info("1.Add Book Details");
		logger.info("2.Remove Book");
		logger.info("3.Search Book Detail");
		logger.info("4.List All Books");
		logger.info("To Exit Press 0");
	}
	void removeBook(String c) {
		try {
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://127.0.0.1:3306/database1", "root", "10decoders");  
					Statement stmt=con.createStatement(); 
					PreparedStatement stm=con.prepareStatement("delete from book where bookName='"+c+"'");
					stm.executeUpdate();
					}
		catch(Exception e) {
			logger.error(e);
		}
		/*try {
		ArrayList<Book> dummy=new ArrayList<Book>();
		dummy=booklist;
		for(Book b:dummy) {
			
			if(b.getBookName().equals(c)) {
				dummy.remove(b);
				System.out.println(b.getBookName()+" "+"Book Removed Successfully");
				
			}
		}
		
		System.out.println("No Book Available");
		}
			catch(Exception e) {
			}
		}*/
	}
	void searchBook(String c){
		try {
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/database1","root","10decoders");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from BOOK where bookname='"+c+"'"); 
			//rs=stmt.executeQuery("select * from BOOK where authorname='"+c+"'");
			while(rs.next())  {
				logger.info(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t\t"+rs.getString(3)+"\t\t\t"+rs.getInt(4));  
			con.close();
			}
			if(rs.next()==true) {
				logger.info("Book is available");
			}
			else {
				logger.info("book is unavailable");
			}
		}
		catch(Exception e) {
			logger.error(e);
		}
	}
		
		/*for(Book b:booklist) {
			if(b.getBookName().equals(c)) {
				System.out.println(b.getBookName()+" "+"Book is Available");
			}
			else {
				if(b.getAuthorName().equals(c)) {
					System.out.println(b.getBookName()+" "+"Book is Available");
			}
		}
	}
		System.out.println("Book is UnAvailable");
	}*/
}

