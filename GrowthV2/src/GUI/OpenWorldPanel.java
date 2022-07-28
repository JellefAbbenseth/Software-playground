package GUI;

import javax.swing.*;
import java.awt.*;

import static javax.swing.BorderFactory.createEmptyBorder;

public class OpenWorldPanel {

    private final Font MENU_BUTTON_FONT = new Font("Verdana", Font.BOLD, 15);
    private final Font BUTTON_FONT = new Font("Verdana", Font.BOLD, 25);
    private final Font TEXT_AREA_FONT = new Font("Verdana", Font.PLAIN, 25);
    private final Color MAIN_WINDOW_BACKGROUND_COLOR = Color.white;
    private final Color TEXT_AREA_BACKGROUND_COLOR = Color.black;
    private final Color MAIN_WINDOW_FOREGROUND_COLOR = Color.black;
    private final Color TEXT_AREA_FOREGROUND_COLOR = Color.blue;

    private final JButton MENU = new JButton("MENÜ");
    private final JButton EXPLORE = new JButton("Erkunden");
    private final JButton REST = new JButton("Ausruhen");
    private final JButton PROFILE = new JButton("Profil");

    private BorderLayout openWorldBorderLayout;
    private FlowLayout owMenuFlowLayout;
    private GridLayout owButtonGridLayout;
    private BoxLayout openWorldBoxLayout;

    private JTextArea shownText;
    private JPanel owMenuPanel, owCenterPanel, owShownTextPanel, owButtonPanel, owEndPanel;

    private int windowWidth, windowHeight;

    public JPanel openWorldPanel(MainWindow.ChoiceHandler cHandler , CardLayout cardLayout, JPanel cardPanel, int width, int height){

        JPanel openWorldPanel = new JPanel();
        openWorldBorderLayout = new BorderLayout();
        openWorldPanel.setLayout(openWorldBorderLayout);

        /**
         * The Button to enter the menu
         * it's at the PAGE_START
         */

        owMenuPanel = new JPanel();
        owMenuPanel.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        owMenuFlowLayout = new FlowLayout();
        owMenuFlowLayout.setAlignment(FlowLayout.LEFT);
        owMenuPanel.setLayout(owMenuFlowLayout);
        windowHeight = Math.round(height * 0.07f);
        owMenuPanel.setPreferredSize(new Dimension(width, windowHeight));

        MENU.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        MENU.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        MENU.setFont(MENU_BUTTON_FONT);
        MENU.setFocusPainted(false);
        MENU.addActionListener(e -> cardLayout.show(cardPanel, "7"));

        owMenuPanel.add(MENU);

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

        //Create the button for the exploration
        EXPLORE.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        EXPLORE.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        EXPLORE.setFocusPainted(false);
        EXPLORE.setBorder(createEmptyBorder());
        EXPLORE.setFont(BUTTON_FONT);
        EXPLORE.addActionListener(cHandler);    //e -> cardLayout.show(cardPanel, "6")

        //Create the button for resting
        REST.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        REST.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        REST.setFocusPainted(false);
        REST.setBorder(createEmptyBorder());
        REST.setFont(BUTTON_FONT);
        REST.addActionListener(cHandler);

        //Create the button for profile
        PROFILE.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        PROFILE.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        PROFILE.setFocusPainted(false);
        PROFILE.setBorder(createEmptyBorder());
        PROFILE.setFont(BUTTON_FONT);
        PROFILE.addActionListener(cHandler);

        //Add buttons to the owButtonPanel
        owButtonPanel.add(EXPLORE);
        owButtonPanel.add(REST);
        owButtonPanel.add(PROFILE);


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
        openWorldPanel.add(owMenuPanel, BorderLayout.PAGE_START);
        openWorldPanel.add(owCenterPanel, BorderLayout.CENTER);
        openWorldPanel.add(owEndPanel, BorderLayout.PAGE_END);

        return openWorldPanel;
    }

    public void setText(String text){
        shownText.setText(text);
    }
}
