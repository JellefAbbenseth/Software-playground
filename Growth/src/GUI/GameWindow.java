package GUI;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class GameWindow extends JFrame //implements ActionListener
{
	/*
	 * Implement all the Objects I need to create my User Interface
	 */
	private JPanel framePanel;
	private JPanel cardPanel;
	private JPanel worldPanel;
	private JPanel battlePanel;
	
	private JLabel text;
	private CardLayout wbCardLayout;
	private JButton explore;
	private JButton restWorld;
	private JButton profil;
	private JButton attack;
	private JButton restBattle;
	private JButton escape;
	
	//private String text;
	
	private int currentCard = 1;
	
	public GameWindow(classes.Player myPlayer)
	{
		//Shut down program, while pressing the X in the window
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		//set settings for the Window (Frame)
		this.setTitle("Growth");
		this.setSize(640, 400); //1280, 800
		this.setLocationRelativeTo(null);
		
		//set Settings for the framePanel
		framePanel = new JPanel();
		framePanel.setLayout(new java.awt.BorderLayout());
		text = new JLabel("Start");
		text.setBackground(Color.white);
		text.setOpaque(true);
		cardPanel = new JPanel();
		cardPanel.setSize(1200, 180);
		
		/*
		 * Settings for the CardLayout
		 */
		wbCardLayout = new CardLayout();
		cardPanel.setLayout(wbCardLayout);
		
		worldPanel = new JPanel();
		battlePanel = new JPanel();
		
		//Add Buttons to worldPanel
		explore = new JButton("Erkunden");
		restWorld = new JButton("Ausruhen");
		profil = new JButton("Profil");
		
		worldPanel.add(explore);
		worldPanel.add(restWorld);
		worldPanel.add(profil);
		
		//Add Buttons to battlePanel
		attack = new JButton("Angriff");
		restBattle = new JButton("Ausruhen");
		escape = new JButton("Fliehen");
		
		battlePanel.add(attack);
		battlePanel.add(restBattle);
		battlePanel.add(escape);
		
		//Add the two Panels to the cardPanel
		cardPanel.add(worldPanel, "1");
		cardPanel.add(battlePanel, "2");
		
		/*
		 * ActionListener for the Buttons
		 */
		explore.addActionListener(new ActionListener()
		{
			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent aeExplore)
			{
				game.Battle battle = new game.Battle();
				//text.setText(battle.battle(myPlayer));
				System.out.println(text);
			}
		});
		
		/*
		 * For testing Reasons: Adding a Button to switch cards
		 */
		JPanel buttonPanel = new JPanel();
		JButton button = new JButton("Karten wechseln");
		buttonPanel.add(button);
		
		button.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(currentCard == 1)
				{
					currentCard++;
				} else if(currentCard == 2) currentCard = 1;
				
				wbCardLayout.show(cardPanel, "" +(currentCard));
			}
		});
				
		
		//Add components to framePanel
		framePanel.add(buttonPanel, java.awt.BorderLayout.PAGE_START);
		framePanel.add(text, java.awt.BorderLayout.CENTER);
		framePanel.add(cardPanel, java.awt.BorderLayout.PAGE_END);
		
		this.add(framePanel);
	}
}
