package blackjack.minhoyoo.domain.state;

import blackjack.minhoyoo.domain.card.Cards;

public class DealerEnd extends Finished {
	protected DealerEnd(Cards cards) {
		super(cards);
	}

	@Override
	public double earningRate() {
		return 1;
	}
}
