package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
	
	JRadioButton saving, fd, current, recurring;
	JButton submit, cancel;
	JCheckBox atm, ib, mb, eas, cb, es, dec;
	String formno;
	Random rand = new Random();
	String cno = "" + Math.abs((rand.nextLong() % 90000000L) + 5040936000000000L);
	String cnox = ""+cno.charAt(12)+cno.charAt(13)+cno.charAt(14)+cno.charAt(15);
	SignupThree(String formno){
		this.formno = formno;
		setLayout(null);
		
		JLabel l1 = new JLabel("Page 3 : Account Details");
		l1.setFont(new Font("Railway",Font.BOLD,22));
		l1.setBounds(280, 40, 400, 40);
		add(l1);
		
		JLabel type = new JLabel("Account Type :");
		type.setFont(new Font("Railway",Font.BOLD,22));
		type.setBounds(100, 140, 200, 30);
		add(type);
		
		saving = new JRadioButton("Saving Account");
		saving.setFont(new Font("Railway",Font.BOLD,16));
		saving.setBackground(Color.WHITE);
		saving.setBounds(100, 180, 250, 30);
		add(saving);
		
		fd = new JRadioButton("Fixed Deposit Account");
		fd.setFont(new Font("Railway",Font.BOLD,16));
		fd.setBounds(350, 180, 250, 30);
		add(fd);
		
		current = new JRadioButton("Current Account");
		current.setFont(new Font("Railway",Font.BOLD,16));
		current.setBounds(100, 220, 250, 30);
		add(current);
		
		recurring = new JRadioButton("Recurring Deposit Account");
		recurring.setFont(new Font("Railway",Font.BOLD,16));
		recurring.setBounds(350, 220, 300, 30);
		add(recurring);
		
		ButtonGroup types = new ButtonGroup();
		types.add(saving);
		types.add(fd);
		types.add(current);
		types.add(recurring);
		
		JLabel cardno = new JLabel("Card Number :");
		cardno.setFont(new Font("Railway",Font.BOLD,22));
		cardno.setBounds(100, 300, 200, 30);
		add(cardno);
		
		JLabel xx = new JLabel("XXXX-XXXX-XXXX-"+cnox);
		xx.setFont(new Font("Railway",Font.BOLD,22));
		xx.setBounds(330, 300, 300, 30);
		add(xx);
		
		JLabel digits = new JLabel("Your 16 Digit Card Number");
		digits.setFont(new Font("Railway",Font.BOLD,12));
		digits.setBounds(100, 330, 300, 20);
		add(digits);
		
		JLabel pin = new JLabel("PIN :");
		pin.setFont(new Font("Railway",Font.BOLD,22));
		pin.setBounds(100, 370, 200, 30);
		add(pin);
		
		JLabel x = new JLabel("XXXX");
		x.setFont(new Font("Railway",Font.BOLD,22));
		x.setBounds(330, 370, 200, 30);
		add(x);
		
		JLabel digits4 = new JLabel("Your 4 Digit Password");
		digits4.setFont(new Font("Railway",Font.BOLD,12));
		digits4.setBounds(100, 400, 300, 20);
		add(digits4);
		

		JLabel services = new JLabel("Services Required :");
		services.setFont(new Font("Railway",Font.BOLD,22));
		services.setBounds(100, 450, 230, 30);
		add(services);
		
		atm = new JCheckBox("ATM CARD");
		atm.setFont(new Font("Railway",Font.BOLD,16));
		atm.setBackground(Color.WHITE);
		atm.setBounds(100, 500, 250, 30);
		add(atm);

		ib = new JCheckBox("Internet Banking");
		ib.setBackground(Color.WHITE);
		ib.setFont(new Font("Railway",Font.BOLD,16));
		ib.setBounds(350, 500, 250, 30);
		add(ib);
		
		mb = new JCheckBox("Mobile Banking");
		mb.setBackground(Color.WHITE);
		mb.setFont(new Font("Railway",Font.BOLD,16));
		mb.setBounds(100, 550, 250, 30);
		add(mb);
		
		eas = new JCheckBox("EMAIL & SMS Alerts");
		eas.setBackground(Color.WHITE);
		eas.setFont(new Font("Railway",Font.BOLD,16));
		eas.setBounds(350, 550, 250, 30);
		add(eas);
		
		cb = new JCheckBox("Cheque Book");
		cb.setBackground(Color.WHITE);
		cb.setFont(new Font("Railway",Font.BOLD,16));
		cb.setBounds(100, 600, 250, 30);
		add(cb);
		
		es = new JCheckBox("E-Statement");
		es.setBackground(Color.WHITE);
		es.setFont(new Font("Railway",Font.BOLD,16));
		es.setBounds(350, 600, 250, 30);
		add(es);
		
		dec = new JCheckBox("I hereby declare that above entered details are correct to the best of my knowledge");
		dec.setFont(new Font("Railway",Font.BOLD,12));
		dec.setBounds(100, 680, 600, 30);
		add(dec);
		
		submit = new JButton("Submit");
		submit.setFont(new Font("Railway",Font.BOLD,14));
		submit.setBounds(250, 720, 100, 30);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setFont(new Font("Railway",Font.BOLD,14));
		cancel.setBounds(420, 720, 100, 30);
		cancel.addActionListener(this);
		add(cancel);
		
		setVisible(true);
		setLocation(350, 0);
		setSize(850, 820);
		getContentPane().setBackground(Color.WHITE);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		String accountType = "";
		if(saving.isSelected()) {
			accountType = "Saving Account";
		}
		else if(fd.isSelected()) {
			accountType = "Fixed Deposit Account";
		}
		else if(current.isSelected()) {
			accountType = "Current Account";
		}
		else if(recurring.isSelected()) {
			accountType = "Recurring Deposit Account";
		}
			
		String cardNumber = cno;
		String pinNumber = "" + Math.abs((rand.nextLong() % 9000L) + 1000L);
			
		String services = "";
		if(atm.isSelected()) {
			services = services + " ATM CARD";
		}
		if(ib.isSelected()) {
			services = services + " Internet Banking";
		}
		if(mb.isSelected()) {
			services = services + " Mobile Banking";
		}
		if(eas.isSelected()) {
			services = services + " EMAIL & SMS Alerts";
		}
		if(cb.isSelected()) {
			services = services + " Cheque Book";
		}
		if(es.isSelected()) {
			services = services + " E-Statement";
		}
		String check = "";
		if(dec.isSelected()) {
			check = "true";
		}
		try {
			if(accountType.equals("")) {
				JOptionPane.showMessageDialog(null, "Account Type is Required");
			}
			if(services.equals("")) {
					JOptionPane.showMessageDialog(null, "Select the Services Required");
			}
			if(check.equals("")) {
				JOptionPane.showMessageDialog(null, "Please tick the check box");
			}
			if(ae.getSource()==submit) {
				Conn c = new Conn();
				String query1 = "insert into signupthree values('"+formno+"', '"+accountType+"', '"+cardNumber+"', '"+pinNumber+"', '"+services+"')";
				String query2 = "insert into login values('"+formno+"', '"+cardNumber+"', '"+pinNumber+"')";
				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
					
				JOptionPane.showMessageDialog(null, "Card Number : "+cardNumber+"\n Pin Number : "+pinNumber);
				
				setVisible(false);
				new Deposit(pinNumber).setVisible(true);
			}
			else if(ae.getSource()==cancel) {
					setVisible(false);
					new Login().setVisible(true);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		new SignupThree("");
	}

}
