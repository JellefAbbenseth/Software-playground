package GUI;

import Game.OpenWorldGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {

    GUI.OpenWorldPanel openWorldPanel = new GUI.OpenWorldPanel();
    GUI.BattlePanel battlePanel = new GUI.BattlePanel();
    GUI.LoadPanel loadPanel;
    Game.OpenWorldGame openWorldGame;
    ChoiceHandler cHandler = new ChoiceHandler();
    GUI.EndPanel endPanel;

    //Variablen
    private JFrame baseFrame;
    private Container baseContainer;
    private JPanel cardPanel;

    //Panels for the different cards/windows
    private JPanel startWindow, helpWindow, charCreationWindow, openWorldWindow, endWindow, battleWindow,
    menuWindow, saveWindow, loadWindow, resizeWindowWindow;
    private CardLayout cardLayout;

    public boolean isGameStart() {
        return gameStart;
    }

    public void setGameStart(boolean gameStart) {
        this.gameStart = gameStart;
    }

    private boolean gameStart = false;


    public MainWindow(OpenWorldGame openWorldGame, int width, int height, int actualCard) {

        this.openWorldGame = openWorldGame;

        baseFrame = new JFrame();
        baseFrame.setSize(width,height);
        baseFrame.setLocationRelativeTo(null);  //Start location in the middle of the screen
        baseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        baseFrame.getContentPane().setBackground(Color.white);
        baseFrame.setLayout(null);  //Deactivate the standard Layout
        baseFrame.setResizable(false);  //Deactivates the ability to resize the Window.
        baseContainer = baseFrame.getContentPane();
        baseContainer.setLayout(new FlowLayout());


        /*
            Create the cards as tests with different colors
         */
        cardLayout = new CardLayout();
        cardPanel = new JPanel();
        cardPanel.setLayout(cardLayout);

        GUI.StartPanel startPanel = new GUI.StartPanel();
        startWindow = startPanel.StartPanel(cardLayout, cardPanel);
        GUI.HelpPanel helpPanel = new GUI.HelpPanel();
        helpWindow = helpPanel.HelpPanel(width, height, cardLayout, cardPanel);
        GUI.CharCreationPanel charCreationPanel = new GUI.CharCreationPanel();
        charCreationWindow = charCreationPanel.charCreationPanel(baseFrame, cardLayout, cardPanel, width, height);
        openWorldWindow = openWorldPanel.openWorldPanel(cHandler,cardLayout, cardPanel, width, height);
        endPanel = new GUI.EndPanel();
        endWindow = endPanel.EndPanel(cardLayout, cardPanel, width, height);
        battleWindow = battlePanel.BattlePanel(cHandler ,cardLayout, cardPanel, width, height);
        GUI.MenuPanel menuPanel = new GUI.MenuPanel();
        menuWindow = menuPanel.MenuPanel(this, cardLayout, cardPanel, width, height);
        GUI.SavePanel savePanel = new GUI.SavePanel();
        saveWindow = savePanel.SavePanel(openWorldGame, cardLayout, cardPanel, width, height);
        loadPanel = new GUI.LoadPanel();
        loadWindow = loadPanel.LoadPanel(openWorldGame, baseFrame, cardLayout, cardPanel, width, height);
        GUI.WindowSizePanel windowSizePanel = new GUI.WindowSizePanel();
        resizeWindowWindow = windowSizePanel.WindowSizePanel(openWorldGame, baseFrame, cardLayout, cardPanel, width, height);

        cardPanel.add(startWindow, "1");
        cardPanel.add(helpWindow, "2");
        cardPanel.add(charCreationWindow, "3");
        cardPanel.add(openWorldWindow, "4");
        cardPanel.add(endWindow, "5");
        cardPanel.add(battleWindow, "6");
        cardPanel.add(menuWindow, "7");
        cardPanel.add(saveWindow, "8");
        cardPanel.add(loadWindow, "9");
        cardPanel.add(resizeWindowWindow, "10");

        baseContainer.add(cardPanel);

        //Set the given card visible
        cardLayout.show(cardPanel, "" +actualCard);

        //Make the window visible
        baseFrame.setVisible(true);
    }

    public void changeTextOpenWorld(String text) {
        openWorldPanel.setText(text);
    }

    public void changeTextBattle(String text) {
        battlePanel.setText(text);
    }

    public void youLost() {
        endPanel.lost();
        cardLayout.show(cardPanel, "5");
        setGameStart(false);
    }

    public void youWon() {
        cardLayout.show(cardPanel, "5");
        setGameStart(false);
    }

    public void battleEnd(String text) {
        cardLayout.show(cardPanel, "4");
        openWorldPanel.setText(text);
    }

    public void escaped() {
        cardLayout.show(cardPanel, "4");
        openWorldPanel.setText("Du bist erfolgreich entkommen.\n\nWas möchtest du machen?");
    }

    public void monsterAttackBlocked(boolean isBlocked) {
        if(isBlocked) BattlePanel.counter(true);
        else BattlePanel.counter(false);
    }

    public void changeTextLoadPanel(String text, int i) {
        loadPanel.changeText(i, text);
    }

    public class ChoiceHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();

            switch (yourChoice) {
                case "Ausruhen":
                    openWorldGame.doRest("openWorldRest");
                    break;
                case "Erkunden":
                    int chance = Math.toIntExact(Math.round((Math.random()) * 5)) + 1;
                    if (chance <= 4){
                        openWorldGame.encounter();
                        cardLayout.show(cardPanel, "6");
                    } else changeTextOpenWorld("Das Erkunden war ereignislos.\n\nWas möchtest du machen?");
                    break;
                case "Profil":
                    boolean dead = openWorldGame.getProfile();
                    if(dead){
                        youLost();
                        cardLayout.show(cardPanel, "5");
                    }
                    break;
                case "Angriff":
                    openWorldGame.attack();
                    break;
                case "Konter":
                    openWorldGame.counterAttack();
                    break;
                case "Blocken":
                    openWorldGame.block();
                    break;
                case "Erholen":
                    openWorldGame.doRest("battle");
                    break;
                case "Fliehen":
                    openWorldGame.tryEscape();
                    break;
            }
        }

    }
}
