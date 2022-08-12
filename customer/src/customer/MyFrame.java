package customer;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.HashMap;

import javax.swing.*;

@SuppressWarnings("serial")
public class MyFrame extends JFrame implements ActionListener{
	
	static Connection con;
	JFrame frame1,frame2,frame3,frame4;
	JButton btn1,btn2,btn3;
	JButton AddRep,DisplayRep,AddCustomer;
	JTextArea textArea;
	JLabel l1,l2,l3,l4,l5;
	JTextField box1,box2,box3,box4,box5;
	HashMap<String,Integer> selectedRep = new HashMap<String,Integer>();
	
	void initalFrame() {
		frame1=new JFrame("Primary Frame");
		frame1.setSize(700,450);
		frame1.setLayout(null);
		frame1.setVisible(true);
		
		btn1 = new JButton("Add Representative");
		btn1.setBounds(50,150,150,80);
		btn1.addActionListener(this);
		
		btn2 = new JButton("Add Customer");
		btn2.setBounds(250,150,150,80);
		btn2.addActionListener(this);
		
		btn3 = new JButton("Display Representative");
		btn3.setBounds(450,150,150,80);
		btn3.addActionListener(this);
		
		frame1.add(btn1);
		frame1.add(btn2);
		frame1.add(btn3);
		
	}
	
	MyFrame(Connection con){
		MyFrame.con = con;
		initalFrame();
	}
	
	public void displayFrame(String repDetails) {
		frame4 = new JFrame("Display Frame");
		frame4.setSize(700,450);
		frame4.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(100,100,500,300);
		textArea.setText(repDetails);
		
		frame4.add(textArea);
		frame4.setVisible(true);
	}
	
	void CustomerFrame() {
		frame3 = new JFrame("Customer Frame");
		frame3.setSize(700,600);
		frame3.setLayout(null);
		
//		l1 = new JLabel("Rep No:");
//		l1.setBounds(50,50,100,40);
//		box1= new JTextField();
//		box1.setBounds(150,50,100,40);
//		
//		l2 = new JLabel("Rep Name:");
//		l2.setBounds(50,150,100,40);
//		box2= new JTextField();
//		box2.setBounds(150,150,100,40);
//		
//		l3 = new JLabel("State:");
//		l3.setBounds(50,250,100,40);
//		box3= new JTextField();
//		box3.setBounds(150,250,100,40);
//		
//		l1 = new JLabel("Commission:");
//		l1.setBounds(50,350,100,40);
//		box1= new JTextField();
//		box1.setBounds(150,350,100,40);
//		
//		AddCustomer = new JButton("Add!");
//		AddCustomer.setBounds(50, 450, 100, 40);
//		AddCustomer.addActionListener(this);
//		
//		frame3.add(l1);
//		frame3.add(l2);
//		frame3.add(l3);
//		frame3.add(l4);
//		
//		frame3.add(box1);
//		frame3.add(box2);
//		frame3.add(box3);
//		frame3.add(box4);
//		
//		frame3.add(AddCustomer);
//		frame3.setVisible(true);
	}
	
	void  RepresentativeFrame() {
		frame2 = new JFrame("Representative Frame");
		frame2.setSize(700,600);
		frame2.setLayout(new GridLayout(8,8));
		
		l1 = new JLabel("Rep No:");
		l1.setBounds(50,50,100,40);
		box1= new JTextField();
		
		l2 = new JLabel("Rep Name:");
		box2= new JTextField();
		
		l3 = new JLabel("State:");
		box3= new JTextField();
		
		l4 = new JLabel("Commission:");
//		l4.setBounds(50,350,100,40);
		box4= new JTextField();
//		box4.setBounds(150,350,100,40);
		
		l5 = new JLabel("rate:");
//		l5.setBounds(50,450,100,40);
		box5= new JTextField();
//		box5.setBounds(150,450,100,40);
		
		AddRep = new JButton("Add!");
//		AddRep.setBounds(50, 550, 100, 40);
		AddRep.addActionListener(this);
		
		frame2.add(l1);frame2.add(box1);
		frame2.add(l2);frame2.add(box2);
		frame2.add(l3);frame2.add(box3);
		frame2.add(l4);frame2.add(box4);
		frame2.add(l5);frame2.add(box5);
		
		frame2.add(AddRep);
		frame2.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1)
			RepresentativeFrame();
		if(e.getSource()==btn2)
			CustomerFrame();
		if(e.getSource()==btn3) {
			try {
				Statement st = (Statement) con.createStatement();
				String q1 = "select * from cust";
				String q2 = "select * from rep";
				ResultSet rs = ((java.sql.Statement) st).executeQuery(q1);
				
				while(rs.next()) {
					int creditLimit = rs.getInt("credlimit");
					String repNo = rs.getString("repno");
					int hmi=1;
					if(creditLimit>=15000 && !selectedRep.containsKey(repNo)) {
						selectedRep.put(repNo, hmi);
						hmi++;
					}
				}
				String repDetails="";
				ResultSet rs2 = st.executeQuery(q2);
				while(rs2.next()) {
					String repNo = rs2.getString("repno");
					if(selectedRep.containsKey(repNo)) {
						System.out.println("Rep No:"+rs2.getString("repno"));
						System.out.println("Rep Name:"+rs2.getString("repname"));
						System.out.println("state:"+rs2.getString("state"));
						System.out.println("Commission:"+rs2.getString("commission"));
						
						repDetails+=("Rep No:"+rs2.getString("repno")+"\n"+
								"Rep Name:"+rs2.getString("repname")+"\n"+
								"state:"+rs2.getString("state")+"\n"+
								"Commission:"+rs2.getString("commission")+"\n");
					}
					
				}
				displayFrame(repDetails);
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
		}
			if(e.getSource()==AddRep) {
				try {
					String s1= box1.getText();
					String s2= box2.getText();
					String s3= box3.getText();
					String s4= box4.getText();
					String s5= box5.getText();
					Statement stmt= con.createStatement();
					String q = "insert into rep values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')";
					stmt.executeUpdate(q);
					frame2.dispose();
					System.out.println("Frame 2 disposed");
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(box1,"There is some error");
				}
				
			
		}
		
	}

}
