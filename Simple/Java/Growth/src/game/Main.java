package game;

import javax.swing.SwingUtilities;

public class Main
{

	public static void main(String[] args)
	{		
		//Start the game with a GUI, this will lead to the other classes to play
		GUI.StartWindow startWindow = new GUI.StartWindow();
		startWindow.setVisible(true);
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GUI.StartWindow();
			}
		});
		
	}
}
