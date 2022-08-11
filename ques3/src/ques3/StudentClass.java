package ques3;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.*;

public class StudentClass implements ActionListener {
	JLabel jl1 = new JLabel("Enter name:");
	JLabel jl2 = new JLabel("Enter usn:");
	JLabel jl3 = new JLabel("Enter age:");
	JLabel jl4 = new JLabel("Enter address:");
	JLabel jl5 = new JLabel("Select category:");
	JLabel jl6 = new JLabel("Enter spga of I sem:");
	JLabel jl7 = new JLabel("Enter spga of II sem:");
	JLabel jl8 = new JLabel("Enter spga of III sem:");
	JLabel jl9 = new JLabel("Enter spga of IV sem:");
	JLabel jl10 = new JLabel("Enter spga of V sem:");
	JLabel jl11 = new JLabel("Enter spga of VI sem:");
	JLabel jl12 = new JLabel("Enter spga of VII sem:");
	JLabel jl13 = new JLabel("Enter spga of VIII sem:");
	JLabel Lcpga = new JLabel("CGPA obtained:");
	JTextField name = new JTextField(20);
	JTextField usn = new JTextField(20);
	JTextField age = new JTextField(3);
	JTextArea address = new JTextArea(3,4);
	JComboBox cat = new JComboBox();
	JTextField cgpa = new JTextField(10);
	JTextField sgpa1 = new JTextField(5);
	JTextField sgpa2 = new JTextField(5);
	JTextField sgpa3 = new JTextField(5);
	JTextField sgpa4 = new JTextField(5);
	JTextField sgpa5 = new JTextField(5);
	JTextField sgpa6 = new JTextField(5);
	JTextField sgpa7 = new JTextField(5);
	JTextField sgpa8 = new JTextField(5);
	JButton submit = new JButton("Compute");
	JButton Done = new JButton("Done");
	JButton Display = new JButton("Display");
	JTextArea stud_list = new JTextArea(20,20);
	JFrame f1=new JFrame("Student Information");
	JFrame f2 = new JFrame("Student Collection Display");
	LinkedList<student> stud= new LinkedList<student>();
	
	StudentClass(){
		jl1.setBounds(10,10,10,5);
		cat.addItem("GM");
		cat.addItem("SC/ST");
		cat.addItem("Cat1");
		cat.addItem("Cat2");
		f1.add(jl1);f1.add(name);
		f1.add(jl2);f1.add(usn);
		f1.add(jl3);f1.add(age);
		f1.add(jl4);f1.add(address);
		f1.add(jl5);f1.add(cat);
		f1.add(jl6);f1.add(sgpa1);
		f1.add(jl7);f1.add(sgpa2);
		f1.add(jl8);f1.add(sgpa3);f1.add(jl9);f1.add(sgpa4);
		f1.add(jl10);f1.add(sgpa5);f1.add(jl11);f1.add(sgpa6);
		f1.add(jl12);f1.add(sgpa7);f1.add(jl13);f1.add(sgpa8);
		f1.add(Lcpga);f1.add(cgpa);
		f1.add(submit);
		f1.add(Done);
		f1.add(Display);
		f2.add(stud_list);
		f1.setSize(900,800);
		f1.setLayout(new GridLayout(8,8));
		f1.setVisible(true);
		submit.addActionListener(this);
		Done.addActionListener(this);
		Display.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit) {
			try {
				int i=Integer.parseInt(age.getText());
				if(i<18 || i>35) {
					String age1= JOptionPane.showInputDialog(null,"Enter valid age");
					age.setText(age1);
				}
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(f1, "Invalid entry");
				age.requestFocus();
			}
			checkSGPA(1,sgpa1);
			checkSGPA(2,sgpa2);
			checkSGPA(3,sgpa3);
			checkSGPA(4,sgpa4);
			checkSGPA(5,sgpa5);
			checkSGPA(6,sgpa6);
			checkSGPA(7,sgpa7);
			checkSGPA(8,sgpa8);
			float cal_cgpa = calcul_cgpa();
			cgpa.setText(Float.toString(cal_cgpa));
		}
		
		else if(e.getSource()==Done) {
			student s1 =new student(name.getText(),usn.getText(),address.getText(),String.valueOf(cat.getSelectedItem()),
					Integer.parseInt(age.getText()),Float.parseFloat(cgpa.getText()));
			stud.add(s1);
		}
		else {
			f1.setVisible(false);
			f2.setVisible(true);
			f2.setSize(500,500);
			stud_list.setText("Name\tUSN\tAddress\t\tCategory\tAge\tCGPA\n ");
			stud_list.setEditable(false);
			for(student s:stud)
				stud_list.append(s.toString()+"\n");
		}
		
	}
	
	float calcul_cgpa(){
		float v1 = Float.parseFloat(sgpa1.getText());
		float v2 = Float.parseFloat(sgpa2.getText());
		float v3 = Float.parseFloat(sgpa3.getText());
		float v4 = Float.parseFloat(sgpa4.getText());
		float v5 = Float.parseFloat(sgpa5.getText());
		float v6 = Float.parseFloat(sgpa6.getText());
		float v7 = Float.parseFloat(sgpa7.getText());
		float v8 = Float.parseFloat(sgpa8.getText());
		return (v1+v2+v3+v4+v5+v6+v7+v8)/8;
	}
	
	void checkSGPA(int sem,JTextField sgpa) {
		try {
			if(Float.parseFloat(sgpa.getText())>10) {
				String v1 = JOptionPane.showInputDialog(null,"Enter SGPA less than or equal to 10");
				sgpa.setText(v1);
			}
		}catch(NumberFormatException e) {
			String v2 = JOptionPane.showInputDialog(null,"please enter SGPA for semseter"+sem);
			sgpa.setText(v2);
		}
	}
	public static void main(String[] args) {
		StudentClass sc = new StudentClass();

	}

}
