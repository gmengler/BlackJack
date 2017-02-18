package game;

public class Player {
	Hand hand;
	private String name;
	private Double wallet;
	
	public Player(){
		 this.hand = new Hand();
	}

	public Player(String name, Double wallet, Hand hand) {
		super();
		this.name = name;
		this.wallet = wallet;
		this.hand = new Hand();
	}

	public void placeWager(int wager) {
		
	}
	public Hand getHand() {
		return hand;
	}

	public String getName() {
		return name;
	}

	public Double getWallet() {
		return wallet;
	}

}
