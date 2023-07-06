package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    Long random;
    JTextField nameField, fnameField, emailField, addField, cityField, stateField, pincodeField;
    JRadioButton male, female, married, unmarried, others;
    JButton next,back;
    SignupOne(){
        setLayout(null);
        Random ran = new Random();
        random=(Math.abs(ran.nextLong() % 9000L) + 1001);

        JLabel formno = new JLabel("APPLICATION FORM NO : "+random);
        formno.setFont(new Font("Railway",Font.BOLD,38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
        JLabel text = new JLabel("Page 1: Personal Details");
        text.setBounds(290, 80, 400, 30);
        text.setFont(new Font("Railway",Font.BOLD,22));
        add(text);

        JLabel name = new JLabel("Name : ");
        name.setBounds(100, 140, 100, 30);
        name.setFont(new Font("Railway",Font.BOLD,20));
        add(name);
        
        nameField = new JTextField();
        nameField.setBounds(300, 140, 400, 30);
        nameField.setFont(new Font("Railway",Font.BOLD,14));
        add(nameField);

        JLabel fname = new JLabel("Father's Name : ");
        fname.setBounds(100, 190, 200, 30);
        fname.setFont(new Font("Railway",Font.BOLD,20));
        add(fname);

        fnameField = new JTextField();
        fnameField.setBounds(300, 190, 400, 30);
        fnameField.setFont(new Font("Railway",Font.BOLD,14));
        add(fnameField);

        JLabel gender = new JLabel("Gender : ");
        gender.setBounds(100, 240, 200, 30);
        gender.setFont(new Font("Railway",Font.BOLD,20));
        add(gender);

        male = new JRadioButton("MALE");
        male.setBounds(300, 240, 100, 30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("FEMALE");
        female.setBounds(450, 240, 100, 30);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("Email Address : ");
        email.setBounds(100, 290, 200, 30);
        email.setFont(new Font("Railway",Font.BOLD,20));
        add(email);

        emailField = new JTextField();
        emailField.setBounds(300, 290, 400, 30);
        emailField.setFont(new Font("Railway",Font.BOLD,14));
        add(emailField);

        JLabel mstatus = new JLabel("Marital Status : ");
        mstatus.setBounds(100, 340, 200, 30);
        mstatus.setFont(new Font("Railway",Font.BOLD,20));
        add(mstatus);

        married = new JRadioButton("Married");
        married.setBounds(300, 340, 100, 30);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 340, 100, 30);
        add(unmarried);

        others = new JRadioButton("Others");
        others.setBounds(630, 340, 100, 30);
        add(others);

        ButtonGroup marriedGroup = new ButtonGroup();
        marriedGroup.add(married);
        marriedGroup.add(unmarried);
        marriedGroup.add(others);

        JLabel Address = new JLabel("Address : ");
        Address.setBounds(100, 390, 200, 30);
        Address.setFont(new Font("Railway",Font.BOLD,20));
        add(Address);

        addField = new JTextField();
        addField.setBounds(300, 390, 400, 30);
        addField.setFont(new Font("Railway",Font.BOLD,14));
        add(addField);

        JLabel city = new JLabel("City : ");
        city.setBounds(100, 440, 200, 30);
        city.setFont(new Font("Railway",Font.BOLD,20));
        add(city);

        cityField = new JTextField();
        cityField.setBounds(300, 440, 400, 30);
        cityField.setFont(new Font("Railway",Font.BOLD,14));
        add(cityField);

        JLabel state = new JLabel("State : ");
        state.setBounds(100, 490, 200, 30);
        state.setFont(new Font("Railway",Font.BOLD,20));
        add(state);

        stateField = new JTextField();
        stateField.setBounds(300, 490, 400, 30);
        stateField.setFont(new Font("Railway",Font.BOLD,14));
        add(stateField);

        JLabel pincode = new JLabel("Pin Code : ");
        pincode.setBounds(100, 540, 200, 30);
        pincode.setFont(new Font("Railway",Font.BOLD,20));
        add(pincode);

        pincodeField = new JTextField();
        pincodeField.setBounds(300, 540, 400, 30);
        pincodeField.setFont(new Font("Railway",Font.BOLD,14));
        add(pincodeField);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setFont(new Font("Railway",Font.BOLD,14));
        next.setBounds(620, 610, 80, 30);
        next.addActionListener(this);
        add(next);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setFont(new Font("Railway",Font.BOLD,14));
        back.setBounds(100, 610, 80, 30);
        back.addActionListener(this);
        add(back);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String formno = ""+random;
        String name = nameField.getText();
        String fname = fnameField.getText();
        String gender = "";
        if(male.isSelected()){
            gender = gender + "male";
        }
        else if(female.isSelected()){
            gender = gender + "female";
        }
        String email = emailField.getText();
        String mstatus = "";
        if(married.isSelected()){
            mstatus = mstatus +"married";
        }
        else if(unmarried.isSelected()){
            mstatus = mstatus +"unmarried";
        }
        else if(others.isSelected()){
            mstatus = mstatus +"others";
        }
        String address = addField.getText();
        String city = cityField.getText();
        String state = stateField.getText();
        String pincode = pincodeField.getText();
        
        try{
        	if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required");
                return;
            }
            if(fname.equals("")){
                JOptionPane.showMessageDialog(null, "Father's Name is required");
                return;
                
            }
            if(gender.equals("")) {
            	JOptionPane.showMessageDialog(null, "gender is required");
            	return;
            }
            if(email.equals("")){
                JOptionPane.showMessageDialog(null, "Email is required");
                return;
            }
            if(address.equals("")){
                JOptionPane.showMessageDialog(null, "Address is required");
                return;
            }
            if(city.equals("")){
                JOptionPane.showMessageDialog(null, "City is required");
                return;
            }
            if(state.equals("")){
                JOptionPane.showMessageDialog(null, "State is required");
                return;
            }
            if(pincode.equals("")){
                JOptionPane.showMessageDialog(null, "Pincode is required");
                return;
            }
        	if(ae.getSource()==next) {
	            Conn c = new Conn();
	            String query = "insert into signup values ('"+formno+"', '"+name+"', '"+fname+"', '"+gender+"', '"+email+"', '"+mstatus+"', '"+address+"', '"+city+"', '"+state+"', '"+pincode+"')";
	            c.s.executeUpdate(query);
	            setVisible(false);
	            new SignupTwo(formno).setVisible(true);
        	}
        	else if(ae.getSource()==back) {
        		setVisible(false);
        		new Login().setVisible(true);
        	}
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new SignupOne();
    }
}

