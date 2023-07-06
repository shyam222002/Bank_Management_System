package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
	
	String pinNumber;
	JButton change, back;
	JPasswordField pinTextField, repinTextField;
	
	PinChange(String pinNumber){
		this.pinNumber = pinNumber;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image); 
		
		JLabel text = new JLabel("CHANGE YOUR PIN");
		text.setForeground(Color.WHITE);
		text.setBounds(250, 280, 500, 35);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);
		
		JLabel pinText = new JLabel("New PIN :");
		pinText.setForeground(Color.WHITE);
		pinText.setBounds(165, 320, 180, 25);
		pinText.setFont(new Font("System",Font.BOLD,16));
		image.add(pinText);
		
		pinTextField = new JPasswordField();
		pinTextField.setBounds(330, 320, 180, 25);
		pinTextField.setFont(new Font("Raleway",Font.BOLD,25));
		image.add(pinTextField);
		
		
		JLabel repinText = new JLabel("Re-enter Your PIN :");
		repinText.setForeground(Color.WHITE);
		repinText.setBounds(165, 360, 180, 25);
		repinText.setFont(new Font("System",Font.BOLD,16));
		image.add(repinText);
		
		repinTextField = new JPasswordField();
		repinTextField.setBounds(330, 360, 180, 25);
		repinTextField.setFont(new Font("Raleway",Font.BOLD,25));
		image.add(repinTextField);
		
		change = new JButton("CHANGE");
		change.setBounds(355, 485, 150, 30);
		change.addActionListener(this);
		image.add(change);
		
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
		else if(ae.getSource()==change) {
			try {
				String pin = pinTextField.getText();
				String repin = repinTextField.getText();
				
				if(!pin.equals(repin)) {
					JOptionPane.showMessageDialog(null, "Entered PIN does not match");
					return;
				}
				if(pin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter new PIN");
					return;
				}
				if(repin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Re-enter new PIN");
					return;
				}
				Conn c = new Conn();
				String query1 = "update bank set pin_number= '"+pin+"' where pin_number= '"+pinNumber+"'";
				String query2 = "update login set pin_number= '"+pin+"' where pin_number= '"+pinNumber+"'";
				String query3 = "update signupthree set pin_number= '"+pin+"' where pin_number= '"+pinNumber+"'";
				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
				c.s.executeUpdate(query3);
				
				JOptionPane.showMessageDialog(null, "Changed PIN Successfully");
				
				setVisible(false);
				new Transactions(pin).setVisible(true);
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
	}
	
	public static void main(String[] args) {
		new PinChange("");

	}

}
