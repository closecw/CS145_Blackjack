import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand;
    private int totalValue;
    private boolean stood;

    private int getValue() {
        return totalValue;
    }

    private void setValue(int value) {
        totalValue = value;
    }

    private int compareTo(Hand hand) {
        return 0;
    }

    public void hit(ArrayList<Card> deck) {
        return;
    }

    public void stand() {
        return;
    }



    /*private ArrayList<PokerCard> cards;
    private String scoreString;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(PokerCard card) {
        cards.add(card);
    }

    public int getCardCount() {
        return cards.size();
    }

    public boolean isPair() {
        int count = 0;
        for(PokerCard card : cards) {
            //if()
        }
        return false;
    }

    

    public String toString() {
        StringBuilder indivCards = new StringBuilder();
        for(PokerCard card : cards) {
            indivCards.append(card.toString() + " ");
        }
        return "Hand: " + indivCards + ", Score: " + scoreString;
    }*/
}
