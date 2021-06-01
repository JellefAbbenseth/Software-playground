package game;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import java.lang.Math;

@SuppressWarnings("unused")
public class Game 
{
	public void game(classes.Player myPlayer)
	{
		//boolean does the game continue
		boolean loose = false;
		
		/*
		 * Start GameWindow
		 *//*
		GUI.GameWindow gameWindow = new GUI.GameWindow(myPlayer);
		gameWindow.setVisible(true);
		
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run() {
				new GUI.StartWindow();			
			}		
		});*/
		
		
		//Test Übergabewert
		myPlayer.profile();
		
		String selection = "";
		
		//The game, player can play as long as he isn't level 3 or higher or doesn't die
		do
		{
			selection = JOptionPane.showInputDialog("Wähle: \nErforschen: 1, Ausruhen: 2, Profil: 3");
			
			switch(selection)
			{
				case "1": 	System.out.println("Erforschen");
							int dice = (int)Math.round((Math.random()*5)+1);
							
							if(dice <= 3)
							{
								System.out.println("Monsterangriff");
								Battle battle = new Battle();
								battle.battle(myPlayer);
							} else
							{
								System.out.println("Kein Kontakt");
							}
					break;
				case "2": 	System.out.println("Ausruhen");
							myPlayer.rest();
					break;
				case "3": 	System.out.println("Profil");
							myPlayer.profile();
					break;
				default: 	System.out.println("Bitte nur zwischen Angegebenem wählen");
			}
			
			if(myPlayer.getDeath() == true)
			{
				loose = true;
			} else if(myPlayer.getLevel() >= 3) loose = true;
		} while(loose == false);
		
		System.out.println("Game Ends");
		if(myPlayer.getDeath() == false)
		{
			System.out.println("You won!");
		} else System.out.println("You lost!");
	}
}
