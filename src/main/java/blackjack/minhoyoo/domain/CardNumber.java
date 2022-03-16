package blackjack.minhoyoo.domain;

public enum CardNumber {
	ONE("1", 1),
	TWO("2", 2),
	THREE("3", 3),
	FOUR("4", 4),
	FIVE("5", 5),
	SIX("6", 6),
	SEVEN("7", 7),
	EIGHT("8", 8),
	NINE("9", 9),
	KING("K", 10),
	QUEEN("Q", 10),
	JACK("J", 10),
	ACE("A", 11);

	private final String name;
	private final int number;

	CardNumber(String name, int number) {
		this.name = name;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}

	public boolean isAce() {
		return this == ACE;
	}
}
