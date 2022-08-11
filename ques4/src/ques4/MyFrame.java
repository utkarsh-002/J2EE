package ques4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class MyFrame implements ActionListener {
	JFrame f;
	JButton btn1,btn2;
	JTextArea textArea;
	itemDetails item;
	boolean authenticate = false;
	float totalBill = 0;
	boolean authenticateUser() {
		String uname  = JOptionPane.showInputDialog(null,"Username:").trim();
		String password = JOptionPane.showInputDialog(null,"Password:");
		if(uname.equals("utkarsh") && password.equals("1234"))
			return true;
		else 
			return false;
	}
	void accessCustomer() {
		Customer cust = new Customer();
		String cid = JOptionPane.showInputDialog(null,"Enter customer id:");
		cust=cust.validateCust(cid);
	}
	void initaliseFrame() {
		f = new JFrame("Items");
		f.setLayout(null);
		f.setSize(900,600);
		btn1= new JButton("Add Item");
		btn1.setBounds(100,500,100,60);
		btn1.addActionListener(this);
		
		btn2 = new JButton("Bill");
		btn2.setBounds(300,500,100,60);
		btn2.addActionListener(this);
		
		textArea =new JTextArea();
		textArea.setBounds(50,50,500,400);
		textArea.setText("ID\tName\tQuantity\tPrice\t\n");
		textArea.setEditable(false);
		f.add(btn1);
		f.add(btn2);
		f.add(textArea);
		f.setVisible(true);
	}
	MyFrame(){
		while(authenticate==false)
			authenticate = authenticateUser();
		accessCustomer();
		initaliseFrame();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn1) {
			String itemID = JOptionPane.showInputDialog(f,"Enter item id:");
			item = new itemDetails();
			item = item.retrive(itemID);
			int qty = Integer.parseInt(JOptionPane.showInputDialog(f,"Enter Quantity:"));
			String diplayText = textArea.getText()+item.id+"\t"+item.name+"\t"+qty+"\t"+qty*item.price+"\n";
			textArea.setText(diplayText);
			totalBill +=qty*item.price;
		}
		else if(e.getSource()==btn2) {
			JOptionPane.showMessageDialog(f,"Total Bill Amount: "+totalBill);
			f.dispose();
			accessCustomer();
			initaliseFrame();
		}

	}

}
