//!DO NOT EDIT THIS FILE
public class Card {
	private Suit suit;
	private Rank rank;
	
	/**
	 * @param suit the playing card suit (clubs, spades, diamonds, hearts)
	 * @param rank the playing card numerical value (Ace, Two, ...)
	 */
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	/**
	 * @return returns the card suit enumerated value
	 */
	public Suit getSuit() {
		return suit;
	}
	
	/**
	 * @return returns the card numerical value
	 */
	public Rank getRank() {
		return rank;
	}
	
	
	/**
	 * @return formated text description of the card
	 */
	public String toString(){
        	String str;
        	Rank rank = this.getRank();
        	if (rank.ordinal() < 9){
        	    str = (rank.ordinal() + 2) + "";
        	}else{
        	    str = rank.name().substring(0,1);
        	}
        	str += "\n";
        	Suit suit = this.getSuit();
        	switch(suit.ordinal()){
        	    case 0:
        	        str += '♠';
        	        break;
        	    case 1:
        	        str += '♥';
        	        break;
        	    case 2:
        	        str += '♦';
        	        break;
        	    case 3:
        	        str += '♣';
        	        break;
        }
        return str;
    }

}
