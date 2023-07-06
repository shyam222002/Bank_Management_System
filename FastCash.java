package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
	
	JButton deposit, fastCash, pinChange, cashWithdrawl, miniStatement, balance, back;
	String pinNumber;
	
	FastCash(String pinNumber){
		this.pinNumber = pinNumber;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image); 
		
		JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
		text.setBounds(210, 300, 700, 35);
		text.setFont(new Font("System",Font.BOLD, 16));
		image.add(text);
		
		deposit = new JButton("Rs 100");
		deposit.setBounds(170, 415, 150, 30);
		deposit.setFont(new Font("System",Font.BOLD,14));
		deposit.addActionListener(this);
		image.add(deposit);
		
		fastCash = new JButton("Rs 1000");
		fastCash.setBounds(170, 450, 150, 30);
		fastCash.setFont(new Font("System",Font.BOLD,14));
		fastCash.addActionListener(this);
		image.add(fastCash);
		
		pinChange = new JButton("Rs 5000");
		pinChange.setBounds(170, 485, 150, 30);
		pinChange.setFont(new Font("System",Font.BOLD,14));
		pinChange.addActionListener(this);
		image.add(pinChange);
		
		cashWithdrawl = new JButton("Rs 500");
		cashWithdrawl.setBounds(355, 415, 170, 30);
		cashWithdrawl.setFont(new Font("System",Font.BOLD,14));
		cashWithdrawl.addActionListener(this);
		image.add(cashWithdrawl);
		
		miniStatement = new JButton("Rs 2000");
		miniStatement.setBounds(355, 450, 170, 30);
		miniStatement.setFont(new Font("System",Font.BOLD,14));
		miniStatement.addActionListener(this);
		image.add(miniStatement);
		
		balance = new JButton("Rs 10000");
		balance.setBounds(355, 485, 170, 30);
		balance.setFont(new Font("System",Font.BOLD,14));
		balance.addActionListener(this);
		image.add(balance);
		
		back = new JButton("BACK");
		back.setBounds(355, 520, 170, 30);
		back.setFont(new Font("System",Font.BOLD,14));
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
		else {
			String amount = ((JButton)ae.getSource()).getText().substring(3);
			try {
				Conn c = new Conn();
				String query = "select * from bank where pin_number = '"+pinNumber+"'";
				ResultSet rs = c.s.executeQuery(query);
				int balance = 0;
				while(rs.next()) {
					if(rs.getString("type").equals("deposit")){
						balance += Integer.parseInt(rs.getString("amount"));
					}
					else {
						balance -= Integer.parseInt(rs.getString("amount"));
					}
				}
				if(ae.getSource()!=back && balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}
				Date date = new Date();
				String query2 = "insert into bank values ('"+pinNumber+"', '"+date+"', 'withdrawl', '"+amount+"')";
				c.s.executeUpdate(query2);
				JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited Successfully.");
				 
				setVisible(false);
				new Transactions(pinNumber).setVisible(true);
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
	}
	
	public static void main(String[] args) {
		new FastCash("");
	}

}
