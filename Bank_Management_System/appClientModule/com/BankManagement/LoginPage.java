package com.BankManagement;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class LoginPage extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton login,signup,clear;
	JTextField cardTextField;
	JPasswordField pinTextField;
	JFrame color;
	LoginPage(){
		
		
		setTitle("AUTOMATEC TELLER MACHINE");
		getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout() );
	    setContentPane(new JLabel(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\Bank_Management_System\\appClientModule\\icons\\Image.jpg")));

		
		setLayout(null);
								
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));//location error
		Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel label=new JLabel(i3);
		label.setBounds(70, 10, 100, 100);
		add(label);
		
		JLabel text=new JLabel("Welcom to ATM");
		text.setFont(new Font("Osward",Font.BOLD,38));
		text.setBounds(200, 40, 400, 40);
		add(text);
		
		JLabel cardno=new JLabel("Card No:");
		cardno.setFont(new Font("Raleway",Font.BOLD,28));
		cardno.setBounds(120, 150, 150, 40);
		add(cardno);
		
		cardTextField=new JTextField();
		cardTextField.setBounds(300,150, 230, 30);
		cardTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(cardTextField);
		
		JLabel pin=new JLabel("Pin");
		pin.setFont(new Font("Raleway",Font.BOLD,28));
		pin.setBounds(120,220, 250, 30);
		add(pin);
		
		pinTextField=new JPasswordField();
		pinTextField.setBounds(300,220, 230, 30);
		pinTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(pinTextField);
		
		login=new JButton("SIGN IN");
		login.setBounds(300, 300, 100, 30);
		login.setBackground(Color.LIGHT_GRAY);
		login.setForeground(Color.BLACK);
		login.addActionListener(this);
		add(login);
		
	    clear=new JButton("CLEAR");
		clear.setBounds(430, 300, 100, 30);
		clear.setBackground(Color.LIGHT_GRAY);
		clear.setForeground(Color.BLACK);
		clear.addActionListener(this);
		add(clear);
		
	    signup=new JButton("SIGN UP");
		signup.setBounds(300, 350, 230, 30);
		signup.setBackground(Color.LIGHT_GRAY);
		signup.setForeground(Color.BLACK);
		signup.addActionListener(this);
		add(signup);
		
		
		setSize(800,420);
		setLocation(350,200);
		
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == clear)
		{
			cardTextField.setText("");
			pinTextField.setText("");
			
		}else if(ae.getSource() == login)
		{
			ConnectWithJdbc c=new ConnectWithJdbc();
			String cardnumber=cardTextField.getText();
			@SuppressWarnings("deprecation")
			String pinnumber=pinTextField.getText();
			String query="select*from login  where cardnumber='"+cardnumber+"'and pinnumber='"+pinnumber+"'";
			try
			{
				
				
				ResultSet rs=c.s.executeQuery(query);
				if(rs.next())
				{
					
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
				}
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}else if(ae.getSource() == signup)
		{
			setVisible(false);
			new Signup().setVisible(true);
		}
		
		
	}

	public static void main(String[] args) {
		new LoginPage();
		
	}

}
