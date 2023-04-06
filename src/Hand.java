import jss2.*;

import java.util.*;

public class Hand {
    protected ArraySet<Card> inHand;
    protected int handvalue,count;

    public Hand() {
        inHand = new ArraySet<Card>(12);
        handvalue=0;
        count =0;
    }

    private void reduceHand(Card newCard) {
        if((handvalue) > 21) {
            if(aceInHand()) {
                handvalue -= 10;
            }
        }
    }//end reduceHand

    private boolean aceInHand() {
        boolean result = false;
        Card cardchk = null;
        Iterator<Card> scan = inHand.iterator();

        while (scan.hasNext() && !result) {
            cardchk = scan.next();
            if(cardchk.getvalue() == 11) {
                cardchk.setvalue(1);
                result = true;
            }

        }
        return result;
    }


    public Card newCard(Deck currentdeck) {
        Card result;
        result = currentdeck.getCard();
        inHand.add(result);
        handvalue+=result.getvalue();
        reduceHand(result);
        count++;

        return result;
    }

    public int getHandValue() {
        return handvalue;
    }

    public Iterator<Card> iterator() {
        return inHand.iterator();
    }

    public Card remove(Card crd) {
        return(inHand.remove(crd));
    }

    public void add(Card crd) {
        inHand.add(crd);
    }

    public String toString() {
        String result="";

        Card cardstr = null;
        int i=0;
        Iterator<Card> scan = inHand.iterator();
        while (scan.hasNext())
        {
            cardstr= scan.next();
            result += "card"+i+": "+cardstr.getvalue()+"\n";
            i++;
        }

        return result;
    }

    public ArraySet<Card> getInHand() {
        return inHand;
    }
}//end Hand