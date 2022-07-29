package Classes;

public class Player extends SClassCreature {

    private String name;
    private String sex;
    private float levelUpBonus = 1.2f;
    private int experienceCap;

    public float getLevelUpBonus() {
        return levelUpBonus;
    }

    public void setLevelUpBonus(float levelUpBonus){
        this.levelUpBonus = levelUpBonus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getExperienceCap() {
        return experienceCap;
    }

    public void setExperienceCap(int experienceCap) {
        this.experienceCap = experienceCap;
    }

    /**
     * A Method to show the Information of a Player
     * Will also trigger the levelUP() event
     * @return
     */
    public String profile() {
        String text = "Ihr Profil:\n";

        if (getExperience() >= getExperienceCap()) {
            text += levelUp();
        } else if (isDeath() || getLife() <= 0) {
            text = "Status: Dead";
            setDeath(true);
        }

        if (!isDeath()){
            text += "Name: " + getName() + "\nGeschlecht: " +getSex() + "\nLevel: " + getLevel() +"\n\n";
            text += "Life: "+getLife()+"(" +getMaxLife()+") Stamina: "+getStamina()+"("+getMaxStamina()+")\n";
            text += "Damage: "+getDamage()+" Experience: " +getExperience() +"(" +getExperienceCap() +")\n\n\nWas möchtest du machen?";
        }

        return text;
    }

    private String levelUp() {

        String text = "";
        int anzahl = 0;

        do {
            setLevel(getLevel() + 1);
            setExperience(getExperience() - getExperienceCap());
            setExperienceCap(Math.round(getExperienceCap() * getLevelUpBonus()));
            setMaxLife(Math.round(getMaxLife() * getLevelUpBonus()));
            setMaxStamina(Math.round(getMaxStamina() * getLevelUpBonus()));
            setDamage(Math.round(getDamage() * getLevelUpBonus()));
            setTired(true);
            anzahl++;
        } while (getExperience() >= getExperienceCap());

        if(anzahl != 0) text = "Glückwunsch, du bist "+anzahl +"-mal im Level gestiegen\n";

        return text;
    }
}
