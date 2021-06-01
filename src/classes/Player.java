package classes;

public class Player extends Lifeform //Subclass of Lifeform
{
	private String name;
	private int levelCap;
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setLevelCap(int levelCap)
	{
		this.levelCap = levelCap;
	}
	
	public int getLevelCap()
	{
		return levelCap;
	}
	
	/*
	 * profile() is a method which will show the Information of the Player
	 */
	public void profile()
	{
		if(getExperience() >= getLevelCap())
		{
			levelUp();
		}
		else if(getDeath() == true)
		{
			System.out.println("Status: Dead");
		}
		
		System.out.println("Name: " +name +" Level: " +getLevel());
		System.out.printf("Life: %d(%d) Stamina: %d(%d) \n", getLife(), getMaxLife(), getStamina(), getMaxStamina());
		System.out.printf("Damage: %d Experience: %d(%d) \n", getDamage(), getExperience(), getLevelCap());
	}
	
	//Method for leveling up
	public void levelUp()
	{
		do
		{
			setLevel(getLevel() + 1);
			setExperience(getExperience() - getLevelCap());
			setLevelCap((int)(getLevelCap() * 1.2));
			setMaxLife((int)(getMaxLife() * 1.2));
			setMaxStamina((int)(getMaxStamina() * 1.2));
			setDamage((int)(getDamage() * 1.2));
			System.out.println("Glückwunsch, du bist im Level gestiegen\n");
		}while(getExperience() >= getLevelCap());
	}
}
