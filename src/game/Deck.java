package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cards.Rank;
import cards.Suit;

public class Deck {
	List<Card> deck = new ArrayList<>(52);

	int numDelt;

	public void Cards() {
		int counter = 1;

		for (Rank r : Rank.values()) {
			for (Suit s : Suit.values()) {
				if (counter == 1) {
					deck.add(new Card(r, s, 11));
				} else if (counter < 10) {
					deck.add(new Card(r, s, counter));
				} else {
					deck.add(new Card(r, s, 10));
				}
			}
			counter++;
		}
		Collections.shuffle(deck);

	}

	public Card dealCard() {
		return deck.remove(0);
	}

}
