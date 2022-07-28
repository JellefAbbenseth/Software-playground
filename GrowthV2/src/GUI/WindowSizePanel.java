package GUI;

import Game.OpenWorldGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.BorderFactory.createEmptyBorder;

public class WindowSizePanel {

    private final Font TITLE_FONT = new Font("Verdana", Font.BOLD, 30); //Custom made Font
    private final Font BACK_BUTTON_FONT = new Font("Verdana", Font.BOLD, 25);
    private final Font BUTTON_FONT = new Font("Verdana", Font.BOLD, 25); //Custom made Font
    private final Color MAIN_WINDOW_BACKGROUND_COLOR = Color.white;
    private final Color MAIN_WINDOW_FOREGROUND_COLOR = Color.black;

    private final JLabel windowSizeChooseButton = new JLabel("Fenstergröße");
    private final JButton size1Button = new JButton("800 x 600");
    private final JButton size2Button = new JButton("1200 x 900");
    private final JButton size3Button = new JButton("1680 x 1050");
    private final JButton size4Button = new JButton("1920 x 1080");
    private final JButton backButton = new JButton("Zurück");

    private BorderLayout windowSizeWindowLayout;
    private GridLayout chooseButtonGridLayout;
    private FlowLayout backButtonFlowLayout, titlePanelFlowLayout;

    private JPanel windowSizePanel, titlePanel, centerWindowPanel, backButtonPanel;

    private int topPanelHeight, bottomPanelHeight;


    public JPanel WindowSizePanel(OpenWorldGame openWorldGame, JFrame baseFrame, CardLayout cardLayout, JPanel cardPanel, int width, int height){

        windowSizePanel = new JPanel();
        windowSizePanel.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        windowSizeWindowLayout = new BorderLayout();
        windowSizePanel.setLayout(windowSizeWindowLayout);

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

        windowSizeChooseButton.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        windowSizeChooseButton.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        windowSizeChooseButton.setFont(TITLE_FONT);
        windowSizeChooseButton.setBorder(createEmptyBorder());
        windowSizeChooseButton.setSize(100, topPanelHeight);

        titlePanel.add(windowSizeChooseButton);

        /**
         * Add the different Buttons
         * sizeXButtons
         * BorderLayout CENTER
         */

        centerWindowPanel = new JPanel();
        centerWindowPanel.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        chooseButtonGridLayout = new GridLayout(4, 1);
        centerWindowPanel.setLayout(chooseButtonGridLayout);

        //Add the size1Button (800 x 600)
        size1Button.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        size1Button.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        size1Button.setFont(BUTTON_FONT);
        size1Button.setBorder(createEmptyBorder());
        size1Button.setFocusPainted(false);
        size1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baseFrame.setVisible(false);

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new GUI.MainWindow(openWorldGame, 800, 600,1);
                    }
                });
            }
        });

        //Add the size2Button (1200 x 900)
        size2Button.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        size2Button.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        size2Button.setFont(BUTTON_FONT);
        size2Button.setBorder(createEmptyBorder());
        size2Button.setFocusPainted(false);
        size2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baseFrame.setVisible(false);

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new GUI.MainWindow(openWorldGame, 1200, 900,1);
                    }
                });
            }
        });

        //Add the size3Button (1680 x 1050)
        size3Button.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        size3Button.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        size3Button.setFont(BUTTON_FONT);
        size3Button.setBorder(createEmptyBorder());
        size3Button.setFocusPainted(false);
        size3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baseFrame.setVisible(false);

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new GUI.MainWindow(openWorldGame,1680, 1050 ,1);
                    }
                });
            }
        });

        //Add the size3Button (1920 x 1080)
        size4Button.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        size4Button.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        size4Button.setFont(BUTTON_FONT);
        size4Button.setBorder(createEmptyBorder());
        size4Button.setFocusPainted(false);
        size4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baseFrame.setVisible(false);

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new GUI.MainWindow(openWorldGame,1920, 1080,1);
                    }
                });
            }
        });


        //Add the three buttons above to the panel
        centerWindowPanel.add(size1Button);
        centerWindowPanel.add(size2Button);
        centerWindowPanel.add(size3Button);
        centerWindowPanel.add(size4Button);


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

        windowSizePanel.add(titlePanel, BorderLayout.PAGE_START);
        windowSizePanel.add(backButtonPanel, BorderLayout.PAGE_END);
        windowSizePanel.add(centerWindowPanel, BorderLayout.CENTER);

        return windowSizePanel;
    }
}
