import cs102.IHangmanSetup;

/**
 * GUIHangman - GUI based MVC test for cs102 Hangman & IHangmanSetup
 *
 * @author David
 * @version 1.00 2013/4/7
 */

public class GUIHangman
{
	public GUIHangman()
	{
    	System.out.println( "Start of GUIHangman\n");

		HangmanModel			hangman;
		IHangmanSetup			basicSetup;
		ConsoleHangmanView		consoleView;
		TextFieldControlPanel	textControlPanel;
		NewGameButtonControl	newGameButton;
		LabelsHangmanView		labelsHangmanView;
		GallowsHangmanView		hangmanGallows;
		HangmanLetterButtonControls	letterButtonControls;

		basicSetup = new BasicSetup();
		hangman = new HangmanModel( basicSetup);
		textControlPanel = new TextFieldControlPanel(hangman);
		newGameButton = new NewGameButtonControl(hangman);
		labelsHangmanView = new LabelsHangmanView(hangman);
		hangmanGallows = new GallowsHangmanView(hangman);
		letterButtonControls = new HangmanLetterButtonControls(hangman.getAllLetters(),6,0, hangman);

		consoleView = new ConsoleHangmanView();
		hangman.addView(consoleView);
		hangman.addView(labelsHangmanView);
		hangman.addView(hangmanGallows);
		hangman.addView(newGameButton);
		hangman.addView(letterButtonControls);

		new SimpleJFrame( "GUIHangman", 	// title
							hangmanGallows,			// center
							textControlPanel, newGameButton,		// north, south
							letterButtonControls, labelsHangmanView );	// east, west

		// this is an infinite loop reading from the console... not clever!
		ConsoleControl.controlFor( hangman);
	}

	public static void main( String[] args)
	{
		new GUIHangman();

//		// This is the approved way to initialise GUIs
//		// but won't work with the ConsoleControl as is!
//		// --------------------------------------------
//		SwingUtilities.invokeLater(
//			new Runnable() {
//			    public void run() {
//	        		new GUIHangman();
//	        		new GUIHangman();
//	    		}
//			});
	}

} // end of class GUIHangman
