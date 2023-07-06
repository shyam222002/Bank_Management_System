package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton login;
    JButton signup;
    JButton clear;
    JTextField cardTextField;
    JPasswordField passTextField;

    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel text = new JLabel("WELCOME TO SHYAM ATM");
        text.setBounds(200,40,600,40);
        text.setFont(new Font("Osward",Font.BOLD,38));
        add(text);

        JLabel cardno = new JLabel("Card No: ");
        cardno.setBounds(120, 150, 400, 40);
        cardno.setFont(new Font("Railway",Font.BOLD,28));
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 160, 250, 30);
        cardTextField.setFont(new Font("Railway",Font.BOLD,14));
        add(cardTextField);

        JLabel pin = new JLabel("PIN: ");
        pin.setBounds(120, 220, 250, 30);
        pin.setFont(new Font("Railway",Font.BOLD,28));
        add(pin);

        passTextField = new JPasswordField();
        passTextField.setBounds(300, 220, 250, 30);
        passTextField.setFont(new Font("Railway",Font.BOLD,14));
        add(passTextField);

        login = new JButton("SIGN IN");
        login.setBackground(Color.BLACK);
        login.setFont(new Font("Arial",Font.BOLD,14));
        login.setBounds(300, 300, 100, 30);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setFont(new Font("Arial",Font.BOLD,14));
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBackground(Color.BLACK);
        signup.setFont(new Font("Arial",Font.BOLD,14));
        signup.setBounds(300, 350, 230, 30);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);
        setLocation(350,200);
        setSize(800,480);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
            if(ae.getSource()==login){
            	try {
	            	Conn c = new Conn();
	            	String cardNumber = cardTextField.getText();
	            	String pinNumber = passTextField.getText();
	            	String query = "select * from login where card_number = '"+cardNumber+"' and pin_number = '"+pinNumber+"'";
	            	ResultSet rs = c.s.executeQuery(query);
	            	if(rs.next()) {
	            		setVisible(false);
	            		new Transactions(pinNumber).setVisible(true);
	            	}
	            	else {
	            		JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
	            	}
            	}
            	catch(Exception e){
            		System.out.println(e);
            	}
            	
            }
            else if(ae.getSource()==clear){
                cardTextField.setText("");
                passTextField.setText("");
            }
            else if(ae.getSource()==signup){
                setVisible(false);
                new SignupOne().setVisible(true);
            }
    }
    public static void main(String[] args) {
        new Login();

    }
}

