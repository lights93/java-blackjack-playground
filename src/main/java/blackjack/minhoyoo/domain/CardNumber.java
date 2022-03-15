package blackjack.minhoyoo.domain;

public enum CardNumber {
	ONE("1"),
	TWO("2"),
	THREE("3"),
	FOUR("4"),
	FIVE("5"),
	SIX("6"),
	SEVEN("7"),
	EIGHT("8"),
	NINE("9"),
	TEN("10"),
	KING("K"),
	QUEEN("Q"),
	JACK("J"),
	ACE("A");

	private final String name;

	CardNumber(String name) {
		this.name = name;
	}
}
