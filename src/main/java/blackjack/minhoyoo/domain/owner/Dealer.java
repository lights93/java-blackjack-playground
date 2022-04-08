package blackjack.minhoyoo.domain.owner;

import blackjack.minhoyoo.domain.Money;
import blackjack.minhoyoo.domain.card.Cards;
import blackjack.minhoyoo.domain.state.StateFactory;

public class Dealer extends CardOwner {
	public Dealer(Cards cards) {
		super(StateFactory.createDealerState(cards), Money.ZERO);
	}
}
