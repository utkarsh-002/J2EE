package ques4;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class itemDetails {
	String name,id;
	float price;
	static private ArrayList<itemDetails> items = new ArrayList<itemDetails>();
	itemDetails retrive(String id) {
		for(itemDetails i:items) {
			if(i.id.equals(id))
				return i;
		}
		itemDetails i = new itemDetails();
		i.id=id;
		i.name = JOptionPane.showInputDialog("Enter product name:");
		i.price = Float.parseFloat(JOptionPane.showInputDialog("Enter product price:"));
		items.add(i);
		return i;
	}
}
