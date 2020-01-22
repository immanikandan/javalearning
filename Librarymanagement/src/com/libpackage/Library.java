package com.libpackage;

import java.util.Scanner;

import org.apache.log4j.Logger;



public class Library {
	final static Logger logger=Logger.getLogger(Library.class);
	Scanner input=new Scanner(System.in);
	Process pc=new Process();
	int choice;
	String cho;
	void libraryprocess(){
		try {
			do {
				pc.display();
				choice=input.nextInt();
				switch(choice) {
				case 1:
					pc.addBook();
					break;
				case 2:
					Scanner sc1=new Scanner(System.in);
					logger.info("Enter The Book name to Delete");
					cho=sc1.nextLine();
					pc.removeBook(cho);
					break;
				case 3:
					Scanner sc2=new Scanner(System.in);
					logger.info("Enter book name to search");
					cho=sc2.nextLine();
					pc.searchBook(cho);
					break;
				case 4:
					pc.listAllBooks();
					break;
				default:
					logger.error("Choice should be between 0 to 5");
			}
		}while(choice!=0);
			} 
			catch(Exception  e) {
			Library obj=new Library();
			logger.error("Please give Integer Type Input ");
			obj.libraryprocess();
	}
	}
	public static void main(String[] args){
		
		logger.info("LIBRARY MANAGEMENT");
		Library l=new Library();
		l.libraryprocess();
	

}
}
