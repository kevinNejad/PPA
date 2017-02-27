package Cards;

public class Heart {

	private Card heartSuit[];

	public Heart() {
		heartSuit = new Card[13];
		for (int i = 0; i < 13; i++) {
			heartSuit[i] = new Card((i + 2), "Heart");
		}
	}

	public Card[] getSuit() {
		return heartSuit;
	}

}
