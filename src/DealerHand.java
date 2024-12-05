import java.util.*;

public class DealerHand extends Hand{

    public DealerHand(){
        super();
    }

    @Override
    public Card hit(ArrayList<Card> deck) {
        Card card = super.hit(deck);
        if (super.getValue()>16) {
            super.stand();
        }
        return card;
    }
}