import cs102.Hangman;

public class HangmanLetterButtonControls extends LetterButtonControls implements IHangmanView {

    public HangmanLetterButtonControls( String letters, int rows, int cols, Hangman hangman)
    {
        super( letters, rows, cols, hangman);
    }

    @Override
    public void updateView(Hangman hangmanModel)
    {
        setEnabledAll(true);
        setDisabled(hangmanModel.getUsedLetters());
    }
}
