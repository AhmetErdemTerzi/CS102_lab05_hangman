import cs102.Hangman;

import javax.swing.*;
import java.awt.*;

public class GallowsHangmanView extends JPanel implements IHangmanView {

    Hangman hangman;

    public GallowsHangmanView(Hangman hangman)
    {
        this.hangman = hangman;
        setPreferredSize(new Dimension(300,300));
        setBackground(new Color(200,90,200));
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(new Color(61,10,0));
        g.fillRect(40,230,220,30);
        g.fillRect(90,30,20,210);
        g.fillRect(90,30,120,20);
        g.setColor(Color.BLACK);
        g.drawLine(190,50,190,70);

        if(hangman.getNumOfIncorrectTries() > 0)
        {
            g.setColor(new Color(101,50,0));
            g.fillOval(175,70,30,30);
        }

        if(hangman.getNumOfIncorrectTries() > 1)
        {
            g.setColor(Color.RED);
            g.fillRect(180,101,20,55);
        }

        if(hangman.getNumOfIncorrectTries() > 2)
        {
            g.setColor(new Color(101,50,0));
            g.fillRect(175,103,5,50);
        }

        if(hangman.getNumOfIncorrectTries() > 3)
        {
            g.fillRect(200,103,5,50);
        }

        if(hangman.getNumOfIncorrectTries() > 4)
        {
            g.fillRect(182,155,7,55);
        }

        if(hangman.getNumOfIncorrectTries() > 5)
        {
            g.fillRect(191,155,7,55);
        }

    }

    @Override
    public void updateView(Hangman hangmanModel)
    {
        repaint();
    }
}
