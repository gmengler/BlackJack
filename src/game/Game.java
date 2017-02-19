package game;

import java.util.Scanner;

public class Game {
	public void playGame() {
		Game game = new Game();
		Deck deck = new Deck();
		deck.createDeck();
		Player player = new Player();
		Player dealer = new Player();
		deck.dealCard(player);
		deck.dealCard(player);
		deck.dealCard(dealer);
		deck.dealCard(dealer);

		System.out.println("Player's cards:");
		for (Card c : player.getHand().getCards()) {
			System.out.println(c);
		}
		System.out.println("Player total: " + game.handTotal(player) + "\n");
		
		System.out.println("Dealer's cards:");
		for (Card c : dealer.getHand().getCards()) {
			System.out.println(c);
		}
		System.out.println("Dealer total: " + game.handTotal(dealer));
		System.out.println();
		
		game.userPlay(game, player, dealer, deck);

	}

	public void userPlay(Game game, Player player, Player dealer, Deck deck) {
		Scanner kb = new Scanner(System.in);
		String input = "";
		boolean keepPlaying = true;
		boolean userKeepPlaying = true;
		boolean dealerKeepPlaying = true;

		while (keepPlaying == true) {

			while (userKeepPlaying) {
				if (game.handTotal(player) < 21) {
					System.out.println("Hit or stay?");
					input = kb.next();
					if (input.equalsIgnoreCase("Hit")) {
						Card c = deck.dealCard(player);
						System.out.println("Player's new card: " + c);
						for (Card d : player.getHand().getCards()) {
							System.out.println(d);
						}
						System.out.println("New total: " + game.handTotal(player));
					}
					if (input.equalsIgnoreCase("Stay")) {
						userKeepPlaying = false;
					}
				} else if (game.handTotal(player) > 21) {
					System.out.println("Over twenty one, you busted, dealer wins.");
					userKeepPlaying = false;
					dealerKeepPlaying = false;
					keepPlaying = false;
				} 
			}
			System.out.println(dealerKeepPlaying);
			while (dealerKeepPlaying) {
				if (game.handTotal(dealer) <= 16) {
					Card c = deck.dealCard(dealer);
					System.out.println("Dealer's new card: " + c);
					System.out.println("Dealer total: " + game.handTotal(dealer));
				}
				else if (game.handTotal(dealer) > 21) {
					System.out.println("Dealer busts, you win.");
					dealerKeepPlaying = false;
					keepPlaying = false;
				} 
				else{
					dealerKeepPlaying=false;
				}
			}
			if(handTotal(player)<= 21 && handTotal(dealer)<=21){
				determineWinner(player,dealer);
				
			}
			keepPlaying = false;
		} 
	}

	public double handTotal(Player player) {
		double handTotal = 0;
		for (Card c : player.getHand().getCards()) {
			handTotal = handTotal + c.getValue();
		}
		return handTotal;
	}
	
	public void determineWinner(Player player, Player dealer) {
		if (handTotal(player) > handTotal(dealer)) {
			System.out.println("You win!");
		}
		else if (handTotal(dealer) > handTotal(player)) {
			System.out.println("Dealer wins.");
		}
		else{
			System.out.println("Push");
		}
	}


}
