package game;

import javax.swing.JOptionPane;


public class Battle 
{
	//private String text;
	
	public void battle(classes.Player myPlayer)
	{
		
		classes.Monster monster01 = new classes.Monster();
		monster01.setType("Boar");
		monster01.setLevel(1);
		monster01.setLife(50);
		monster01.setStamina(30);
		monster01.setDamage(5);
		monster01.setExperience(10);
		//monster01.profile();
		System.out.println("\n");
		
		/*
		 *  fight between Player and Monster with Playeroptions
		 */
		boolean getAway = false;
		boolean goOn = true;
		String selection = "";
		
		do
		{
			selection = JOptionPane.showInputDialog("Wähle: \nAngriff: 1, Ausruhen: 2, Fliehen: 3");
			
			switch(selection)
			{
				case "1": 	attack(myPlayer, monster01);
							//return text;
					break;
				case "2": 	myPlayer.rest();
							myPlayer.receiveDamage(monster01.getDamage());
							System.out.println("Du wurdest vom gegnerischen Angriff getroffen. \nRestleben: " +myPlayer.getLife());
							//text = "Du wurdest vom gegnerischen Angriff getroffen. \nRestleben: " +myPlayer.getLife();
							//return text;
					break;
				case "3":	getAway = escape();
							if(getAway == true)
							{
								goOn = false;
								System.out.println("Flucht erfolgreich");
							} else 
							{
								myPlayer.receiveDamage(monster01.getDamage());
								System.out.println("nicht erfolgreich \nDu wurdest vom gegnerischen Angriff getroffen. \nRestleben: " +myPlayer.getLife());
							}
					break;
				default: 	System.out.println("Bitte nur zwischen Angegebenem wählen");
			}
			
			//Test if one is death
			if(myPlayer.getDeath() == true)
			{
				goOn = false;
			} else if(monster01.getDeath() == true)
			{
				System.out.printf("Du hast gewonnen und erhältst %d Erfahrungspunkte \n\n" ,monster01.getExperience());
				goOn = false;
			}
			
		}while(goOn == true);
		
		// Player still alive and dind't escape, then he gets experience
		if(myPlayer.getDeath()==false && getAway ==false) myPlayer.receiveExperience(monster01.getExperience());
		
		// change getAway to default!
		getAway = false;
		goOn = true;
		//return text;
	}
	
	public String attack(classes.Player myPlayer, classes.Monster monster01)
	{
		monster01.receiveDamage(myPlayer.giveDamage());
		if(monster01.getDeath() == false) myPlayer.receiveDamage(monster01.giveDamage());
		System.out.println("Restleben Player: " +myPlayer.getLife() +"\nRestausdauer Player: " +myPlayer.getStamina()
				+"\nRestleben Monster: " +monster01.getLife() +"\n");
		String text = "Restleben Player: " +myPlayer.getLife() +"\nRestausdauer Player: " +myPlayer.getStamina()
		+"\nRestleben Monster: " +monster01.getLife() +"\n";
		return text;
	}
	
	public boolean escape()
	{
		boolean getAway = false;
		
		// You have a chance of 66% to escape the battle
		int chance = (int)Math.round((Math.random()*99)+1);
		if(chance >= 33) getAway = true;
		
		return getAway;
	}
}
