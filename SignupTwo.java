package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
	
	JComboBox selectReligion, selectCategory, selectIncome, selectQualification, selectOccupation;
	JTextField panTextField, aadharTextField;
	JRadioButton seniorYes, seniorNo, existYes, existNo;
	JButton next, back;
	String formno;
	
	SignupTwo(String formno){
		
		this.formno = formno;
		setLayout(null);
		setTitle("NEW ACCOUNT APPLICATION FORM  - PAGE 2");
		
		JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
		additionalDetails.setFont(new Font("Railway",Font.BOLD,20));
		additionalDetails.setBounds(290, 80, 400, 30);
		add(additionalDetails);
		
		JLabel religion = new JLabel("Religion : ");
		religion.setFont(new Font("Railway",Font.BOLD,20));
		religion.setBounds(100, 140, 150, 30);
		add(religion);
		
		String[] religions = {"Hindu", "Muslim", "Christian", "Others"};
		selectReligion = new JComboBox(religions);
		selectReligion.setBounds(300, 140, 400, 30);
		selectReligion.setBackground(Color.WHITE);
		add(selectReligion);
		
		JLabel category = new JLabel("Category :");
		category.setFont(new Font("Railway",Font.BOLD,20));
		category.setBounds(100, 190, 200, 30);
		add(category);
		
		String[] categories = {"General", "OBC", "SC", "ST", "Others"};
		selectCategory = new JComboBox(categories);
		selectCategory.setBounds(300, 190, 400, 30);
		selectCategory.setBackground(Color.WHITE);
		add(selectCategory);
		
		JLabel income = new JLabel("Income :");
		income.setFont(new Font("Railway",Font.BOLD,20));
		income.setBounds(100, 240, 200, 30);
		add(income);
		
		String[] incomes = {"Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000"};
		selectIncome = new JComboBox(incomes);
		selectIncome.setBounds(300, 240, 400, 30);
		selectIncome.setBackground(Color.WHITE);
		add(selectIncome);
		
		JLabel edu = new JLabel("Educational");
		edu.setFont(new Font("Railway",Font.BOLD,20));
		edu.setBounds(100, 290, 200, 30);
		add(edu);
		
		JLabel qualification = new JLabel("Qualification :");
		qualification.setFont(new Font("Railway",Font.BOLD,20));
		qualification.setBounds(100, 315, 200, 30);
		add(qualification);
		
		String[] qualifications = {"Non-Graduate", "Graduate", "Post Graduate", "Doctrate", "Others"};
		selectQualification = new JComboBox(qualifications);
		selectQualification.setBounds(300, 315, 400, 30);
		selectQualification.setBackground(Color.WHITE);
		add(selectQualification);
		
		JLabel occu = new JLabel("Occupation :");
		occu.setFont(new Font("Railway",Font.BOLD,20));
		occu.setBounds(100, 390, 200, 30);
		add(occu);
		
		String[] occupations = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
		selectOccupation = new JComboBox(occupations);
		selectOccupation.setBounds(300, 390, 400, 30);
		selectOccupation.setBackground(Color.WHITE);
		add(selectOccupation);
		
		JLabel pan = new JLabel("PAN Number :");
		pan.setFont(new Font("Railway",Font.BOLD,20));
		pan.setBounds(100, 440, 200, 30);
		add(pan);
		
		panTextField = new JTextField();
		panTextField.setFont(new Font("",Font.BOLD,14));
		panTextField.setBounds(300, 440, 400, 30);
		add(panTextField);
		
		JLabel aadhar = new JLabel("Aadhar Number :");
		aadhar.setFont(new Font("Railway",Font.BOLD,20));
		aadhar.setBounds(100, 490, 200, 30);
		add(aadhar);
		
		aadharTextField = new JTextField();
		aadharTextField.setFont(new Font("",Font.BOLD,14));
		aadharTextField.setBounds(300, 490, 400, 30);
		add(aadharTextField);
		
		JLabel senior = new JLabel("Senior Citizen :");
		senior.setFont(new Font("Railway",Font.BOLD,20));
		senior.setBounds(100, 540, 200, 30);
		add(senior);
		
		seniorYes = new JRadioButton("Yes");
		seniorYes.setFont(new Font("Railway",Font.BOLD,20));
		seniorYes.setBounds(300, 540, 100, 30);
		add(seniorYes);
		
		seniorNo = new JRadioButton("No");
		seniorNo.setFont(new Font("Railway",Font.BOLD,20));
		seniorNo.setBounds(450, 540, 100, 30);
		add(seniorNo);
		
		ButtonGroup seniorYesOrNo = new ButtonGroup();
		seniorYesOrNo.add(seniorYes);
		seniorYesOrNo.add(seniorNo);
		
		JLabel exist = new JLabel("Existing Account");
		exist.setFont(new Font("Railway",Font.BOLD,20));
		exist.setBounds(100, 590, 200, 30);
		add(exist);
		
		existYes = new JRadioButton("Yes");
		existYes.setFont(new Font("Railway",Font.BOLD,20));
		existYes.setBounds(300, 590, 100, 30);
		add(existYes);
		
		existNo = new JRadioButton("No");
		existNo.setFont(new Font("Railway",Font.BOLD,20));
		existNo.setBounds(450, 590, 100, 30);
		add(existNo);
		
		ButtonGroup existYesOrNo = new ButtonGroup();
		existYesOrNo.add(seniorYes);
		existYesOrNo.add(seniorNo);
		
		next = new JButton("Next");
        next.setFont(new Font("Railway",Font.BOLD,14));
        next.setBounds(620, 640, 80, 30);
        next.addActionListener(this);
        add(next);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setFont(new Font("Railway",Font.BOLD,14));
        back.setBounds(100, 640, 80, 30);
        back.addActionListener(this);
        add(back);
		
		getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		formno = ""+formno;
		String religion = (String) selectReligion.getSelectedItem();
		String category = (String) selectCategory.getSelectedItem();
		String income = (String) selectIncome.getSelectedItem();
		String education = (String) selectQualification.getSelectedItem();
		String occupation = (String) selectOccupation.getSelectedItem();
		String pan = panTextField.getText();
		String aadhar = aadharTextField.getText();
		String senior = "";
		if(seniorYes.isSelected()) {
			senior = senior + "Yes";
		}
		else if(seniorNo.isSelected()) {
			senior = senior + "No";
		}
		String exist = null;
		if(existYes.isSelected()) {
			exist = exist + "Yes";
		}
		else if(existNo.isSelected()) {
			exist = exist + "No";
		}
		try {
			if(ae.getSource()==back) {
				setVisible(false);
				new SignupOne().setVisible(true);
			}
			if(religion.equals("")) {
				JOptionPane.showMessageDialog(null, "Select Religion");
				return;
			}
			if(category.equals("")) {
				JOptionPane.showMessageDialog(null, "Select Category");
				return;
			}
			if(income.equals("")) {
				JOptionPane.showMessageDialog(null, "Select Income");
				return;
			}
			if(education.equals("")) {
				JOptionPane.showMessageDialog(null, "Select Educational Qualification");
				return;
			}
			if(occupation.equals("")) {
				JOptionPane.showMessageDialog(null, "Select Occupation");
				return;
			}
			if(pan.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter PAN Number");
				return;
			}
			if(aadhar.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter AADHAR Number");
				return;
			}
			if(senior.equals("")) {
				JOptionPane.showMessageDialog(null, "Select Senior Citizen");
				return;
			}
			if(exist.equals("")) {
				JOptionPane.showMessageDialog(null, "Select Existing Account");
				return;
			}
			if(ae.getSource()==next) {
				Conn c = new Conn();
				String query = "insert into signuptwo values('"+formno+"', '"+religion+"', '"+category+"', '"+income+"', '"+education+"', '"+occupation+"', '"+pan+"', '"+aadhar+"', '"+senior+"', '"+exist+"')";
				c.s.executeUpdate(query);
				setVisible(false);
				new SignupThree(formno).setVisible(true);
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		
		new SignupTwo("");

	}

}
