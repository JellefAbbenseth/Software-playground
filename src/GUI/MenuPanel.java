package GUI;

import javax.swing.*;
import java.awt.*;

import static javax.swing.BorderFactory.createEmptyBorder;

public class MenuPanel {

    private final Font TITLE_FONT = new Font("Verdana", Font.BOLD, 35); //Custom made Font
    private final Font BACK_BUTTON_FONT = new Font("Verdana", Font.BOLD, 25);
    private final Font BUTTON_FONT = new Font("Verdana", Font.BOLD, 25); //Custom made Font
    private final Color MAIN_WINDOW_BACKGROUND_COLOR = Color.white;
    private final Color MAIN_WINDOW_FOREGROUND_COLOR = Color.black;

    private final JLabel menuTitle = new JLabel("MENÜ");
    private final JButton saveButton = new JButton("Speichern");
    private final JButton loadButton = new JButton("Laden");
    private final JButton windowSizeButton = new JButton("Fenstergröße");
    private final JButton backButton = new JButton("Zurück");

    private BorderLayout menuWindowLayout;
    private GridLayout chooseButtonGridLayout;
    private FlowLayout backButtonFlowLayout, titlePanelFlowLayout;

    private JPanel menuPanel, titlePanel, centerWindowPanel, backButtonPanel;

    private int topPanelHeight, bottomPanelHeight;

    public JPanel MenuPanel(MainWindow mainWindow, CardLayout cardLayout, JPanel cardPanel, int width, int height){

        menuPanel = new JPanel();
        menuPanel.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        menuWindowLayout = new BorderLayout();
        menuPanel.setLayout(menuWindowLayout);

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

        menuTitle.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        menuTitle.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        menuTitle.setFont(TITLE_FONT);
        menuTitle.setBorder(createEmptyBorder());
        menuTitle.setSize(100, topPanelHeight);

        titlePanel.add(menuTitle);

        /**
         * Add the different Buttons
         * SaveButton, loadButton, windowSizeButton
         * BorderLayout CENTER
         */

        centerWindowPanel = new JPanel();
        centerWindowPanel.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        chooseButtonGridLayout = new GridLayout(3, 1);
        centerWindowPanel.setLayout(chooseButtonGridLayout);

        //Add the saveButton
        saveButton.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        saveButton.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        saveButton.setFont(BUTTON_FONT);
        saveButton.setBorder(createEmptyBorder());
        saveButton.setFocusPainted(false);
        saveButton.addActionListener(e -> cardLayout.show(cardPanel, "8"));

        //Add the loadButton
        loadButton.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        loadButton.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        loadButton.setFont(BUTTON_FONT);
        loadButton.setBorder(createEmptyBorder());
        loadButton.setFocusPainted(false);
        loadButton.addActionListener(e -> cardLayout.show(cardPanel, "9"));

        //Add the windowSizeButton
        windowSizeButton.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        windowSizeButton.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        windowSizeButton.setFont(BUTTON_FONT);
        windowSizeButton.setBorder(createEmptyBorder());
        windowSizeButton.setFocusPainted(false);
        windowSizeButton.addActionListener(e -> cardLayout.show(cardPanel, "10"));

        //Add the three buttons above to the panel
        centerWindowPanel.add(saveButton);
        centerWindowPanel.add(loadButton);
        centerWindowPanel.add(windowSizeButton);


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
        backButton.addActionListener(e -> {
            if(mainWindow.isGameStart()) cardLayout.show(cardPanel, "4");
            else cardLayout.show(cardPanel, "1");
        });

        backButtonPanel.add(backButton);

        /**
         * Add the three main Panels, title, center and back together
         * return the menuPanel
         */

        menuPanel.add(titlePanel, BorderLayout.PAGE_START);
        menuPanel.add(backButtonPanel, BorderLayout.PAGE_END);
        menuPanel.add(centerWindowPanel, BorderLayout.CENTER);

        return menuPanel;
    }
}
