package game;

public class CreateChar 
{
	public void createChar(String name)
	{
		classes.Player myPlayer = new classes.Player();
		myPlayer.setName(name);
		myPlayer.setLife(100);
		myPlayer.setMaxLife(myPlayer.getLife());
		myPlayer.setStamina(100);
		myPlayer.setMaxStamina(myPlayer.getStamina());
		myPlayer.setLevel(1);
		myPlayer.setLevelCap(50);
		myPlayer.setExperience(0);
		myPlayer.setDamage(20);
		
		//myPlayer.profile();
		Game game = new Game();
		game.game(myPlayer);
	}
}
