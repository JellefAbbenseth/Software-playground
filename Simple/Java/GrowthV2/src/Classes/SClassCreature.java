package Classes;

public class SClassCreature {

    private boolean death = false;
    private boolean tired = false;

    private String text = "";
    private String place;

    private int maxLife;
    private int life;
    private int maxStamina;
    private int stamina;
    private int staminaLoss = 10;
    private int level;
    private int experience;
    private int damage;

    public int getStaminaLoss() {
        return staminaLoss;
    }

    public void setStaminaLoss(int staminaLoss) {
        this.staminaLoss = staminaLoss;
    }

    public boolean isDeath() {
        return death;
    }

    public void setDeath(boolean death) {
        this.death = death;
    }

    public boolean isTired() {
        return tired;
    }

    public void setTired(boolean tired) {
        this.tired = tired;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
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

    /**
     * Let's the Creature rest, it depends on the place
     * @param place
     * @return
     */

    public String rest(String place) {
        this.place = place;
        float multiplierLife = 1.3f;
        float multiplierStamina = 1.5f;

        if (this.place.equals("openWorldRest")) {
            if (isTired()) {
                setLife(getMaxLife());
                setStamina(getMaxStamina());
                setTired(false);
                text = "Du hast dich ausgeruht und bist wieder fit.\n";
            } else text = "Du bist ausgeruht.\n";
        } else{
            if (Math.round(getLife() * multiplierLife) <= getMaxLife()) {
                int life = getLife() + Math.round(getMaxLife() * (multiplierLife - 1));
                setLife(life);
            } else{
                setLife(getMaxLife());
            }
            if (Math.round(getStamina() * multiplierStamina) <= getMaxStamina()) {
                int stamina = getStamina() + Math.round(getMaxStamina() * (multiplierStamina-1));
                setStamina(stamina);
            } else{
                setStamina(getMaxStamina());
            }

            text = "Du hast dich etwas erholt.\n";
        }

        text += "Life: " + getLife() + "(" + getMaxLife() + ") Stamina: " + getStamina() + "(" + getMaxStamina() + ")\n";
        text += "\nWas möchtest du machen?";

        return text;
    }

    public String giveDamage(String nameAttacker) {

        text = nameAttacker +" greift an.\n";
        setStamina(getStamina() - getStaminaLoss());
        setTired(true);

        return text;
    }

    public String receiveDamage(String nameReceiver, int damage) {

        text = nameReceiver +" erleidet " +damage +" Schaden\n";

        setLife(this.getLife() - damage);
        setTired(true);

        if(this.getLife() <= 0) this.setDeath(true);

        return text;
    }

    public void receiveExperience(int experience) {
        experience = getExperience() + experience;
        setExperience(experience);
    }

    public String giveCounterAttack(String nameReceiver) {
        text = "Du konterst den Angriff von " +nameReceiver +"\n";
        setStamina(getStamina() - Math.round(getStaminaLoss()/2.0f));
        setTired(true);

        return text;
    }

    public String receiveCounterAttackDamage(String nameReceiver, int damage) {

        text = nameReceiver +" erleidet " +(damage * 3) +" Schaden\n";

        setLife(this.getLife() - damage * 3);
        setTired(true);

        if(this.getLife() <= 0) this.setDeath(true);

        return text;
    }
}
