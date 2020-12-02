import cs102.Hangman;

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
		Hangman		hangman;

		// PROGRAM CODE
		hangman = new Hangman( new BasicSetup() );

		String input;

		while(!hangman.isGameOver())
		{
			System.out.println("Secret word is: " + hangman.getKnownSoFar() + "\nUsed Letters: " + hangman.getUsedLetters());
			System.out.println("Remaining number of tries: " + (hangman.getMaxAllowedIncorrectTries()-hangman.getNumOfIncorrectTries()));
			System.out.print("Try new letter: ");
			input = scan.next();
			hangman.tryThis(input.charAt(0));
			System.out.println("\n");
		}

		if(!hangman.hasLost())
			System.out.println("\n\nCongratulations! You Have Won!");
		else
			System.out.println("You have lost!");


		System.out.println( "\nEnd of ConsoleHangman\n" );
	}

} // end of class ConsoleHangman
