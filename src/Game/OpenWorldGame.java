package Game;

import Classes.Monster;
import Classes.Player;
import GUI.MainWindow;

public class OpenWorldGame {

    Classes.Monster monster = new Monster();
    Game.Battle battle = new Battle();
    MainWindow mainWindow;

    private Classes.Player myPlayer = new Player();

    private final float levelUpBonus = 1.2f;
    private final int multiplier = 10;
    private final int level = 1;
    private final int experienceCap = 50;
    private final int experience = 0;

    private String text = "";
    private String textSaveGame = "";

    public void gameStart() {
        int width = 800;
        int height = 600;
        mainWindow = new MainWindow(this, width, height, 1);
    }

    public void openWorldGame(String name, String sex, int life, int stamina, int damage, int width, int height) {

        life *= multiplier;
        stamina *= multiplier;
        int maxLife = life;
        int maxStamina = stamina;


        myPlayer.setName(name);
        myPlayer.setSex(sex);
        myPlayer.setLevel(level);
        myPlayer.setLevelUpBonus(levelUpBonus);
        myPlayer.setMaxLife(maxLife);
        myPlayer.setLife(life);
        myPlayer.setMaxStamina(maxStamina);
        myPlayer.setStamina(stamina);
        myPlayer.setExperienceCap(experienceCap);
        myPlayer.setExperience(experience);
        myPlayer.setDamage(damage);

        mainWindow = new MainWindow(this, width, height, 4);
        mainWindow.setGameStart(true);
        mainWindow.changeTextOpenWorld(myPlayer.profile());
    }

    //Erholen als nächste Aufgabe!

    public void doRest(String place) {

        if(place.equals("openWorldRest")) mainWindow.changeTextOpenWorld(myPlayer.rest(place));
        else if(place.equals("battle")){
            text = battle.recover();
            mainWindow.changeTextBattle(text);
        }
    }

    public boolean getProfile() {
        if(!myPlayer.isDeath()) mainWindow.changeTextOpenWorld(myPlayer.profile());
        if(myPlayer.getLevel() >= 3) mainWindow.youWon();
        return myPlayer.isDeath();

        // -> als nächstes Spieler gewinnt ab lvl 3
    }

    public void encounter() {
        this.battle = new Battle();

        monster = battle.battle(myPlayer);

        text = "Sie begegnen einem " + monster.getType();

        if(monster.getLevel() <= myPlayer.getLevel()) text += "\nSie fühlen sich dem Monster gewachsen.";
        else text += "\nSie fühlen sich vom Monster eingeschüchtert.";

        text += "\n\nWas möchtest du machen?";

        mainWindow.changeTextBattle(text);
    }

    public void attack() {

        if(!myPlayer.isDeath() && !monster.isDeath()){
            text = battle.fight();
            if(!monster.isDeath()){
                text += "\n\nWas möchtest du machen?";
                mainWindow.changeTextBattle(text);
            } else
            {
                myPlayer.receiveExperience(monster.getExperience());
                text += "\nRestleben: " + myPlayer.getLife() + " Restausdauer: " + myPlayer.getStamina();
                text += "\nDu hast " + monster.getExperience() + " Erfahrungspunkte erhalten.";
                endBattle(text);
            }
        }

        if(myPlayer.isDeath()){
            mainWindow.youLost();
        }
    }

    public void endBattle(String text) {
        mainWindow.battleEnd(text);
    }

    public void tryEscape() {
        int chance = Math.toIntExact(Math.round((Math.random()) * 5)) + 1;
        if (chance <= 4) mainWindow.escaped();
        else{
            text = battle.notEscaped();
            mainWindow.changeTextBattle(text);
        }
    }

    public void block() {
        text = battle.attackBlocked();
        mainWindow.changeTextBattle(text);
        mainWindow.monsterAttackBlocked(true);
    }

    public void counterAttack() {
        text = battle.attackCountered();
        mainWindow.monsterAttackBlocked(false);
        if(monster.isDeath()){
            myPlayer.receiveExperience(monster.getExperience());
            text += "\nRestleben: " + myPlayer.getLife() + " Restausdauer: " + myPlayer.getStamina();
            text += "\nDu hast " + monster.getExperience() + " Erfahrungspunkte erhalten.";
            text += "\n\nWas möchtest du machen?";
            endBattle(text);
        } else{
            text += "\n\nWas möchtest du machen?";
            mainWindow.changeTextBattle(text);
        }
    }

    public String saveMyGame(int i) {
        text = myPlayer.getName() +" Level: ";
        text += myPlayer.getLevel() + " Erfahrung: ";
        text += myPlayer.getExperience();

        createTextSaveGame();

        SaveGame saveGame = new SaveGame();
        saveGame.SaveMyGame(textSaveGame, i);

        mainWindow.changeTextLoadPanel(text, i);

        return text;
    }

    private void createTextSaveGame() {
        textSaveGame = myPlayer.getName() +";";
        textSaveGame += myPlayer.getSex() +";";
        textSaveGame += myPlayer.getLevel() +";";
        textSaveGame += myPlayer.getMaxLife() +";";
        textSaveGame += myPlayer.getLife() +";";
        textSaveGame += myPlayer.getMaxStamina() +";";
        textSaveGame += myPlayer.getStamina() +";";
        textSaveGame += myPlayer.getExperienceCap() +";";
        textSaveGame += myPlayer.getExperience() +";";
        textSaveGame += myPlayer.getDamage();
    }

    public void loadMyGame(int i, int width, int height) {
        SaveGame saveGame = new SaveGame();
        textSaveGame = saveGame.loadMyGame(i);

        if(textSaveGame=="noGame"){
            mainWindow = new MainWindow(this, width, height, 9);
            return;
        }

        loadMyPlayer(textSaveGame, width, height);

        if(myPlayer.isDeath()) myPlayer.setDeath(false);
        mainWindow.setGameStart(true);
    }

    private void loadMyPlayer(String textSaveGame, int width, int height) {

        String[] myPlayerString = textSaveGame.split(";");

        myPlayer.setName(myPlayerString[0]);
        myPlayer.setSex(myPlayerString[1]);
        myPlayer.setLevel(Integer.parseInt(myPlayerString[2]));
        myPlayer.setLevelUpBonus(levelUpBonus);
        myPlayer.setMaxLife(Integer.parseInt(myPlayerString[3]));
        myPlayer.setLife(Integer.parseInt(myPlayerString[4]));
        myPlayer.setMaxStamina(Integer.parseInt(myPlayerString[5]));
        myPlayer.setStamina(Integer.parseInt(myPlayerString[6]));
        myPlayer.setExperienceCap(Integer.parseInt(myPlayerString[7]));
        myPlayer.setExperience(Integer.parseInt(myPlayerString[8]));
        myPlayer.setDamage(Integer.parseInt(myPlayerString[9]));

        if(myPlayer.isDeath()) myPlayer.setDeath(false);

        mainWindow = new MainWindow(this, width, height, 4);
        mainWindow.changeTextOpenWorld(myPlayer.profile());
    }
}