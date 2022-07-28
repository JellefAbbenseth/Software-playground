package GUI;

import javax.swing.*;
import java.awt.*;

import static javax.swing.BorderFactory.createEmptyBorder;

public class BattlePanel {

    private final Font BUTTON_FONT = new Font("Verdana", Font.BOLD, 25);
    private final Font TEXT_AREA_FONT = new Font("Verdana", Font.PLAIN, 25);
    private final Color MAIN_WINDOW_BACKGROUND_COLOR = Color.white;
    private final Color TEXT_AREA_BACKGROUND_COLOR = Color.black;
    private final Color MAIN_WINDOW_FOREGROUND_COLOR = Color.black;
    private final Color TEXT_AREA_FOREGROUND_COLOR = Color.blue;


    private final JButton BLOCK = new JButton("Blocken");
    private final JButton REST = new JButton("Erholen");
    private final JButton ESCAPE = new JButton("Fliehen");

    private BorderLayout openWorldBorderLayout;
    private GridLayout owButtonGridLayout;
    private BoxLayout openWorldBoxLayout;

    private static JButton ATTACK = new JButton("Angriff");
    private JTextArea shownText;
    private JPanel owStartPanel, owCenterPanel, owShownTextPanel, owButtonPanel, owEndPanel;

    private int windowWidth, windowHeight;


    public JPanel BattlePanel(MainWindow.ChoiceHandler cHandler, CardLayout cardLayout, JPanel cardPanel, int width, int height){

        JPanel openWorldPanel = new JPanel();
        openWorldBorderLayout = new BorderLayout();
        openWorldPanel.setLayout(openWorldBorderLayout);

        /**
         * The Button to enter the menu
         * it's at the PAGE_START
         */

        owStartPanel = new JPanel();
        owStartPanel.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        windowHeight = Math.round(height * 0.07f);
        owStartPanel.setPreferredSize(new Dimension(width, windowHeight));


        /**
         * The Center of the Panel
         * It shows the game texts and gives the Player the options
         * explore, rest and profile
         * those will trigger the actions
         */

        owCenterPanel = new JPanel();
        owCenterPanel.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        openWorldBoxLayout = new BoxLayout(owCenterPanel, BoxLayout.Y_AXIS);
        owCenterPanel.setLayout(openWorldBoxLayout);

        //Create the Text area, which will give the text
        owShownTextPanel = new JPanel();
        owShownTextPanel.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);

        shownText = new JTextArea("Testtext");
        shownText.setBackground(TEXT_AREA_BACKGROUND_COLOR);
        shownText.setForeground(TEXT_AREA_FOREGROUND_COLOR);
        shownText.setFont(TEXT_AREA_FONT);
        shownText.setEditable(false);
        shownText.setBorder(createEmptyBorder());
        windowWidth = Math.round(width * 0.9f);
        windowHeight = Math.round(height * 0.6f);
        shownText.setPreferredSize(new Dimension(windowWidth, windowHeight));   //Set the size of the TextArea

        owShownTextPanel.add(shownText);

        //Create the buttons area, which will give the player some options
        owButtonPanel = new JPanel();
        owButtonGridLayout = new GridLayout(1, 3);
        owButtonPanel.setLayout(owButtonGridLayout);

        //Create the button for the attack
        ATTACK.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        ATTACK.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        ATTACK.setFocusPainted(false);
        ATTACK.setBorder(createEmptyBorder());
        ATTACK.setFont(BUTTON_FONT);
        ATTACK.addActionListener(cHandler);

        //Create the button for the block
        BLOCK.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        BLOCK.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        BLOCK.setFocusPainted(false);
        BLOCK.setBorder(createEmptyBorder());
        BLOCK.setFont(BUTTON_FONT);
        BLOCK.addActionListener(cHandler);

        //Create the button for resting
        REST.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        REST.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        REST.setFocusPainted(false);
        REST.setBorder(createEmptyBorder());
        REST.setFont(BUTTON_FONT);
        REST.addActionListener(cHandler);

        //Create the button for escape
        ESCAPE.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        ESCAPE.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        ESCAPE.setFocusPainted(false);
        ESCAPE.setBorder(createEmptyBorder());
        ESCAPE.setFont(BUTTON_FONT);
        ESCAPE.addActionListener(cHandler);

        //Add buttons to the owButtonPanel
        owButtonPanel.add(ATTACK);
        owButtonPanel.add(BLOCK);
        owButtonPanel.add(REST);
        owButtonPanel.add(ESCAPE);


        //Add Panels to the owCenterPanel
        owCenterPanel.add(owShownTextPanel);
        owCenterPanel.add(owButtonPanel);


        /**
         * The Page ends as a blank Panel
         * it's at the PAGE_END
         */

        owEndPanel = new JPanel();
        owEndPanel.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        windowHeight = Math.round(height * 0.1f);
        owEndPanel.setPreferredSize(new Dimension(width, windowHeight));

        /**
         * Adding everything together
         * return the openWorldPanel
         */
        openWorldPanel.add(owStartPanel, BorderLayout.PAGE_START);
        openWorldPanel.add(owCenterPanel, BorderLayout.CENTER);
        openWorldPanel.add(owEndPanel, BorderLayout.PAGE_END);

        return openWorldPanel;
    }

    public void setText(String text){
        shownText.setText(text);
    }

    public static void counter(boolean isBlocked) {
        if(isBlocked) ATTACK.setText("Konter");
        else ATTACK.setText("Angriff");
    }
}
