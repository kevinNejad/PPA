package Cards;

public class Diamond {

	private Card diamondSuit[];

	public Diamond() {
		diamondSuit = new Card[13];
		for (int i = 0; i < 13; i++) {
			diamondSuit[i] = new Card((i + 2), "Diamond");
		}
	}

	public Card[] getSuit() {
		return diamondSuit;
	}

}
