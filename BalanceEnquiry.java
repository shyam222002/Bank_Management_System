package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
	
	String pinNumber;
	JButton back;
	
	BalanceEnquiry(String pinNumber){
		this.pinNumber = pinNumber;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image); 
		
		int balance = 0;
		try {
			Conn c = new Conn();
			String query = "select * from bank where pin_number = '"+pinNumber+"'";
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next()) {
				if(rs.getString("type").equals("deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));
				}
				else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		JLabel text = new JLabel("Your Current Account Balance is Rs "+balance);
		text.setForeground(Color.WHITE);
		text.setBounds(170, 300, 400, 30);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);
		
		back = new JButton("BACK");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
		setLayout(null);
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==back) {
			setVisible(false);
			new Transactions(pinNumber).setVisible(true);
		}
	}
	public static void main(String[] args) {
		new BalanceEnquiry("");
	}

}
