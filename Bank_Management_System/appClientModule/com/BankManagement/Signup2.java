package com.BankManagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Signup2 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	JTextField panTextField, aadharTextField;
	JButton next;
	JRadioButton syes, sno, eyes, eno;
	JComboBox<?> religion1, category1, occupation1, education1, income1;
	String formno;

	Signup2(String formno) {
		this.formno = formno;
		setLayout(null);

		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

		JLabel additionalDetails = new JLabel("Page 2: Additional Details");
		additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		additionalDetails.setBounds(290, 80, 400, 30);
		add(additionalDetails);

		JLabel religion = new JLabel("Religion:");
		religion.setFont(new Font("Raleway", Font.BOLD, 20));
		religion.setBounds(100, 140, 100, 30);
		add(religion);

		String valReligion[] = { "Hindu", "Muslim", "Sikh", "Cristian", "Other" };
		religion1 = new JComboBox<String>(valReligion);
		religion1.setBounds(300, 140, 400, 30);
		religion1.setBackground(Color.WHITE);
		add(religion1);

		JLabel category = new JLabel("Category:");
		category.setFont(new Font("Raleway", Font.BOLD, 20));
		category.setBounds(100, 190, 200, 30);
		add(category);

		String valCategory[] = { "General", "OBC", "SC", "ST", "Other" };
		category1 = new JComboBox<String>(valCategory);
		category1.setBounds(300, 190, 400, 30);
		category1.setBackground(Color.WHITE);
		add(category1);

		JLabel income = new JLabel("Income:");
		income.setFont(new Font("Raleway", Font.BOLD, 20));
		income.setBounds(100, 240, 200, 30);
		add(income);

		String valincome[] = { "Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000" };
		income1 = new JComboBox<String>(valincome);
		income1.setBounds(300, 240, 400, 30);
		income1.setBackground(Color.WHITE);
		add(income1);

		JLabel education = new JLabel("Education:");
		education.setFont(new Font("Raleway", Font.BOLD, 20));
		education.setBounds(100, 290, 200, 30);
		add(education);

		JLabel qualification = new JLabel("Qualification:");
		qualification.setFont(new Font("Raleway", Font.BOLD, 20));
		qualification.setBounds(100, 315, 200, 30);
		add(qualification);

		String educationvalues[] = { "Non Graduation", "Graduate", "Post Graduation", "Doctrate", "Others" };
		education1 = new JComboBox<String>(educationvalues);
		education1.setBounds(300, 315, 400, 30);
		education1.setBackground(Color.WHITE);
		add(education1);

		JLabel occupation = new JLabel("Occupation:");
		occupation.setFont(new Font("Raleway", Font.BOLD, 20));
		occupation.setBounds(100, 390, 200, 30);
		add(occupation);

		String occupationvalues[] = { "Salaried", "Self-Employed", "Bussiness", "Student", "Retired", "Others" };
		occupation1 = new JComboBox<String>(occupationvalues);
		occupation1.setBounds(300, 390, 400, 30);
		occupation1.setBackground(Color.WHITE);
		add(occupation1);

		JLabel pannummber = new JLabel("PAN Number:");
		pannummber.setFont(new Font("Raleway", Font.BOLD, 20));
		pannummber.setBounds(100, 440, 200, 30);
		add(pannummber);

		panTextField = new JTextField();
		panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		panTextField.setBounds(300, 440, 400, 30);
		add(panTextField);

		JLabel aadharnumber = new JLabel("Aadhar Number:");
		aadharnumber.setFont(new Font("Raleway", Font.BOLD, 20));
		aadharnumber.setBounds(100, 490, 200, 30);
		add(aadharnumber);

		aadharTextField = new JTextField();
		aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		aadharTextField.setBounds(300, 490, 400, 30);
		add(aadharTextField);

		JLabel seniorcitizen = new JLabel("Senior Citizen:");
		seniorcitizen.setFont(new Font("Raleway", Font.BOLD, 20));
		seniorcitizen.setBounds(100, 540, 200, 30);
		add(seniorcitizen);

		syes = new JRadioButton("Yes");
		syes.setBounds(300, 540, 60, 30);
		syes.setBackground(Color.WHITE);
		add(syes);

		sno = new JRadioButton("No");
		sno.setBounds(450, 540, 120, 30);
		sno.setBackground(Color.WHITE);
		add(sno);

		ButtonGroup maritalgroup = new ButtonGroup();
		maritalgroup.add(syes);
		maritalgroup.add(sno);

		JLabel exisitingaccount = new JLabel("Exisiting Account:");
		exisitingaccount.setFont(new Font("Raleway", Font.BOLD, 20));
		exisitingaccount.setBounds(100, 590, 200, 30);
		add(exisitingaccount);

		eyes = new JRadioButton("Yes");
		eyes.setBounds(300, 590, 60, 30);
		eyes.setBackground(Color.WHITE);
		add(eyes);

		eno = new JRadioButton("No");
		eno.setBounds(450, 590, 120, 30);
		eno.setBackground(Color.WHITE);
		add(eno);

		ButtonGroup Exitgroup = new ButtonGroup();
		Exitgroup.add(eyes);
		Exitgroup.add(eno);

		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBounds(620, 660, 80, 30);
		next.addActionListener(this);
		add(next);

		getContentPane().setBackground(Color.WHITE);

		setSize(850, 800);
		setLocation(350, 10);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {

		String religion1 = (String) this.religion1.getSelectedItem();
		String category1 = (String) this.category1.getSelectedItem();
		String income1 = (String) this.income1.getSelectedItem();
		String education1 = (String) this.education1.getSelectedItem();
		String occupation1 = (String) this.occupation1.getSelectedItem();
		String seniorcitizen = null;
		if (syes.isSelected()) {
			seniorcitizen = "Yes";
		} else if (sno.isSelected()) {
			seniorcitizen = "No";
		}

		String exisitingaccount = null;
		if (eyes.isSelected()) {
			exisitingaccount = "Yes";

		} else if (eno.isSelected()) {
			exisitingaccount = "No";
		}
		String span = panTextField.getText();
		String saadhar = aadharTextField.getText();

		try {

			ConnectWithJdbc c = new ConnectWithJdbc();
			String query = "insert into signup2 values('" + 1 + "','" + religion1 + "','" + category1 + "','" + income1
					+ "','" + education1 + "','" + occupation1 + "','" + span + "','" + saadhar + "','" + seniorcitizen
					+ "','" + exisitingaccount + "')";
			c.s.executeUpdate(query);
			setVisible(false);
			new Signup2(formno).setVisible(true);

		} // signup3 object
		catch (Exception e) {
			System.out.println(e);
		}

		new SignUp3(formno);
	}

	public static void main(String[] args) {
		new Signup2("");
	}

}
