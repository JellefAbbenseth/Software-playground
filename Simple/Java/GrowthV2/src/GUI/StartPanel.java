package GUI;

import Game.SaveGame;

import javax.swing.*;
import java.awt.*;

import static javax.swing.BorderFactory.createEmptyBorder;

public class StartPanel {

    private final Font START_FONT = new Font("Verdana", Font.BOLD, 125); //Custom made Font
    private final Font START_BUTTON_FONT = new Font("Verdana", Font.BOLD, 25); //Custom made Font
    private final Font HEADLINE_BUTTON_FONT = new Font("Verdana", Font.PLAIN, 15); //Custom made Font
    private final Color MAIN_WINDOW_BACKGROUND_COLOR = Color.white;
    private final Color MAIN_WINDOW_FOREGROUND_COLOR = Color.black;
    private final Color TITLE_COLOR = new Color(1,50,32);

    private BorderLayout mainWindowLayout;
    private FlowLayout menuButtonFlowLayout, helpButtonFlowLayout;
    private GridLayout startSafeButtonFlowLayout;
    private JPanel startWindow,menuButtonPanel, helpButtonPanel, headlineButtonPanel, titlePanel, startButtonPanel;
    private JTextField title;
    private JButton menuButton, helpButton, startButton,

            //LoadButton
            loadButton = new JButton("LADEN");

    private boolean load = false;

    public JPanel StartPanel(CardLayout cardLayout, JPanel cardPanel) {
        startWindow = new JPanel();
        startWindow.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        mainWindowLayout = new BorderLayout();
        startWindow.setLayout(mainWindowLayout);

        //Set the Button for the help function and menu function
        menuButton = new JButton("Menü");
        menuButton.setSize(50, 10);
        menuButton.setFont(HEADLINE_BUTTON_FONT);
        menuButton.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        menuButton.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        menuButton.setFocusPainted(false);
        menuButton.addActionListener(e -> cardLayout.show(cardPanel, "7"));
        menuButtonPanel = new JPanel();
        menuButtonPanel.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        menuButtonFlowLayout = new FlowLayout();
        menuButtonFlowLayout.setAlignment(FlowLayout.LEFT);
        menuButtonPanel.setLayout(menuButtonFlowLayout);
        menuButtonPanel.add(menuButton);

        helpButton = new JButton("Hilfe");
        helpButton.setSize(50, 10);
        helpButton.setFont(HEADLINE_BUTTON_FONT);
        helpButton.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        helpButton.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        helpButton.setFocusPainted(false);
        helpButton.addActionListener(e -> cardLayout.show(cardPanel, "2"));
        helpButtonPanel = new JPanel();
        helpButtonPanel.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        helpButtonFlowLayout = new FlowLayout();
        helpButtonFlowLayout.setAlignment(FlowLayout.RIGHT);
        helpButtonPanel.setLayout(helpButtonFlowLayout);
        helpButtonPanel.add(helpButton);

        headlineButtonPanel = new JPanel();
        headlineButtonPanel.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        headlineButtonPanel.setLayout(new GridLayout(1,2));
        headlineButtonPanel.add(menuButtonPanel);
        headlineButtonPanel.add(helpButtonPanel);

        //Set the title
        titlePanel = new JPanel();
        titlePanel.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        title = new JTextField("GROWTH");
        title.setBorder(createEmptyBorder());   //delete the border of the title TextField
        title.setEditable(false);
        title.setFont(START_FONT);
        title.setForeground(TITLE_COLOR);   //a Dark Green as RGB
        title.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        titlePanel.add(title);

        /**
         * Set the StartButtonPanel
         * The Load Button is deactivated as long as there is no safe-data
         */
        startButtonPanel = new JPanel();
        startSafeButtonFlowLayout = new GridLayout(4, 1);
        startButtonPanel.setLayout(startSafeButtonFlowLayout);
        startButtonPanel.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);

        //Start Button
        startButton = new JButton("START");
        startButton.setSize(50,50);
        startButton.setFont(START_BUTTON_FONT);
        startButton.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        startButton.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        startButton.setBorder(createEmptyBorder());
        startButton.setFocusPainted(false);
        startButton.addActionListener(e -> cardLayout.show(cardPanel, "3"));
        startButtonPanel.add(startButton);

        loadButton.setFont(START_BUTTON_FONT);
        loadButton.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        loadButton.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        loadButton.setBorder(createEmptyBorder());
        loadButton.setFocusPainted(false);
        loadButton.addActionListener(e -> cardLayout.show(cardPanel, "9"));

        //Check if there is a saveFile
        SaveGame saveFile = new SaveGame();
        load = saveFile.SaveGameExists();

        //If there is a saveFile show the loadButton
        loadButton.setVisible(load);
        startButtonPanel.add(loadButton);

        //Add all the Panels together
        startWindow.add(headlineButtonPanel, BorderLayout.PAGE_START);
        startWindow.add(startButtonPanel, BorderLayout.PAGE_END);
        startWindow.add(titlePanel, BorderLayout.CENTER);
        return startWindow;
    }
}
