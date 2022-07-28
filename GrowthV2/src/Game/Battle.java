package Game;

import Classes.Monster;
import Classes.Player;

public class Battle {

    Classes.Monster monster;
    Classes.Player myPlayer;

    private String monsterType = "Goblin";
    private String text = "test";
    private String place = "battle";
    private boolean recover = false;
    private int monsterLevel = 1;
    private int maxLife = 50;
    private int maxStamina = 30;
    private int staminaLoss = 8;
    private int experience = 10;
    private int damage = 15;


    public Monster battle(Player myPlayer) {

        this.monster = new Classes.Monster();
        this.myPlayer = myPlayer;

        monster.setType(monsterType);
        monster.setLevel(monsterLevel);
        monster.setMaxLife(maxLife);
        monster.setLife(maxLife);
        monster.setMaxStamina(maxStamina);
        monster.setStamina(maxStamina);
        monster.setStaminaLoss(staminaLoss);
        monster.setExperience(experience);
        monster.setDamage(damage);

        return monster;
    }

    public String fight() {

        place = "battle";
        text = "";

        if(this.myPlayer.getStamina() >= this.myPlayer.getStaminaLoss() && !recover){
            text += this.myPlayer.giveDamage(this.myPlayer.getName());
            text += monster.receiveDamage(monster.getType(), this.myPlayer.getDamage());
        }else if(this.myPlayer.getStamina() <= this.myPlayer.getStaminaLoss() || recover){
            if(recover) text = "Du erholst dich.\n";
            else text = "Du hast nicht genug ausdauer.\nDu erholst dich.\n";
            this.myPlayer.rest(place);
            recover = false;
        }

        text += "\n";
        if(!monster.isDeath()){
            if(monster.getStamina() >= monster.getStaminaLoss()) {
                text += monster.giveDamage(monster.getType());
                text += this.myPlayer.receiveDamage(this.myPlayer.getName(), monster.getDamage());
            }else
            {
                text += monster.getType() + " erholt sich.\n";
                monster.rest(place);
            }
        } else text += monster.getType() + " ist tod.\nDu hast gewonnen.\n";

        if(!this.myPlayer.isDeath() && !monster.isDeath()) text += "\nRestleben: " + this.myPlayer.getLife() + " Restausdauer: " + myPlayer.getStamina();

        return text;
    }

    public String recover() {
        recover = true;
        text = fight();

        return text;
    }

    public String notEscaped() {
        place = "battle";
        text = "Flucht fehlgeschlagen!\n";

        if(monster.getStamina() >= monster.getStaminaLoss()) {
            text += monster.giveDamage(monster.getType());
            text += this.myPlayer.receiveDamage(this.myPlayer.getName(), monster.getDamage());
        }else
        {
            text += monster.getType() + " erholt sich.\n";
            monster.rest(place);
        }

        if(!this.myPlayer.isDeath() && !monster.isDeath()) text += "\nRestleben: " + this.myPlayer.getLife() + " Restausdauer: " + myPlayer.getStamina();

        return text;
    }

    public String attackBlocked() {
        place = "battle";
        text = "Du blockst den Angriff von " + monster.getType() +"\n";

        if(monster.getStamina() >= monster.getStaminaLoss()) {
            monster.giveDamage(monster.getType());
        }else
        {
            text += monster.getType() + " erholt sich.\n";
            monster.rest(place);
        }

        text += "\nRestleben: " + this.myPlayer.getLife() + " Restausdauer: " + this.myPlayer.getStamina();
        return text;
    }

    public String attackCountered() {

        place = "battle";
        text = "";

        if(this.myPlayer.getStamina() >= this.myPlayer.getStaminaLoss() && !recover){
            text += this.myPlayer.giveCounterAttack(monster.getType());
            text += monster.receiveCounterAttackDamage(monster.getType(), this.myPlayer.getDamage());
        }else if(this.myPlayer.getStamina() <= this.myPlayer.getStaminaLoss() || recover){
            text = "Du hast nicht genug ausdauer.\nDu erholst dich.\n";
            this.myPlayer.rest(place);
            recover = false;
        }

        text += "\n";
        if(!monster.isDeath()){
            text += monster.getType() + " wurde schwer getroffen und rappelt sich auf.";
        } else text += monster.getType() + " ist tod.\nDu hast gewonnen.\n";

        if(!this.myPlayer.isDeath() && !monster.isDeath()) text += "\nRestleben: " + this.myPlayer.getLife() + " Restausdauer: " + this.myPlayer.getStamina();

        return text;
    }
}
