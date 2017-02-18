package game;

import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		Game game = new Game();
		Deck deck = new Deck();
		deck.createDeck();
		Player player = new Player();
		Player dealer = new Player();
		deck.dealCard(player);
		deck.dealCard(player);
		deck.dealCard(dealer);
		deck.dealCard(dealer);

		for (Card c : player.getHand().getCards()) {
			System.out.println(c);
		}
		System.out.println("Player total: " + game.handTotal(player));
		for (Card c : dealer.getHand().getCards()) {
			System.out.println(c);
		}
		System.out.println("Dealer total: " + game.handTotal(dealer));
		System.out.println();
		
		game.userPlay(game, dealer, dealer, deck);

	}

	public void userPlay(Game game, Player player, Player dealer, Deck deck) {
		Scanner kb = new Scanner(System.in);
		String input = "";
		boolean keepPlaying = true;
		boolean userKeepPlaying = true;
		boolean dealerKeepPlaying = true;

		while (keepPlaying = true) {

			while (userKeepPlaying = true) {
				if (game.handTotal(player) < 21) {
					System.out.println("Hit or stay?");
					input = kb.next();
					if (input.equalsIgnoreCase("Hit")) {
						Card c = deck.dealCard(player);
						System.out.println("Player's new card: " + c);
						System.out.println("New total: " + game.handTotal(player));
					}
					if (input.equalsIgnoreCase("Stay")) {
						break;
					}
				} else if (game.handTotal(player) > 21) {
					System.out.println("Over twenty one, you busted, dealer wins.");
					userKeepPlaying = false;
				} else if (game.handTotal(player) == 21) {
					System.out.println("21!  You win.");
					userKeepPlaying = false;
				}
			}
			while (dealerKeepPlaying = true) {
				if (game.handTotal(dealer) <= 16) {
					Card c = deck.dealCard(dealer);
					System.out.println("Dealer's new card: " + c);
					System.out.println("Dealer total: " + game.handTotal(dealer));
				}
				if (game.handTotal(dealer) > 21) {
					System.out.println("Dealer busts, you win.");
					dealerKeepPlaying = false;
				} else if (game.handTotal(dealer) == 21) {
					System.out.println("Dealer wins.");
					dealerKeepPlaying = false;
				}
			}
		}
	}

	public double handTotal(Player player) {
		double handTotal = 0;
		for (Card c : player.getHand().getCards()) {
			handTotal = handTotal + c.getValue();
		}
		return handTotal;
	}


}
