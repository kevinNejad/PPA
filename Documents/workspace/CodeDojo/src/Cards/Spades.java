package Cards;

public class Spades {

	private Card spadesSuit[];

	public Spades() {
		spadesSuit = new Card[13];
		for (int i = 0; i < 13; i++) {
			spadesSuit[i] = new Card((i + 2), "Spades");
		}
	}

	public Card[] getSuit() {
		return spadesSuit;
	}

}
