package classes;

public class Monster extends Lifeform // Subclass from Lifeform
{
	private String type;
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	public String getType()
	{
		return type;
	}
	
	public void profile()
	{
		System.out.println("Type: " +type +" Level: " +getLevel());
		System.out.printf("Life: %d Stamina: %d \n", getLife(), getStamina());
		System.out.printf("Damage: %d Experience: %d \n", getDamage(), getExperience());
	}
}
