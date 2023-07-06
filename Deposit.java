package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
	
	JButton deposit, back;
	JTextField amount;
	String pinNumber;
	
	Deposit(String pinNumber){
		this.pinNumber = pinNumber;
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image); 
		
		JLabel text = new JLabel("Enter the amount you want to deposit");
		text.setBounds(170, 300, 400, 20);
		text.setFont(new Font("System",Font.BOLD, 14));
		text.setForeground(Color.WHITE);
		image.add(text);
		
		amount = new JTextField();
		amount.setBounds(170, 350, 320, 25);
		amount.setFont(new Font("System",Font.BOLD, 14));
		image.add(amount);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(355, 485, 150, 30);
		deposit.setFont(new Font("System",Font.BOLD,14));
		deposit.addActionListener(this);
		image.add(deposit);
		
		back = new JButton("Back");
		back.setBounds(355, 520, 150, 30);
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
		if(ae.getSource()==deposit) {
			String cash = amount.getText();
			if(cash.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
			}
			else {
				Date date = new Date();
				try {
					Conn c = new Conn();
					String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'deposit', '"+cash+"')";
					c.s.executeUpdate(query);
					
					JOptionPane.showMessageDialog(null, "Rs "+cash+" deposited successfully.");
					setVisible(false);
					new Deposit(pinNumber).setVisible(true);
				}
				catch(Exception e) {
					System.out.println(e);
				}
			}
		}
		else if(ae.getSource()==back) {
			setVisible(false);
			new Transactions(pinNumber).setVisible(true);
		}
	}

	public static void main(String[] args) {
		new Deposit("");
	}

}
