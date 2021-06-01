package classes;

public class Lifeform // Superclass
{
	private boolean death = false;
	private boolean tired = false;
	private int maxLife;
	private int life;
	private int maxStamina;
	private int stamina;
	private int level;
	private int experience;
	private int damage;
	
	// Constructors
	
	public void setDeath(boolean death)
	{
		this.death = death;
	}
	
	public boolean getDeath()
	{
		return death;
	}
	
	public void setTired(boolean tired)
	{
		this.tired = tired;
	}
	
	public boolean getTired()
	{
		return tired;
	}
	
	public void setMaxLife(int maxLife)
	{
		this.maxLife = maxLife;
	}
	
	public int getMaxLife()
	{
		return maxLife;
	}
	
	public void setLife(int life)
	{
		this.life = life;
	}
	
	public int getLife()
	{
		return life;
	}
	
	public int getMaxStamina() {
		return maxStamina;
	}

	public void setMaxStamina(int maxStamina) {
		this.maxStamina = maxStamina;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	// Methods
	
	public int giveDamage()
	{
		if(stamina <= 0)
		{
			rest();
			return 0;
		} else
		{
			stamina -= 10;
			return damage;
		}
	}
	
	public boolean receiveDamage(int damage)
	{
		life -= damage;
		tired = true;
		
		if(life <= 0) 
		{
			death = true;
			life = 0;
			stamina = 0;
		}
		return death;
	}
	
	public boolean rest()
	{
		if(life <= maxLife || stamina >= maxStamina)
		{
			life = maxLife; stamina = maxStamina;
			tired = false;
			System.out.println("Du hast dich ausgeruht und bist wieder fit. \n");
		} else
		{
			System.out.println("Du bist ausgeruht");
		}
		return tired;
	}
	
	public void receiveExperience(int exp)
	{
		this.experience += exp;
	}
}
