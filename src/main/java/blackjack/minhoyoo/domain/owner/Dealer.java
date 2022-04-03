package blackjack.minhoyoo.domain.owner;

import blackjack.minhoyoo.domain.Money;
import blackjack.minhoyoo.domain.card.Cards;

public class Dealer extends CardOwner {
	public Dealer(Cards cards) {
		super(cards, Money.ZERO);
	}
}
