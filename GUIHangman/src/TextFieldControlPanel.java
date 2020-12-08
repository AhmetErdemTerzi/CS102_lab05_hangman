import cs102.Hangman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldControlPanel extends JPanel {

    private Hangman hangman;
    private TextField text;
    private TextListener textListener;

    public TextFieldControlPanel(Hangman hangman)
    {
        this.hangman = hangman;
        textListener = new TextListener();

        text = new TextField(5);
        text.addActionListener(textListener);
        add(text);

    }

    public class TextListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String a = text.getText();

            for(int i = 0 ; i<a.length() ; i++)
            {
                hangman.tryThis(a.charAt(i));
            }

            text.setText("");
        }
    }
}
