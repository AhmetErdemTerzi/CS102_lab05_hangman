import cs102.Hangman;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameButtonControl extends JButton implements IHangmanView {

    private Hangman hangman;
    private ButtonListener buttonListener;

    public NewGameButtonControl(Hangman hangman)
    {
        this.hangman =hangman;
        buttonListener = new ButtonListener(this);
        setText("New Game!");
        addActionListener(buttonListener);
        setEnabled(false);
    }

    @Override
    public void updateView(Hangman hangmanModel) {
        if(hangmanModel.isGameOver())
        {
            setEnabled(true);
        }
    }

    public class ButtonListener implements ActionListener
    {
        private NewGameButtonControl b;
        public ButtonListener(NewGameButtonControl a )
        {
            b = a;
        }
        public void actionPerformed(ActionEvent e)
        {
            hangman.initNewGame();
            b.setEnabled(false);
        }
    }
}
