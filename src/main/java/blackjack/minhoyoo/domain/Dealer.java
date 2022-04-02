package blackjack.minhoyoo.domain;

public class Dealer extends CardOwner {
	public Dealer(Cards cards) {
		super(cards, Money.ZERO);
	}
}
