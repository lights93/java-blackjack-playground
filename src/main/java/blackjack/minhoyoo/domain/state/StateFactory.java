package blackjack.minhoyoo.domain.state;

import blackjack.minhoyoo.domain.card.Cards;

public class StateFactory {
	private static final int BLACKJACK_NUMBER = 21;
	private StateFactory(){}

	public static State create(Cards cards) {
		int result = cards.calculateResult();
		if(result == BLACKJACK_NUMBER) {
			return new Blackjack(cards);
		}
		if(result > BLACKJACK_NUMBER) {
			return new Bust(cards);
		}

		return new Hit(cards);
	}

	public static State createDealerState(Cards cards) {
		int result = cards.calculateResult();
		if(result == BLACKJACK_NUMBER) {
			return new Blackjack(cards);
		}
		if(result > BLACKJACK_NUMBER) {
			return new Bust(cards);
		}
		if(cards.isDealerEnd()) {
			return new DealerEnd(cards);
		}

		return new DealerHit(cards);
	}
}
