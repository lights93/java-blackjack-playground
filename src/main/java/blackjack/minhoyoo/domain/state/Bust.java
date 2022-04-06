package blackjack.minhoyoo.domain.state;

import blackjack.minhoyoo.domain.card.Cards;

public class Bust extends Finished {
	public Bust(Cards cards) {
		super(cards);
	}

	@Override
	public double earningRate() {
		return 0;
	}
}
