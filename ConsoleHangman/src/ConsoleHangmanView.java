import cs102.Hangman;

public class ConsoleHangmanView implements IHangmanView
{


    @Override
    public void updateView(Hangman hangmanModel) {
        System.out.println("Secret word is: " + hangmanModel.getKnownSoFar() + "\nUsed Letters: " + hangmanModel.getUsedLetters());
        System.out.println("Remaining number of tries: " + (hangmanModel.getMaxAllowedIncorrectTries()-hangmanModel.getNumOfIncorrectTries()));
    }
}
