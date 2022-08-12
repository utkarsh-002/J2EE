package shop;

import java.util.*;

import javax.swing.JOptionPane;

public class item {
	String name,id;
	float price;
	static ArrayList<item> it_list = new ArrayList<item>();
	item retItem(String id) {
		for(item i:it_list)
			if(i.id.equals(id))
				return i;
		item i =new item();
		i.id=id;
		i.name= JOptionPane.showInputDialog("Enter item name:");
		i.price= Float.parseFloat(JOptionPane.showInputDialog("Enter item price:"));
		it_list.add(i);
		return i;
	}
}
