
import java.util.*;

public class Blackjack {
    Hand dealer;    //to hold the dealer's cards
    static Hand player;    //to hold the player's cards
    Deck newdeck;   //a set of cards

    public Blackjack(Hand dlr, Hand plr) {
        dealer = dlr;
        player = plr;
        newdeck = new Deck();
    }//Blackjack constructor

    public void dealInitialCards() {
        dealer.newCard(newdeck);
        dealer.newCard(newdeck);
        player.newCard(newdeck);
        player.newCard(newdeck);

    }//end deal method

    public Card hit(Hand whohit) {
        Card result = whohit.newCard(newdeck);

        return result;

    }//end hit method

    public int handValue(Hand whohand) {
        int result = whohand.getHandValue();

        return result;

    }// end handValue method

    public void discard(Hand whodis, Card discrd)
    {
        Card card=null;
        boolean found = false;
        Iterator<Card> scan = whodis.iterator();
        while (scan.hasNext() && !found) {
            card = scan.next();
            if(discrd.equals(card)) {
                whodis.remove(card);
                found = true;
            }
        }


    }//end discard

    public boolean blackj()
    {
        boolean result = false;

        if(player.getHandValue() == 21) {
            result = true;
        }

        return result;

    }//end blackj

    public boolean bust(Hand whobust)
    {
        boolean result = false;

        if(whobust.getHandValue() > 21) {
            result = true;
        }

        return result;

    }//end bust

    public Hand dealerPlays() {
        Hand result = dealer;
        while(dealer.getHandValue() <= 16) {
            dealer.newCard(newdeck);
        }

        return result;

    }//end dealerPlays

    public String winner() {
        String result = "";
        if((player.getHandValue() < dealer.getHandValue()) &&
                dealer.getHandValue() <= 21 ) {
            result = "Lose";
        }
        else if ((player.getHandValue() == dealer.getHandValue()) &&
                dealer.getHandValue() <= 21 ) {
            result = "Push";
        }
        else {
            result = "Win";
        }

        return result;

    }//end winner

    public static Hand getPlayer() {
        return player;
    }
}//end Blackjack