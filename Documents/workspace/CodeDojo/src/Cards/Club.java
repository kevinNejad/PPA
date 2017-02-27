package Cards;

public class Club {

	private Card clubSuit[];

	public Club() {
		clubSuit = new Card[13];
		for (int i = 0; i < 13; i++) {
			clubSuit[i] = new Card((i + 2), "Club");
		}
	}

	public Card[] getSuit() {
		return clubSuit;
	}

}
