package shop;

import java.awt.event.*;

import javax.swing.*;

public class Frame implements ActionListener{
	JFrame f;
	JButton btn1,btn2;
	JTextArea textArea;
	item it;
	boolean authen = false;
	float tBill=0;
	boolean authenticateUser() {
		String name=JOptionPane.showInputDialog("Username:").trim();
		String pass = JOptionPane.showInputDialog("Password:");
		if(name.equals("utkarsh")&&pass.equals("12345"))
			return true;
		else 
			return false;
	}
	void accessCust() {
		cust c = new cust();
		String id = JOptionPane.showInputDialog("Enter customer id:");
		c=c.validateCust(id);
	}
	void initalFrame() {
		f = new JFrame("Items");
		f.setLayout(null);
		f.setSize(900,600);
		
		btn1 = new JButton("Add Item");
		btn1.setBounds(100,500,100,60);
		btn1.addActionListener(this);
		
		btn2 = new JButton("Print Bill");
		btn2.setBounds(350,500,100,60);
		btn2.addActionListener(this);
		
		textArea = new JTextArea();
		textArea.setBounds(50,50,500,400);
		textArea.setText("ID\tName\tQuantity\tPrice\n");
		textArea.setEditable(false);
		
		f.add(btn1);
		f.add(btn2);
		f.add(textArea);
		f.setVisible(true);
	}
	
	Frame(){
		while(authen==false)
			authen=authenticateUser();
		accessCust();
		initalFrame();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== btn1) {
			it = new item();
			String id = JOptionPane.showInputDialog("Enter item id:");
			it = it.retItem(id);
			int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter qauntity:"));
			String dis=textArea.getText()+it.id+"\t"+it.name+"\t"+qty+"\t"+it.price+"\n";
			textArea.setText(dis);
			tBill+=qty*it.price;
		}
		else if(e.getSource()==btn2) {
			JOptionPane.showMessageDialog(f,"Total bill amout:"+tBill);
			f.dispose();
			accessCust();
			initalFrame();
		}
	}

}
