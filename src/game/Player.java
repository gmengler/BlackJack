package game;

public class Player {
	Hand h = new Hand();
	private String name;
	private Double wallet;
	
	public void placeWager(int wager) {
		
	}

	public Player(String name, Double wallet) {
		super();
		this.name = name;
		this.wallet = wallet;
	}

	public Hand getH() {
		return h;
	}

	public String getName() {
		return name;
	}

	public Double getWallet() {
		return wallet;
	}

}
