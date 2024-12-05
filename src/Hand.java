import java.util.*;

public class Hand implements Comparable<Hand> {
    private ArrayList<Card> hand;
    private int totalValue;
    private boolean stood;


    public Hand(){
        hand = new ArrayList<Card>();
        totalValue = 0;
        boolean stood = false;
    }

    public int getValue(){
        return totalValue;
    }

    private void setValue(){
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
            totalValue = 0;
        }
    }

    public void stand(){
        stood = true;
    }

    public boolean getStand(){
        return stood;
    }

    public int compareTo(Hand other){
        if (totalValue < other.getValue()) {
            return -1;
        }
        else if(totalValue > other.getValue()) {
            return 1;
        }
        return 0;
    }

    public Card hit(ArrayList<Card> deck){
        if(!stood) {
            Random random = new Random();
            int rand = random.nextInt(0,deck.size());
            Card card = deck.remove(rand);
            hand.add(card);
            this.setValue();
            return card;
        }
        return null;
    }
}