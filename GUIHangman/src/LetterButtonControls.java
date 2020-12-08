import cs102.Hangman;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * LetterButtonControls - keyboard for MVC demo of Hangman, but general.
 *
 * @author David
 * @version 1.00 2012/4/8
 */
public class LetterButtonControls extends JPanel
{
	private LetterButtonListener listener;
	private Hangman hangman;

	public LetterButtonControls( String letters, Hangman hangman)
	{
		this( letters, 2, 13, hangman);
	}

	public LetterButtonControls( String letters, int rows, int cols, Hangman hangman)
	{
		this.hangman = hangman;
		listener = new LetterButtonListener(this);

		setBorder( new TitledBorder("Choose a letter...") );
		setLayout( new GridLayout( rows, cols) );

		for( int i = 0; i < letters.length(); i++) {
			JButton b = new JButton( "" + letters.charAt(i) );
			b.setMargin( new Insets( 1, 2, 1, 2) );
			add( b);
			b.addActionListener(listener);
		}
	}

	public void addActionListener( ActionListener l)
	{
		Component[] buttons = getComponents();
		for ( Component b : buttons )
		{
			( (JButton) b).addActionListener( l);
		}
	}

	public void setEnabledAll( boolean state)
	{
		for ( Component c : getComponents() ) {
			((JButton) c).setEnabled( state);
		}
	}

	public void setDisabled( String letters)
	{
		for ( Component c : getComponents() ) {
			char ch = ((JButton) c).getLabel().charAt(0);
			if ( letters.indexOf(ch) >= 0)
				((JButton) c).setEnabled( false);
		}
	}

	public class LetterButtonListener implements ActionListener {

		private  LetterButtonControls controls;
		public LetterButtonListener(LetterButtonControls a)
		{
			controls = a;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String ch = ((JButton) e.getSource()).getText();
			hangman.tryThis(ch.charAt(0));
			controls.setDisabled(ch);
		}
	}
}