import javax.swing.*;

public class Card {

    protected String face;
    protected ImageIcon cardpic;
    protected int value;
    protected String suit;

    public Card() {
        cardpic = null;
        value = 0;
        suit = null;
        face = null;
    }

    public Card(ImageIcon x, int val, String s, String f) {
        cardpic = x;
        value = val;
        face = f;
        suit = s;
    }

    public ImageIcon getimage()
    {
        return cardpic;
    }
    public int getvalue()
    {
        return value;
    }
    public void setvalue(int v)
    {
        value = v;
    }
    public String getsuit()
    {
        return suit;
    }
    public String getface()
    {
        return face;
    }
    public String toString()
    {
        return "Face: "+ face + " Suit"+ suit +" Value: "+ value;
    }

}//end Card