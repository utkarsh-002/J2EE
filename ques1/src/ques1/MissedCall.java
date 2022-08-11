package ques1;

import java.time.LocalDateTime;
import java.util.HashMap;

public class MissedCall {
	long phno;
	String name;
	LocalDateTime idt;
	
	MissedCall(long phno){
		this.name= "private Caller";
		this.phno = phno;
		this.idt = LocalDateTime.now();
		HashMap<Long,contact> contList = ContactList.fetchList();
		
		if(contList.containsKey(phno))
			this.name = contList.get(phno).name;
	}
	
	public String toString() {
		return ("Name: "+name+" Phno: "+phno+" Time: "+idt+"\n");
	}
}
