package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{
	
	JButton withdrawl, back;
	JTextField amount;
	String pinNumber;
	
	Withdrawl(String pinNumber){
		this.pinNumber = pinNumber;
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image); 
		
		JLabel text = new JLabel("Enter the amount you want to withdrawl");
		text.setBounds(170, 300, 400, 20);
		text.setFont(new Font("System",Font.BOLD, 14));
		text.setForeground(Color.WHITE);
		image.add(text);
		
		amount = new JTextField();
		amount.setBounds(170, 350, 320, 25);
		amount.setFont(new Font("System",Font.BOLD, 14));
		image.add(amount);
		
		withdrawl = new JButton("withdrawl");
		withdrawl.setBounds(355, 485, 150, 30);
		withdrawl.setFont(new Font("System",Font.BOLD,14));
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		
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
		if(ae.getSource()==withdrawl) {
			String cash = amount.getText();
			if(cash.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdrawl");
			}
			else {
				Date date = new Date();
				try {
					Conn c = new Conn();
					String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'withdrawl', '"+cash+"')";
					c.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs "+cash+" withdrawled successfully.");
					setVisible(false);
					new Withdrawl(pinNumber).setVisible(true);
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
		new Withdrawl("");
	}

}
