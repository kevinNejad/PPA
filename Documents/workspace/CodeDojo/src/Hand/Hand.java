package Hand;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import Cards.*;
import Deck.Deck;

public class Hand {

	private Card hand[];
	private int cardValues[];

	public Hand() {
		hand = new Card[5];
		Deck deck = new Deck();
		Collections.shuffle(deck.getArrayList());
		for (int i = 0; i < 5; i++) {
			hand[i] = deck.getACard(i);
		}
		sortHand();
		getValues();
		ascendArray();
	}

	private void sortHand() {
		Arrays.sort(hand);

	}

	public Card getACard(int index) {
		return hand[index];
	}

	public int getHandSize() {
		return hand.length;
	}

	private void getValues() {
		cardValues = new int[5];
		for (int i = 0; i < hand.length; i++) {
			cardValues[i] = hand[i].getValue();
		}
	}

	private void ascendArray() {
		for (int j = 0; j < cardValues.length - 1; j++) {
			for (int k = j + 1; k < cardValues.length; k++) {
				if (cardValues[j] < cardValues[k]) {
					int dummy = cardValues[j];
					cardValues[j] = cardValues[k];
					cardValues[k] = dummy;
				}
			}
		}
	}

	public int[] getValuesArray() {
		return cardValues;
	}

	public String toString() {
		String str = "";
		for (Card card : hand) {
			str += card;
		}
		return str;
	}

}
