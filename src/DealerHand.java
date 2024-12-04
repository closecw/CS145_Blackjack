import java.util.ArrayList;

public class DealerHand extends Hand {
    private ArrayList<Card> hand;
    private int totalValue;
    private boolean stood;

    @Override
    public void hit(ArrayList<Card> deck) {
        if(this.totalValue > 17) {
            stood = true;
        }
    }
}
