package ques1;

public class contact {
	long phno;
	String name;
	contact(long n,String name){
		this.name= name;
		phno=n;
	}
	public String toString() {
		return ("Name: "+name+" Phno: "+phno);
	}
}
