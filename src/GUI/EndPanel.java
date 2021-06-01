package GUI;

import javax.swing.*;
import java.awt.*;

import static javax.swing.BorderFactory.createEmptyBorder;

public class EndPanel {

    private final Font START_FONT = new Font("Verdana", Font.BOLD, 125); //Custom made Font
    private final Font START_BUTTON_FONT = new Font("Verdana", Font.BOLD, 25); //Custom made Font
    private final Color MAIN_WINDOW_BACKGROUND_COLOR = Color.white;
    private final Color MAIN_WINDOW_FOREGROUND_COLOR = Color.black;
    private final Color TITLE_WON_COLOR = new Color(1,50,32);
    private final Color TITLE_LOST_COLOR = new Color(139,0,0);

    private BorderLayout mainWindowLayout;
    private GridLayout returnButtonFlowLayout;
    private JPanel endWindow, pageStartPanel, titlePanel, returnButtonPanel;
    private JTextField title;
    private JButton returnButton;

    private int panelHeight;

    public JPanel EndPanel(CardLayout cardLayout, JPanel cardPanel, int width, int height) {
        endWindow = new JPanel();
        endWindow.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        mainWindowLayout = new BorderLayout();
        endWindow.setLayout(mainWindowLayout);

        //Set the blank PAGE_START
        pageStartPanel = new JPanel();
        pageStartPanel.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        panelHeight = Math.round(height * 0.07f);
        pageStartPanel.setPreferredSize(new Dimension(width, panelHeight));

        //Set the title
        titlePanel = new JPanel();
        titlePanel.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        title = new JTextField("YOU WON!");
        title.setBorder(createEmptyBorder());   //delete the border of the title TextField
        title.setEditable(false);
        title.setFont(START_FONT);
        title.setForeground(TITLE_WON_COLOR);   //a Dark Green as RGB
        title.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        titlePanel.add(title);

        /**
         * Set the returnButtonPanel
         * With the returnButton you get back to the first Page
         */
        returnButtonPanel = new JPanel();
        returnButtonFlowLayout = new GridLayout(4, 1);
        returnButtonPanel.setLayout(returnButtonFlowLayout);
        returnButtonPanel.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);

        //return Button
        returnButton = new JButton("Neues Spiel");
        returnButton.setFont(START_BUTTON_FONT);
        returnButton.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        returnButton.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        returnButton.setBorder(createEmptyBorder());
        returnButton.setFocusPainted(false);
        returnButton.addActionListener(e -> cardLayout.show(cardPanel, "1"));
        returnButtonPanel.add(returnButton);

        endWindow.add(pageStartPanel, BorderLayout.PAGE_START);
        endWindow.add(returnButtonPanel, BorderLayout.PAGE_END);
        endWindow.add(titlePanel, BorderLayout.CENTER);
        return endWindow;
    }

    public void lost() {
        title.setText("YOU LOST!");
        title.setForeground(TITLE_LOST_COLOR);
    }
}
