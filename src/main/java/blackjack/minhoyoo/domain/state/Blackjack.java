package blackjack.minhoyoo.domain.state;

import blackjack.minhoyoo.domain.card.Cards;

public class Blackjack extends Finished{
	public Blackjack(Cards cards) {
		super(cards);
	}

	@Override
	public double earningRate() {
		return 1.5;
	}
}
