package Deck;


import java.util.ArrayList;

import Cards.*;

public class Deck {

	private ArrayList<Card> deck;

	Diamond diamondSuit = new Diamond();
	Club clubSuit = new Club();
	Heart heartSuit = new Heart();
	Spades spadesSuit = new Spades();

	public Deck() {
		deck = new ArrayList<Card>();
		for (Card card : diamondSuit.getSuit()) {
			deck.add(card) ;
		}
		for (Card card : clubSuit.getSuit()) {
			deck.add(card) ;
		}
		for (Card card : heartSuit.getSuit()) {
			deck.add(card) ;
		}
		for (Card card : spadesSuit.getSuit()) {
			deck.add(card) ;
		}
	}
	
	public Card getACard(int index){
		return deck.get(index);
	}
	
	public ArrayList<Card> getArrayList(){
		return deck;
	}
	
	public String toString(){
		String str= "";
		for(Card card : deck){
			str += card;
		}
		return str;
	}
}
