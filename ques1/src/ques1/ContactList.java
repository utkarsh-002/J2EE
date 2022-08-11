package ques1;

import java.util.HashMap;
import java.util.Scanner;

public class ContactList {
	static HashMap<Long,contact> contList = new HashMap<Long,contact>();
	ContactList(){
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("To add new contact press 1,otherwise 0:");
			if(sc.nextLine().equals("1")) {
				System.out.print("Enter name:");
				String name = sc.nextLine();
				System.out.print("Enter number");
				long n = sc.nextLong();
				contact c = new contact(n,name);
				contList.put(n, c);
				sc.nextLine();
			}
			else
				break;
		}
	}
	static HashMap<Long,contact> fetchList(){
		return contList;
	}
	
	void displayContList() {
		contList.forEach((Long mn,contact c)->{
			System.out.println(c.toString());
		});
	}
}
