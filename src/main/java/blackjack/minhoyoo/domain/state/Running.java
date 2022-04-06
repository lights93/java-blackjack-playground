package blackjack.minhoyoo.domain.state;

import blackjack.minhoyoo.domain.Money;
import blackjack.minhoyoo.domain.card.Cards;

public abstract class Running extends Started{
	protected Running(Cards cards) {
		super(cards);
	}

	@Override
	public boolean isFinished() {
		return false;
	}

	@Override
	public Money profit(Money money) {
		return money;
	}
}
