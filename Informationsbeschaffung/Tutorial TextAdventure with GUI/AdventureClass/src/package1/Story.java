package package1;

import package2.WeaponLongSword;

public class Story
{
    Game game;
    UI ui;
    VisibilityManager vm;
    Player player = new Player();

    public Story(Game g, UI userInterface, VisibilityManager vManager)
    {
        game = g;
        ui = userInterface;
        vm = vManager;
    }

    public void defaultSetup()
    {
        player.hp = 10;
        ui.hpNumberLabel.setText("" +player.hp);

        player.currentWeapon = new package2.WeaponKnife();
        ui.weaponNameLabel.setText(player.currentWeapon.getName());
    }

    public void selectPosition(String nextPosition)
    {
        switch(nextPosition)
        {
            case "townGate": townGate(); break;
            case "talkGuard": talkGuard(); break;
            case "attackGuard": attackGuard(); break;
            case "crossRoad": crossRoad(); break;
            case "north": north(); break;
            case "east": east(); break;
            case "west": west(); break;
        }
    }

    public void townGate()
    {
        ui.mainTextArea.setText("You are at the gate of the town. \nA guard is standing in front of you.\n\nWhat do oyu do?");
        ui.choice1.setText("Talk to the guard");
        ui.choice2.setText("Attack the guard");
        ui.choice3.setText("leave");
        ui.choice4.setText("");

        game.nextPosition1 = "talkGuard";
        game.nextPosition2 = "attackGuard";
        game.nextPosition3 = "crossRoad";
        game.nextPosition4 = "";
    }

    public void talkGuard()
    {
        ui.mainTextArea.setText("Guard: Hello stranger. I have never seen your face. ...");
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "townGate";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void attackGuard()
    {
        ui.mainTextArea.setText("Guard: Hey don't be stupid! ...");
        player.hp = player.hp - 3;
        ui.hpNumberLabel.setText("" +player.hp);
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "townGate";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void crossRoad()
    {
        ui.mainTextArea.setText("You are at a crossroad. ...");
        ui.choice1.setText("Go north");
        ui.choice2.setText("Go east");
        ui.choice3.setText("Go south");
        ui.choice4.setText("Go west");

        game.nextPosition1 = "north";
        game.nextPosition2 = "east";
        game.nextPosition3 = "townGate";
        game.nextPosition4 = "west";
    }

    public void north()
    {
        ui.mainTextArea.setText("There is a river. ...");
        player.hp = player.hp + 2;
        ui.hpNumberLabel.setText("" +player.hp);
        ui.choice1.setText("Go south");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "crossRoad";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void east()
    {
        ui.mainTextArea.setText("You walked into ...");
        player.currentWeapon = new WeaponLongSword();
        ui.weaponNameLabel.setText(player.currentWeapon.getName());
        ui.choice1.setText("Go west");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "crossRoad";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void west()
    {
        ui.mainTextArea.setText("You are at a crossroad. ...");
        ui.choice1.setText("");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
}
