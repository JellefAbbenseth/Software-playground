package GUI;

import Game.OpenWorldGame;

import javax.swing.*;
import java.awt.*;

import static javax.swing.BorderFactory.createEmptyBorder;

public class CharCreationPanel {
    private final Font TITLE_FONT = new Font("Verdana", Font.BOLD, 50);
    private final Font BUTTON_FONT = new Font("Verdana", Font.BOLD, 25);
    private final Font TEXT_FONT = new Font("Verdana", Font.BOLD, 25);
    private final Font TEXT_FIELD_FONT = new Font("Verdana", Font.PLAIN, 25);
    private final Color MAIN_WINDOW_BACKGROUND_COLOR = Color.white;
    private final Color MAIN_WINDOW_FOREGROUND_COLOR = Color.black;

    private final JTextField title = new JTextField("Charakter erstellen");
    private final JButton PLAY_BUTTON = new JButton("Play");
    private final JButton mButton = new JButton("M");
    private final JButton wButton = new JButton("W");
    private final JButton plusButton1 = new JButton("+");
    private final JButton plusButton2 = new JButton("+");
    private final JButton plusButton3 = new JButton("+");
    private final JButton minusButton1 = new JButton("-");
    private final JButton minusButton2 = new JButton("-");
    private final JButton minusButton3 = new JButton("-");
    private final JLabel nameLabel = new JLabel("Name:");
    private final JLabel pointsLeftLabel = new JLabel("Übrige Punkte:");
    private final JLabel sexLabel = new JLabel("Geschlecht:");
    private final JLabel lifeLabel = new JLabel("Leben:");
    private final JLabel staminaLabel = new JLabel("Ausdauer");
    private final JLabel damageLabel = new JLabel("Schaden");

    private BorderLayout charCreationBorderLayout;
    private GridLayout charCreationGridLayout;

    private JPanel nameField, sexField, pointsLeftField, dummyField, lifeField, damageField, staminaField;
    private JTextField nameTextField, pointsLeftTextField, lifeTextField, staminaTextField, damageTextField;


    private String name = "John";
    private String sex = "m";
    private int pointsLeft = 3;
    private int life = 10;
    private int stamina = 10;
    private int damage = 10;

    public JPanel charCreationPanel(JFrame baseFrame, CardLayout cardLayout, JPanel cardPanel, int width, int height){

        JPanel charCreationPanel = new JPanel();
        charCreationBorderLayout = new BorderLayout();
        charCreationPanel.setLayout(charCreationBorderLayout);

        /**
         * PAGE_START
         * Title of the Card
         */

        title.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        title.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        title.setEditable(false);
        title.setFont(TITLE_FONT);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBorder(createEmptyBorder());
        title.setPreferredSize(new Dimension(width,Math.round(height * 0.2f)));


        /**
         * Center in the Border Layout
         * Gives the Player the possibility to change the Charaktersetup
         */

        JPanel centerCharCreationPanel = new JPanel();
        charCreationGridLayout = new GridLayout(4, 1);
        centerCharCreationPanel.setLayout(charCreationGridLayout);
        centerCharCreationPanel.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);

        //NameField including nameTextField and nameText to change the name of the charakter
        nameField = new JPanel();
        nameField.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);

        nameLabel.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        nameLabel.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        nameLabel.setFont(TEXT_FONT);

        nameTextField = new JTextField(name);
        nameTextField.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        nameTextField.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        nameTextField.setFont(TEXT_FIELD_FONT);
        nameTextField.setPreferredSize(new Dimension(100,50));

        nameField.add(nameLabel);
        nameField.add(nameTextField);

        //sexField including Buttons to change the sex
        sexField = new JPanel();
        sexField.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);

        sexLabel.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        sexLabel.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        sexLabel.setFont(TEXT_FONT);

        mButton.setFont(BUTTON_FONT);
        mButton.addActionListener(e ->{
            sex = "m";
            mButton.setBackground(MAIN_WINDOW_FOREGROUND_COLOR);
            mButton.setForeground(MAIN_WINDOW_BACKGROUND_COLOR);
            mButton.setEnabled(false);
            wButton.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
            wButton.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
            wButton.setEnabled(true);
            if(name.equals("Jane")); nameTextField.setText("John");
        });
        wButton.setFont(BUTTON_FONT);
        wButton.addActionListener(e ->{
            sex = "w";
            mButton.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
            mButton.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
            mButton.setEnabled(true);
            wButton.setBackground(MAIN_WINDOW_FOREGROUND_COLOR);
            wButton.setForeground(MAIN_WINDOW_BACKGROUND_COLOR);
            wButton.setEnabled(false);
            if(name.equals("John")); nameTextField.setText("Jane");
        });

        sexField.add(sexLabel);
        sexField.add(mButton);
        sexField.add(wButton);

        //pointsLeftField including pointsLeftLabel and pointsLeftTextField to inform about points left
        pointsLeftField = new JPanel();
        pointsLeftField.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);

        pointsLeftLabel.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        pointsLeftLabel.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        pointsLeftLabel.setFont(TEXT_FONT);

        pointsLeftTextField = new JTextField("" +pointsLeft);
        pointsLeftTextField.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        pointsLeftTextField.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        pointsLeftTextField.setFont(TEXT_FIELD_FONT);
        pointsLeftTextField.setSize(50,50);
        pointsLeftTextField.setEditable(false);
        pointsLeftTextField.setBorder(createEmptyBorder());

        pointsLeftField.add(pointsLeftLabel);
        pointsLeftField.add(pointsLeftTextField);

        //lifeField including points and plusButton and minusButton
        lifeField = new JPanel();
        lifeField.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);

        lifeLabel.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        lifeLabel.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        lifeLabel.setFont(TEXT_FONT);

        lifeTextField = new JTextField("" +life);
        lifeTextField.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        lifeTextField.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        lifeTextField.setFont(TEXT_FIELD_FONT);
        lifeTextField.setSize(50,50);
        lifeTextField.setEditable(false);
        lifeTextField.setBorder(createEmptyBorder());

        plusButton1.setFont(BUTTON_FONT);
        plusButton1.addActionListener(e -> {
            if (pointsLeft >= 1) {
                minusButton1.setEnabled(true);
                pointsLeft--;
                pointsLeftTextField.setText("" +pointsLeft);
                life++;
                lifeTextField.setText("" +life);
                if (pointsLeft == 0){
                    plusButton1.setEnabled(false);
                    plusButton2.setEnabled(false);
                    plusButton3.setEnabled(false);
                }
            }
        });
        minusButton1.setFont(BUTTON_FONT);
        minusButton1.addActionListener(e -> {
            if(life >= 9){
                plusButton1.setEnabled(true);
                plusButton2.setEnabled(true);
                plusButton3.setEnabled(true);
                pointsLeft++;
                pointsLeftTextField.setText("" +pointsLeft);
                life--;
                lifeTextField.setText("" +life);
                if(life==8) minusButton1.setEnabled(false);
            }
        });

        lifeField.add(lifeLabel);
        lifeField.add(lifeTextField);
        lifeField.add(plusButton1);
        lifeField.add(minusButton1);

        //damageField including points and plusButton and minusButton
        damageField = new JPanel();
        damageField.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);

        damageLabel.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        damageLabel.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        damageLabel.setFont(TEXT_FONT);

        damageTextField = new JTextField("" +damage);
        damageTextField.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        damageTextField.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        damageTextField.setFont(TEXT_FIELD_FONT);
        damageTextField.setSize(50,50);
        damageTextField.setEditable(false);
        damageTextField.setBorder(createEmptyBorder());

        plusButton2.setFont(BUTTON_FONT);
        plusButton2.addActionListener(e -> {
            if (pointsLeft >= 1) {
                minusButton2.setEnabled(true);
                pointsLeft--;
                pointsLeftTextField.setText("" +pointsLeft);
                damage++;
                damageTextField.setText("" +damage);
                if (pointsLeft == 0){
                    plusButton1.setEnabled(false);
                    plusButton2.setEnabled(false);
                    plusButton3.setEnabled(false);
                }
            }
        });
        minusButton2.setFont(BUTTON_FONT);
        minusButton2.addActionListener(e -> {
            if(damage >= 9){
                plusButton1.setEnabled(true);
                plusButton2.setEnabled(true);
                plusButton3.setEnabled(true);
                pointsLeft++;
                pointsLeftTextField.setText("" +pointsLeft);
                damage--;
                damageTextField.setText("" +damage);
                if(damage==8) minusButton2.setEnabled(false);
            }
        });

        damageField.add(damageLabel);
        damageField.add(damageTextField);
        damageField.add(plusButton2);
        damageField.add(minusButton2);

        //staminaField including points and plusButton and minusButton
        staminaField = new JPanel();
        staminaField.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);

        staminaLabel.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        staminaLabel.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        staminaLabel.setFont(TEXT_FONT);

        staminaTextField = new JTextField("" +stamina);
        staminaTextField.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        staminaTextField.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        staminaTextField.setFont(TEXT_FIELD_FONT);
        staminaTextField.setSize(50,50);
        staminaTextField.setEditable(false);
        staminaTextField.setBorder(createEmptyBorder());

        plusButton3.setFont(BUTTON_FONT);
        plusButton3.addActionListener(e -> {
            if (pointsLeft >= 1) {
                minusButton3.setEnabled(true);
                pointsLeft--;
                pointsLeftTextField.setText("" +pointsLeft);
                stamina++;
                staminaTextField.setText("" +stamina);
                if (pointsLeft == 0){
                    plusButton1.setEnabled(false);
                    plusButton2.setEnabled(false);
                    plusButton3.setEnabled(false);
                }
            }
        });
        minusButton3.setFont(BUTTON_FONT);
        minusButton3.addActionListener(e -> {
            if(stamina >= 9){
                plusButton1.setEnabled(true);
                plusButton2.setEnabled(true);
                plusButton3.setEnabled(true);
                pointsLeft++;
                pointsLeftTextField.setText("" +pointsLeft);
                stamina--;
                staminaTextField.setText("" +stamina);
                if(stamina==8) minusButton3.setEnabled(false);
            }
        });

        staminaField.add(staminaLabel);
        staminaField.add(staminaTextField);
        staminaField.add(plusButton3);
        staminaField.add(minusButton3);

        //dummyField
        dummyField = new JPanel();
        dummyField.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);

        //Add the Fields to the centerCharCreationPanel
        centerCharCreationPanel.add(nameField);
        centerCharCreationPanel.add(sexField);
        centerCharCreationPanel.add(pointsLeftField);
        centerCharCreationPanel.add(dummyField);
        centerCharCreationPanel.add(lifeField);
        centerCharCreationPanel.add(damageField);
        centerCharCreationPanel.add(staminaField);

        /**
         * PAGE_END
         * PLAY_BUTTON setup
         */

        PLAY_BUTTON.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        PLAY_BUTTON.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        PLAY_BUTTON.setFont(BUTTON_FONT);
        PLAY_BUTTON.setFocusPainted(false);
        PLAY_BUTTON.addActionListener(e -> playGame(baseFrame, width, height));
        PLAY_BUTTON.setBorder(createEmptyBorder());
        PLAY_BUTTON.setPreferredSize(new Dimension(width,Math.round(height * 0.1f)));


        /**
         * Adding everything together
         * return the charCreationPanel
         */

        charCreationPanel.add(title, BorderLayout.PAGE_START);
        charCreationPanel.add(centerCharCreationPanel, BorderLayout.CENTER);
        charCreationPanel.add(PLAY_BUTTON, BorderLayout.PAGE_END);

        return charCreationPanel;
    }

    private void playGame(JFrame baseFrame, int width, int height) {

        if(sex.equals("m")) sex = "männlich";
        else if(sex.equals("w")) sex = "weiblich";

        name = nameTextField.getText();

        OpenWorldGame openWorldGame = new OpenWorldGame();
        openWorldGame.openWorldGame(name, sex, life, stamina, damage, width, height);

        baseFrame.dispose();
    }
}
