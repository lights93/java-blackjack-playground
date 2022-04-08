package blackjack.minhoyoo.domain.state;

import blackjack.minhoyoo.domain.card.Card;
import blackjack.minhoyoo.domain.card.Cards;

public class DealerHit extends Running{
	public DealerHit(Cards cards) {
		super(cards);
	}

	@Override
	public State draw(Card card) {
		cards.addCard(card);
		if (cards.isBust()) {
			return new Bust(cards);
		}
		if(cards().isDealerEnd()) {
			return new DealerEnd(cards);
		}
		return new DealerHit(cards);
	}

	@Override
	public State stay() {
		return new DealerEnd(cards);
	}
}
