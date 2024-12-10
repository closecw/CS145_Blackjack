import java.util.*;

/**
 * Class for creating the hand for the player
 * Includes standard getters and setters as well as the methods for hitting and standing
 * @author Carter Close, Luke Kedrowski
 * @version 1.0
 */
public class Hand implements Comparable<Hand> {
    private ArrayList<Card> hand;
    private int totalValue;
    private boolean stood;

    /**
     * Constructor for a Hand object
     * Sets the hand to be an ArrayList of Cards, the total value to be 0, and stood to false
     */
    public Hand() {
        hand = new ArrayList<Card>();
        totalValue = 0;
        boolean stood = false;
    }

    /**
     * Standard getter for the value of the hand
     * @return total value of the hand
     */
    public int getValue(){
        return totalValue;
    }

    /**
     * Setter for the value of the hand.
     * Deals with aces using an aceCount, this will automatically handle an ace switching from an 11 to a 1.
     * Also deals with a bust.
     */
    private void setValue() {
        totalValue = 0;
        int aceCount = 0;
        for (Card card: this.hand) {
            Rank rank = card.getRank();
            if (rank.ordinal() < 9) {
                totalValue += rank.ordinal() +2;
            }
            else if (rank.ordinal() == 12) {
                totalValue += 11;
                aceCount++;
            }
            else {
                totalValue += 10;
            }
        }
        while (aceCount > 0 && totalValue > 21){
            totalValue -= 10;
            aceCount--;
        }
        if (totalValue > 21){
            stood = true;
        }
    }

    /**
     * Method for standing, just changes the stood boolean to true
     */
    public void stand(){
        stood = true;
    }

    /**
     * Standard getter for the stood boolean
     * @return the value of stood
     */
    public boolean getStand() {
        return stood;
    }

    /**
     * CompareTo method for comparing the value of hands
     * @param other the object to be compared.
     * @return the comparison value of the two hands
     */
    public int compareTo(Hand other) {
        if (totalValue < other.getValue()) {
            return -1;
        }
        else if(totalValue > other.getValue()) {
            return 1;
        }
        return 0;
    }

    /**
     * Hit method for hitting the deck
     * @param deck is the deck created in the Blackjack class
     * @return either a Card object (if hit was good) or null if it wasn't
     */
    public Card hit(ArrayList<Card> deck) {
        if(!stood) {
            Random random = new Random();
            int rand = random.nextInt(deck.size());
            Card card = deck.remove(rand);
            hand.add(card);
            this.setValue();
            return card;
        }
        return null;
    }
}