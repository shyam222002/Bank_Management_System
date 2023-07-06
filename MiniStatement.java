package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame{
	String pinNumber;
	
	MiniStatement(String pinNumber){
		this.pinNumber = pinNumber;
		setLayout(null);
		
		JLabel mini = new JLabel();
		mini.setBounds(20, 140, 400, 200);
		add(mini);
		
		JLabel bank = new JLabel("SHYAM BANK");
		bank.setBounds(150, 20, 100, 20);
		add(bank);
		
		JLabel card = new JLabel();
		card.setBounds(20, 80, 300, 20);
		add(card);
		
		JLabel balance = new JLabel();
		balance.setBounds(20, 400, 300, 20);
		add(balance);
		
		try {
			Conn c = new Conn();
			String query = "select * from login where pin_number = '"+pinNumber+"'";
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next()) {
				card.setText("Card Number : "+rs.getString("card_number").substring(0,4)+"XXXXXXXX"+rs.getString("card_number").substring(12));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		try {
			Conn c = new Conn();
			String query = "select * from bank where pin_number = '"+pinNumber+"'";
			ResultSet rs = c.s.executeQuery(query);
			int bal = 0;
			while(rs.next()) {
				mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")+"<br><br><html>");
				if(rs.getString("type").equals("deposit")) {
					bal += Integer.parseInt(rs.getString("amount"));
				}
				else {
					bal -= Integer.parseInt(rs.getString("amount"));
				}
			}
			balance.setText("Your Account Balance is Rs "+bal);
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		setTitle("Mini Statement");
		setSize(400,600);
		setLocation(20,20);
		setVisible(true);
		
		
		
	}

	public static void main(String[] args) {
		new MiniStatement("");
	}

}
