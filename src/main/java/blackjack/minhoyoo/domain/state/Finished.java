package blackjack.minhoyoo.domain.state;

import java.util.Collections;

import blackjack.minhoyoo.domain.Money;
import blackjack.minhoyoo.domain.card.Card;
import blackjack.minhoyoo.domain.card.Cards;

public abstract class Finished extends Started{
	protected Finished(Cards cards) {
		super(cards);
	}

	@Override
	public State draw(Card card) {
		throw new UnsupportedOperationException();
	}

	@Override
	public State stay() {
		return this;
	}

	@Override
	public boolean isFinished() {
		return true;
	}

	@Override
	public Money profit(Money money) {
		return money.multiply(earningRate());
	}

	public abstract double earningRate();
}
