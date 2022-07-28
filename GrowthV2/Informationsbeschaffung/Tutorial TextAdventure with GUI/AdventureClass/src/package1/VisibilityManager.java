package package1;

public class VisibilityManager
{
    UI ui;

    public VisibilityManager(UI userInterface)
    {
        ui = userInterface;

    }

    public void showTitleScreen()
    {
        //Show the title screen
        ui.titleNamePanel.setVisible(true);
        ui.startButton.setVisible(true);

        //Hide the game screen
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
    }

    public void titleToTown()
    {
        //Hide the title screen
        ui.titleNamePanel.setVisible(false);
        ui.startButton.setVisible(false);

        //Show the game screen
        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(true);
    }
}
