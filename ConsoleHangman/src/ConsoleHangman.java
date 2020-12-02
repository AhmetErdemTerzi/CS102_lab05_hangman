import java.util.Scanner;

/**
 * ConsoleHangman
 *
 * @author Ahmet Erdem Terzi
 * @version 1.00 2013/4/7
 */

public class ConsoleHangman
{
    public static void main( String[] args)
	{
    	Scanner scan = new Scanner( System.in);

    	System.out.println( "Start of ConsoleHangman\n");

		// VARIABLES
		HangmanModel		hangman1, hangman2;
		ConsoleHangmanView		hangmanView1,hangmanView2;

		// PROGRAM CODE
		hangman1 = new HangmanModel( new BasicSetup() );
		hangman2 = new HangmanModel( new BasicSetup());

		hangmanView1 = new ConsoleHangmanView();
		hangmanView2 = new ConsoleHangmanView();

		hangman1.addView(hangmanView1);
		hangman2.addView(hangmanView2);

		String input1, input2;
		hangmanView1.updateView(hangman1);
		hangmanView2.updateView(hangman2);

		System.out.println();
		while(!hangman1.isGameOver())
		{
			System.out.print("Try new letter for first game: ");
			input1 = scan.next();
			hangman1.tryThis(input1.charAt(0));
			System.out.println();
			System.out.print("Try new letter for second game: ");
			input2 = scan.next();
			hangman2.tryThis(input2.charAt(0));
			System.out.println();
		}

		if(!hangman1.hasLost())
			System.out.println("\nCongratulations! You Have Won!");
		else
			System.out.println("You have lost!");


		System.out.println( "\nEnd of ConsoleHangman\n" );
	}

} // end of class ConsoleHangman
