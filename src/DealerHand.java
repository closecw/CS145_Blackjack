import java.util.*;

/**
 * Class for the dealer's hand
 * Extends hand because it uses its methods and only needs its own hit() method
 * @author Carter Close, Luke Kedrowski
 * @version 1.0
 */
public class DealerHand extends Hand{

    /**
     * Constructor for the dealer's hand
     * Calls the super constructor, which is the Hand constructor
     * Sets the same things as the regular Hand constructor
     */
    public DealerHand(){
        super();
    }

    /**
     * Method for the dealer's hit
     * Stands on >16, otherwise automatically hits
     * @param deck is the deck created in the Blackjack class
     * @return the card the dealer hits
     */
    @Override
    public Card hit(ArrayList<Card> deck) {
        Card card = super.hit(deck);
        if (super.getValue()>16) {
            super.stand();
        }
        return card;
    }
}