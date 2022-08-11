package ques1;

import java.util.ArrayList;
import java.util.Scanner;

public class MissedCallList {
	ArrayList<MissedCall> missedList = new ArrayList<MissedCall>();
	Scanner sc = new Scanner(System.in);
	MissedCallList(){
		while(true) {
			System.out.println("To add new missed call press-1 or otherwise 0:");
			if(sc.nextLine().equals("1")) {
				if(missedList.size()==10)
					missedList.remove(0);
				System.out.print("Enter number:");
				long n = sc.nextLong();
				sc.nextLine();
				MissedCall mc = new MissedCall(n);
				missedList.add(mc);
			}
			else
				break;
		}
	}
	
	void display() {
		int i=1,ch;
		System.out.println("Missed call logs:");
		for(MissedCall mc:missedList) {
			System.out.println("Sno."+(i++)+": "+mc.phno);
			while(true) {
				System.out.println("1.Delete 2.Display 3.Next 0.Exit");
				ch = sc.nextInt();
				if(ch==1) 
					missedList.remove(mc);
				else if(ch==2) {
					System.out.println("Missed call Detail:");
					System.out.println(mc.toString());
				}
				else if(ch==3)
					break;
				else if(ch==0)
					System.exit(0);
				
			}
		}
	}
}
