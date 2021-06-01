package GUI;

import Game.OpenWorldGame;
import Game.SaveGame;

import javax.swing.*;
import java.awt.*;

import static javax.swing.BorderFactory.createEmptyBorder;

public class LoadPanel {

    private final Font TITLE_FONT = new Font("Verdana", Font.BOLD, 35); //Custom made Font
    private final Font BACK_BUTTON_FONT = new Font("Verdana", Font.BOLD, 25);
    private final Font BUTTON_FONT = new Font("Verdana", Font.BOLD, 25); //Custom made Font
    private final Color MAIN_WINDOW_BACKGROUND_COLOR = Color.white;
    private final Color MAIN_WINDOW_FOREGROUND_COLOR = Color.black;

    private final JLabel loadTitle = new JLabel("LADEN");
    private final JButton backButton = new JButton("Zurück");

    private JButton load1Button = new JButton("Spielstand 1");
    private JButton load2Button = new JButton("Spielstand 2");
    private JButton load3Button = new JButton("Spielstand 3");

    private BorderLayout menuWindowLayout;
    private GridLayout chooseButtonGridLayout;
    private FlowLayout backButtonFlowLayout, titlePanelFlowLayout;

    private JPanel loadPanel, titlePanel, centerWindowPanel, backButtonPanel;

    private boolean load = false;
    private int topPanelHeight, bottomPanelHeight;

    public JPanel LoadPanel(OpenWorldGame openWorldGame, JFrame baseFrame, CardLayout cardLayout, JPanel cardPanel, int width, int height){

        loadPanel = new JPanel();
        loadPanel.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        menuWindowLayout = new BorderLayout();
        loadPanel.setLayout(menuWindowLayout);

        /**
         * Add the title
         * BorderLayout PAGE_START
         */

        titlePanel = new JPanel();
        titlePanel.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        titlePanelFlowLayout = new FlowLayout();
        titlePanelFlowLayout.setAlignment(FlowLayout.LEFT);
        titlePanel.setLayout(titlePanelFlowLayout);
        topPanelHeight = Math.round(height * 0.07f);
        titlePanel.setPreferredSize(new Dimension(width, topPanelHeight));

        loadTitle.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        loadTitle.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        loadTitle.setFont(TITLE_FONT);
        loadTitle.setBorder(createEmptyBorder());
        loadTitle.setSize(100, topPanelHeight);

        titlePanel.add(loadTitle);


        /**
         * Check if there are saveFiles
         * each is individually checked
         */

        SaveGame saveGame = new SaveGame();

        load = saveGame.FolderExists();
        if(load){
            for (int i = 1; i <= 3; i++) {
                load = saveGame.SaveExists(i);
                if(load) changeText(i, "Spielstand " +i);
                else changeText(i, "Kein Spielstand");
            }
        } else{
            load1Button.setText("Kein Spielstand");
            load2Button.setText("Kein Spielstand");
            load3Button.setText("Kein Spielstand");
        }


        /**
         * Add the different Buttons
         * load1Button, load2Button, load3Button
         * BorderLayout CENTER
         */

        centerWindowPanel = new JPanel();
        centerWindowPanel.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        chooseButtonGridLayout = new GridLayout(3, 1);
        centerWindowPanel.setLayout(chooseButtonGridLayout);

        //Add the load1Button
        load1Button.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        load1Button.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        load1Button.setFont(BUTTON_FONT);
        load1Button.setBorder(createEmptyBorder());
        load1Button.setFocusPainted(false);
        load1Button.addActionListener(e -> {
            openWorldGame.loadMyGame(1, width, height);
            baseFrame.dispose();
        });

        //Add the load2Button
        load2Button.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        load2Button.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        load2Button.setFont(BUTTON_FONT);
        load2Button.setBorder(createEmptyBorder());
        load2Button.setFocusPainted(false);
        load2Button.addActionListener(e -> {
                openWorldGame.loadMyGame(2, width, height);
                baseFrame.dispose();
        });

        //Add the load3Button
        load3Button.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        load3Button.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        load3Button.setFont(BUTTON_FONT);
        load3Button.setBorder(createEmptyBorder());
        load3Button.setFocusPainted(false);
        load3Button.addActionListener(e -> {
            openWorldGame.loadMyGame(3, width, height);
            baseFrame.dispose();
        });

        //Add the three buttons above to the panel
        centerWindowPanel.add(load1Button);
        centerWindowPanel.add(load2Button);
        centerWindowPanel.add(load3Button);


        /**
         * Add the backButton
         * BorderLayout PAGE_END
         */

        backButtonPanel = new JPanel();
        backButtonPanel.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        backButtonFlowLayout = new FlowLayout();
        backButtonFlowLayout.setAlignment(FlowLayout.LEFT);
        backButtonPanel.setLayout(backButtonFlowLayout);
        bottomPanelHeight = Math.round(height * 0.07f);
        backButtonPanel.setPreferredSize(new Dimension(width, bottomPanelHeight));

        backButton.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        backButton.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        backButton.setFont(BACK_BUTTON_FONT);
        backButton.setBorder(createEmptyBorder());
        backButton.setSize(100,topPanelHeight);
        backButton.setFocusPainted(false);
        backButton.addActionListener(e -> cardLayout.show(cardPanel, "7"));

        backButtonPanel.add(backButton);

        /**
         * Add the three main Panels, title, center and back together
         * return the menuPanel
         */

        loadPanel.add(titlePanel, BorderLayout.PAGE_START);
        loadPanel.add(backButtonPanel, BorderLayout.PAGE_END);
        loadPanel.add(centerWindowPanel, BorderLayout.CENTER);

        return loadPanel;
    }

    public void changeText(int i, String text) {

        switch(i) {
            case 1: load1Button.setText(text);
                break;
            case 2: load2Button.setText(text);
                break;
            case 3: load3Button.setText(text);
        }
    }
}
