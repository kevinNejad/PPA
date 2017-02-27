
package Poker;

import java.time.temporal.IsoFields;

import Cards.*;
import Deck.Deck;
import Hand.Hand;

public class Poker {

	private Hand hand;

	public static void main(String[] args) {

		Hand hand1 = new Hand();
		Hand hand2 = new Hand();
		Hand hand3 = new Hand();
		Hand hand4 = new Hand();
		System.out.println(hand1);
		System.out.println(hand2);
		System.out.println(hand3);
		System.out.println(hand4);
		System.out.println(isFlush(hand1));
		System.out.println(isFlush(hand2));
		System.out.println(isFlush(hand3));
		System.out.println(isFlush(hand4));
		System.out.println("----------");
		System.out.println(isStraight(hand1));
		System.out.println(isStraight(hand2));
		System.out.println(isStraight(hand3));
		System.out.println(isStraight(hand4));

	}

	private static boolean isFlush(Hand hand) {

		for (int i = 0; i < (hand.getHandSize() - 1); i++) {
			for (int j = (i + 1); j < (hand.getHandSize() - i); j++) {
				if (hand.getACard(i) != hand.getACard(j))
					return false;
			}
		}

		return true;
	}

	private static boolean isStraight(Hand hand) {
		int[] values = hand.getValuesArray();

		for (int i = 0; i < (values.length-1); i++) {
			if ((values[i + 1] - values[i]) != 1)
				return false;
		}

		return true;
	}

}
