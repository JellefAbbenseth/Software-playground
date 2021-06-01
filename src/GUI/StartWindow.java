package GUI;

import javax.swing.*;

import game.CreateChar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class StartWindow extends JFrame implements ActionListener
{	
	/*
	 * Implement the different Objects for the Window
	 * cn = character name; tcn = text character name;
	 */
	JTextField cn = new JTextField("");
	JLabel title = new JLabel("Growth");
	JLabel tcn = new JLabel("Character name: ");
	JButton agree = new JButton("OK");
	JPanel panel = new JPanel();
	
	//This is for the question if a charakter name was set
	boolean text = false;
	
	public StartWindow()
	{
		//Shut down the program if you press the X on the top-right side
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		this.setTitle("Growth");
		this.setSize(400,500);
		setLocationRelativeTo(null);
		
		//set the Border Layout to the panel
		panel.setLayout(new java.awt.BorderLayout());		
		
		//Button agree & TextField cn to listener
		agree.addActionListener(this);
		cn.addActionListener(this);
		
		//Add all those components together
		panel.add(title, java.awt.BorderLayout.PAGE_START);
		panel.add(agree, java.awt.BorderLayout.PAGE_END);
		panel.add(tcn, java.awt.BorderLayout.LINE_START);
		panel.add(cn, java.awt.BorderLayout.CENTER);		
		
		this.getContentPane().add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == this.cn)
		{
			text = true;
			//System.out.println("Test erfolgreich");
		}else if(ae.getSource() == this.agree && text == true)
		{
			//System.out.println("Test 2 erfolgreich");
			text = false;
			setVisible(false);
			CreateChar myChar = new CreateChar();
			myChar.createChar(cn.getText());
		}else if(ae.getSource() == this.agree)
		{
			JOptionPane.showMessageDialog(null, "Please enter a character name, press Enter \nthen the OK button");
		}
	}
}
