import cs102.Hangman;
import cs102.IHangmanSetup;

import java.util.ArrayList;

public class HangmanModel extends Hangman {

    private ArrayList<IHangmanView> views;

    public HangmanModel(IHangmanSetup setup) {
        super(setup);
        views = new ArrayList<IHangmanView>();
    }

    public void addView(IHangmanView view)
    {
        views.add(view);
    }

    public void update()
    {
        if(views != null)
        {
            for (int i = 0; i < views.size(); i++)
            {
                views.get(i).updateView(this);
            }
        }
    }


    public int tryThis(char letter)
    {
        int a =super.tryThis(letter);
        update();
        return a;
    }

    public void initNewGame() {
        super.initNewGame();
        update();
    }
}
