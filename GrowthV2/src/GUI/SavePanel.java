package GUI;

import Game.OpenWorldGame;
import Game.SaveGame;

import javax.swing.*;
import java.awt.*;

import static javax.swing.BorderFactory.createEmptyBorder;

public class SavePanel {

    private final Font TITLE_FONT = new Font("Verdana", Font.BOLD, 35); //Custom made Font
    private final Font BACK_BUTTON_FONT = new Font("Verdana", Font.BOLD, 25);
    private final Font BUTTON_FONT = new Font("Verdana", Font.BOLD, 25); //Custom made Font
    private final Color MAIN_WINDOW_BACKGROUND_COLOR = Color.white;
    private final Color MAIN_WINDOW_FOREGROUND_COLOR = Color.black;

    private final JLabel saveTitle = new JLabel("SPEICHERN");
    private final JButton backButton = new JButton("Zurück");

    private JButton save1Button = new JButton("Spielstand 1");
    private JButton save2Button = new JButton("Spielstand 2");
    private JButton save3Button = new JButton("Spielstand 3");

    private BorderLayout menuWindowLayout;
    private GridLayout chooseButtonGridLayout;
    private FlowLayout backButtonFlowLayout, titlePanelFlowLayout;

    private JPanel savePanel, titlePanel, centerWindowPanel, backButtonPanel;

    private boolean load = false;
    private int topPanelHeight, bottomPanelHeight;

    public JPanel SavePanel(OpenWorldGame openWorldGame, CardLayout cardLayout, JPanel cardPanel, int width, int height){

        savePanel = new JPanel();
        savePanel.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        menuWindowLayout = new BorderLayout();
        savePanel.setLayout(menuWindowLayout);

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

        saveTitle.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        saveTitle.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        saveTitle.setFont(TITLE_FONT);
        saveTitle.setBorder(createEmptyBorder());
        saveTitle.setSize(100, topPanelHeight);

        titlePanel.add(saveTitle);

        /**
         * Check if there are saveFiles
         * each is individually checked
         */

        SaveGame saveGame = new SaveGame();

        load = saveGame.FolderExists();
        if (load) {
            for (int i = 1; i <= 3; i++) {
                load = saveGame.SaveExists(i);
                if(load) changeText(i, "Spielstand " +i);
                else changeText(i, "Kein Spielstand");
            }
        } else{
            save1Button.setText("Kein Spielstand");
            save2Button.setText("Kein Spielstand");
            save3Button.setText("Kein Spielstand");
        }


        /**
         * Add the different Buttons
         * SaveButton, loadButton, windowSizeButton
         * BorderLayout CENTER
         */

        centerWindowPanel = new JPanel();
        centerWindowPanel.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        chooseButtonGridLayout = new GridLayout(3, 1);
        centerWindowPanel.setLayout(chooseButtonGridLayout);

        //Add the save1Button
        save1Button.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        save1Button.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        save1Button.setFont(BUTTON_FONT);
        save1Button.setBorder(createEmptyBorder());
        save1Button.setFocusPainted(false);
        save1Button.addActionListener(e -> {
            String text = openWorldGame.saveMyGame(1);
            save1Button.setText(text);
        });

        //Add the save2Button
        save2Button.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        save2Button.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        save2Button.setFont(BUTTON_FONT);
        save2Button.setBorder(createEmptyBorder());
        save2Button.setFocusPainted(false);
        save2Button.addActionListener(e -> {
            String text = openWorldGame.saveMyGame(2);
            save2Button.setText(text);
        });

        //Add the save3Button
        save3Button.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        save3Button.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        save3Button.setFont(BUTTON_FONT);
        save3Button.setBorder(createEmptyBorder());
        save3Button.setFocusPainted(false);
        save3Button.addActionListener(e -> {
            String text = openWorldGame.saveMyGame(3);
            save3Button.setText(text);
        });

        //Add the three buttons above to the panel
        centerWindowPanel.add(save1Button);
        centerWindowPanel.add(save2Button);
        centerWindowPanel.add(save3Button);


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

        savePanel.add(titlePanel, BorderLayout.PAGE_START);
        savePanel.add(backButtonPanel, BorderLayout.PAGE_END);
        savePanel.add(centerWindowPanel, BorderLayout.CENTER);

        return savePanel;
    }

    private void changeText(int i, String text) {

        switch (i) {
            case 1 -> save1Button.setText(text);
            case 2 -> save2Button.setText(text);
            case 3 -> save3Button.setText(text);
        }
    }
}
