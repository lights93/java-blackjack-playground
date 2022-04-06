package blackjack.minhoyoo.domain.state;

import blackjack.minhoyoo.domain.card.Cards;

public class Stay extends Finished {
	public Stay(Cards cards) {
		super(cards);
	}

	@Override
	public double earningRate() {
		return 1;
	}
}
