package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
	
	JButton deposit, fastCash, pinChange, cashWithdrawl, miniStatement, balance, exit;
	String pinNumber;
	
	Transactions(String pinNumber){
		this.pinNumber = pinNumber;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image); 
		
		JLabel text = new JLabel("Please Select Your Transaction");
		text.setBounds(210, 300, 700, 35);
		text.setFont(new Font("System",Font.BOLD, 16));
		image.add(text);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(170, 415, 150, 30);
		deposit.setFont(new Font("System",Font.BOLD,14));
		deposit.addActionListener(this);
		image.add(deposit);
		
		fastCash = new JButton("Fast Cash");
		fastCash.setBounds(170, 450, 150, 30);
		fastCash.setFont(new Font("System",Font.BOLD,14));
		fastCash.addActionListener(this);
		image.add(fastCash);
		
		pinChange = new JButton("PIN Change");
		pinChange.setBounds(170, 485, 150, 30);
		pinChange.setFont(new Font("System",Font.BOLD,14));
		pinChange.addActionListener(this);
		image.add(pinChange);
		
		cashWithdrawl = new JButton("Cash Withdrawl");
		cashWithdrawl.setBounds(355, 415, 170, 30);
		cashWithdrawl.setFont(new Font("System",Font.BOLD,14));
		cashWithdrawl.addActionListener(this);
		image.add(cashWithdrawl);
		
		miniStatement = new JButton("Mini Statement");
		miniStatement.setBounds(355, 450, 170, 30);
		miniStatement.setFont(new Font("System",Font.BOLD,14));
		miniStatement.addActionListener(this);
		image.add(miniStatement);
		
		balance = new JButton("Balance Enquiry");
		balance.setBounds(355, 485, 170, 30);
		balance.setFont(new Font("System",Font.BOLD,14));
		balance.addActionListener(this);
		image.add(balance);
		
		exit = new JButton("Exit");
		exit.setBounds(355, 520, 170, 30);
		exit.setFont(new Font("System",Font.BOLD,14));
		exit.addActionListener(this);
		image.add(exit);
		
		setLayout(null);
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==exit) {
			setVisible(false);
			new Login().setVisible(true);
		}
		else if(ae.getSource()==deposit) {
			setVisible(false);
			new Deposit(pinNumber).setVisible(true);
		}
		else if(ae.getSource()==cashWithdrawl) {
			setVisible(false);
			new Withdrawl(pinNumber).setVisible(true);
		}
		else if(ae.getSource()==fastCash) {
			setVisible(false);
			new FastCash(pinNumber).setVisible(true);
		}
		else if(ae.getSource()==pinChange) {
			setVisible(false);
			new PinChange(pinNumber).setVisible(true);
		}
		else if(ae.getSource()==balance) {
			setVisible(false);
			new BalanceEnquiry(pinNumber).setVisible(true);
		}
		else if(ae.getSource()==miniStatement) {
			new MiniStatement(pinNumber).setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new Transactions("");
	}

}
