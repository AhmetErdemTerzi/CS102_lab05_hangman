import cs102.Hangman;

import javax.swing.*;
import java.awt.*;

public class LabelsHangmanView extends JPanel implements IHangmanView {

    private JLabel noOfIncorrectTries;
    private JLabel knownSoFar;
    private JLabel usedLetters;
    private JLabel hasLost;

    public LabelsHangmanView(Hangman hangman)
    {
        setBackground(Color.PINK);
        setLayout(new GridLayout(0,1));
        noOfIncorrectTries = new JLabel("Number of incorrect tries: " + Integer.toString(hangman.getNumOfIncorrectTries()) + "  ");
        knownSoFar = new JLabel("Known so far:  " + hangman.getKnownSoFar());
        usedLetters  = new JLabel("Used Letters: " + hangman.getUsedLetters());
        hasLost = new JLabel("Has Lost: " + hangman.hasLost());

        noOfIncorrectTries.setFont(new Font("Verdana", Font.BOLD, 13));
        knownSoFar.setFont(new Font("Verdana", Font.BOLD, 13));
        usedLetters.setFont(new Font("Verdana", Font.BOLD, 13));
        hasLost.setFont(new Font("Verdana", Font.BOLD, 13));

        add(knownSoFar);
        add(usedLetters);
        add(noOfIncorrectTries);
        add(hasLost);
    }

    public void updateView(Hangman hangmanModel)
    {
        noOfIncorrectTries.setText("Number of incorrect tries: " + Integer.toString(hangmanModel.getNumOfIncorrectTries()) + "  ");
        knownSoFar.setText("Known so far:  " + hangmanModel.getKnownSoFar());
        usedLetters.setText("Used Letters: " + hangmanModel.getUsedLetters());
        hasLost.setText("Has Lost: " + hangmanModel.hasLost());

        if(hangmanModel.getNumOfIncorrectTries()>4)
            noOfIncorrectTries.setForeground(Color.RED);
        else
            noOfIncorrectTries.setForeground(Color.BLACK);

        if(hangmanModel.hasLost())
            hasLost.setForeground(Color.RED);

        else
            hasLost.setForeground(Color.BLACK);
    }
}
