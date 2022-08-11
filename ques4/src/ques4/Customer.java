package ques4;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Customer {
	String name,id,number;
	static public ArrayList<Customer> cus = new ArrayList<Customer>();
	Customer validateCust(String cid) {
		for(Customer c:cus)
			if(c.id.equals(cid))
				return c;
		Customer c = new Customer();
		c.id=cid;
		c.name=JOptionPane.showInputDialog("Enter Customer name:").trim();
		c.number = JOptionPane.showInputDialog("Enter number:").trim();
		cus.add(c);
		return c;
	}
}
