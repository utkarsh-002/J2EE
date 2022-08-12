package shop;

import java.util.*;

import javax.swing.JOptionPane;

public class cust {
	String name,id;
	long num;
	static ArrayList<cust> cust_list = new ArrayList<cust>();
	cust validateCust(String id) {
		for(cust c:cust_list)
			if(c.id.equals(id))
				return c;
		cust c = new cust();
		c.id=id;
		c.name = JOptionPane.showInputDialog("Enter customer name:");
		c.num = Long.parseLong(JOptionPane.showInputDialog("Enter customer number:"));
		return c;
	}
}
