package thread;

import java.util.*;

public class GetNumber extends Thread {
	static String[] digit = {"zero","one","two","three","four","five","six","seven","eight","nine"};
	
	public void run() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number greater than 4 digits:");
		int num = sc.nextInt();
		if(num<9999)
			System.out.println("Invalid input");
		else {
			String numberInString="";
			while(num!=0) {
				int dig = num%10;
				num/=10;
				numberInString = digit[dig]+" "+numberInString;
			}
			System.out.println(numberInString);
		}
	}
	
}
