package ques3;

public class student {
	String name,usn,address,category;
	int age;
	float cgpa;
	public student(String name,String usn,String address,String cat,int age,float cgpa) {
		this.name=name;
		this.address=address;
		this.age=age;
		this.category=cat;
		this.usn=usn;
		this.cgpa=cgpa;
	}
	public String toString() {
		String stud=name+"\t"+usn+"\t"+address+"\t"+
	category+"\t"+age+"\t"+cgpa;
		return stud;
	}
}
