package thread;

import java.util.Scanner;

public class GetVowel extends Thread {
	public void run() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String:");
		String str = sc.next();
		int count=0;
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(ch=='a'|| ch=='e'|| ch=='i'|| ch=='o'|| ch=='u')
				count++;
		}
		System.out.println("Vowels present:"+count);
	}
}
