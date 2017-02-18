package game;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	List<Card> cards = new ArrayList<>(52);

	public void addCard(Card c) {
		cards.add(c);
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	

}
