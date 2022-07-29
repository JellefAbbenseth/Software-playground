package GUI;

import javax.swing.*;
import java.awt.*;

import static javax.swing.BorderFactory.createEmptyBorder;

public class HelpPanel {

    private final Font TITLE_FONT = new Font("Verdana", Font.BOLD, 25);
    private final Font BUTTON_FONT = new Font("Verdana", Font.BOLD, 25);
    private final Font TEXT_FONT = new Font("Verdana", Font.PLAIN, 20);
    private final Color MAIN_WINDOW_BACKGROUND_COLOR = Color.white;
    private final Color MAIN_WINDOW_FOREGROUND_COLOR = Color.black;

    private final JButton START_BUTTON = new JButton("START");
    private final JButton BACK_BUTTON = new JButton("ZURÜCK");

    private BorderLayout helpPanelBorderLayout;
    private GridLayout helpPanelGridLayout;

    private JPanel helpTitelPanel, helpTextPanel, buttonPanel;
    private JTextArea helpText;
    private JTextField helpTitel = new JTextField("Hilfe");

    private final float widthHeightMultiplier = 0.75f;

    public JPanel HelpPanel(int width, int height, CardLayout cardLayout, JPanel cardPanel) {

        JPanel helpPanel = new JPanel();
        helpPanelBorderLayout = new BorderLayout();
        helpPanel.setLayout(helpPanelBorderLayout);
        helpPanel.setBackground(Color.cyan);

        //Seitentitel
        helpTitelPanel = new JPanel();
        helpTitelPanel.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        helpTitelPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        helpTitel.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        helpTitel.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        helpTitel.setFont(TITLE_FONT);
        helpTitel.setBorder(createEmptyBorder());
        helpTitelPanel.add(helpTitel);

        //Den Start und ZurückButton richtig setzen und übergabe zu neuen Seiten einstellen
        buttonPanel = new JPanel();
        helpPanelGridLayout = new GridLayout(1,2);
        buttonPanel.setLayout(helpPanelGridLayout);

        START_BUTTON.setFont(BUTTON_FONT);
        START_BUTTON.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        START_BUTTON.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        START_BUTTON.setFocusPainted(false);
        START_BUTTON.setBorder(createEmptyBorder());
        START_BUTTON.addActionListener(e -> cardLayout.show(cardPanel, "3"));
        BACK_BUTTON.setFont(BUTTON_FONT);
        BACK_BUTTON.setBorder(createEmptyBorder());
        BACK_BUTTON.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        BACK_BUTTON.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        BACK_BUTTON.setFocusPainted(false);
        BACK_BUTTON.addActionListener(e -> cardLayout.show(cardPanel, "1"));

        buttonPanel.add(BACK_BUTTON);
        buttonPanel.add(START_BUTTON);

        //Textfeld erstellen. Text wird später hinzugefügt
        helpTextPanel = new JPanel();
        helpTextPanel.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);

        helpText = new JTextArea(writeText());
        helpText.setEditable(false);
        helpText.setBackground(MAIN_WINDOW_BACKGROUND_COLOR);
        helpText.setForeground(MAIN_WINDOW_FOREGROUND_COLOR);
        helpText.setFont(TEXT_FONT);
        width = Math.round(width * widthHeightMultiplier);
        height = Math.round(height * widthHeightMultiplier);
        helpText.setPreferredSize(new Dimension(width, height));

        //Zeilenumbrüche
        helpText.setLineWrap(true);
        helpText.setWrapStyleWord(true);

        helpTextPanel.add(helpText);

        helpPanel.add(helpTitelPanel, BorderLayout.PAGE_START);
        helpPanel.add(helpTextPanel, BorderLayout.CENTER);
        helpPanel.add(buttonPanel, BorderLayout.PAGE_END);

        return helpPanel;
    }

    public String writeText() {
        String text = "";

        text = "Willkommen beim Spiel Growth.\n\n";
        text += "Es handelt sich um ein Textbasiertes RPG, bei dem der Spieler erstellt werden kann.\n";
        text += "Der Name kann nach dem Wählen des geschlechts geändert werden.\n";
        text += "Gespielt wird über die Buttons.\n";
        text += "Es gibt verschiedene, deren Bezeichnungen die jeweilige Aktion ausführen.\n";
        text += "Beim Erreichen von Level 3 gewinnt der Spieler.\n";
        text += "Wenn das Leben auf oder unter 0 fällt verliert der Spieler\n";
        text += "Beim Ändern der Bildschirmgröße wird das Spiel zurückgesetzt.\n";
        text += "Sollte der Spielstand nicht gespeichert sein, geht dieser verloren.\n\n";
        text += "Nun viel Spaß mit dem Spiel!";

        return text;
    }
}
