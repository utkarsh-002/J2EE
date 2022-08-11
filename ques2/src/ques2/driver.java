package ques2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class driver {
	
	static void printBookDetail(book b) {
		System.out.println("Title:"+b.title+"\tAuthor:"+b.author+"\tPublisher:"+b.publisher+"\tPrice:"+b.price+"\n<-------------->");
	}
	
	static void printBookDatabase(ArrayList<book> bookDB) {
		for(book b:bookDB)
			printBookDetail(b);
	}
	
	static void sortBooks(ArrayList<book> bookDB) {
		Collections.sort(bookDB,new Comparator<book>() {

			@Override
			public int compare(book o1, book o2) {
				return (int)(o1.price)-(int)(o2.price);
			}
			
		});
	}
	public static void main(String[] args) {
		ArrayList<book> bookData = new ArrayList<book>();
		Scanner sc = new Scanner(System.in);
		bookData.add(new book("b1","auth1","pub1",1000));
		bookData.add(new book("b2","auth2","pub2",800));
		bookData.add(new book("b3","auth3","pub3",600));
		bookData.add(new book("b4","auth4","pub4",700));
		
		while(true) {
			System.out.println("Want to enter book details?(yes/no)");
			String ch = sc.nextLine();
			if(ch.toUpperCase().equals("YES")) {
				System.out.println("Enter book details:");
				System.out.println("Enter title:");
				String t = sc.nextLine();
				System.out.println("Enter author:");
				String a = sc.nextLine();
				System.out.println("Enter Publisher:");
				String p = sc.nextLine();
				System.out.println("Enter price:");
				double pr = sc.nextDouble();
				book b1 = new book(t,a,p,pr);
				bookData.add(b1);
				sc.nextLine();
			}
			else
				break;
		}
		
		ArrayList<book> bookDup = new ArrayList<book>(bookData);
		sortBooks(bookDup);
		System.out.println("Sorted book list:");
		printBookDatabase(bookDup);
		
		
		HashMap<Integer,book> hmap = new HashMap<Integer,book>();
		int i=1;
		for(book b:bookData) {
			hmap.put(i, b);
			i++;
		}
		System.out.println("HashMap of book database:");
		hmap.forEach((Integer sid,book b)->{
			System.out.println("Serial ID: "+sid);
			printBookDetail(b);
		});
		
		
		System.out.println("Enter the author name:");
		String authName = sc.nextLine();
		int flag1=0;
		for(book b:bookData) {
			if(authName.equals(b.author)) {
				printBookDetail(b);
				flag1=1;
			}
		}
		if(flag1==0)
			System.out.println("There are no books by that author");
		
		
		System.out.println("Enter the price above which you want books to be stored:");
		double price = sc.nextDouble();
		sc.nextLine();
		ArrayList<book> greaterPrice = new ArrayList<book>();
		int flag2=0;
		for(book b: bookData) 
			if(b.price>=price) {
				greaterPrice.add(b);
				flag2=1;
			}
		if(flag2==0)
			System.out.println("There are no book above the mentioned price range");
		else {
			System.out.println("Books belonging to new price range:");
			printBookDatabase(greaterPrice);
		}
		
		
		System.out.println("Enter the partial or complete title:");
		String partialTitle = sc.nextLine();
		int flag3=0;
		for(book b:bookData)
			if(b.title.contains(partialTitle)) {
				printBookDetail(b);
				flag3=1;
				break;
			}
		if(flag3==0)
			System.out.println("There are no books with that title");
	
		
		System.out.println("Enter title whose publisher needs to be updated:");
		String title=sc.nextLine();
		System.out.println("Enter the updated publisher name:");
		String pub = sc.nextLine();
		int flag4=0;
		for(book b:bookData)
			if(b.title.equals(title)) {
				b.publisher=pub;
				flag4=1;
				System.out.println("Updated book Details are:");
				printBookDetail(b);
				break;
			}
		if(flag4==0)
			System.out.println("There are no books with that title");
	}

}
