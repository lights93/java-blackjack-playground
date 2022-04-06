package blackjack.minhoyoo.domain.state;

import blackjack.minhoyoo.domain.card.Card;
import blackjack.minhoyoo.domain.card.Cards;

public class Hit extends Running{
	public Hit(Cards cards) {
		super(cards);
	}

	@Override
	public State draw(Card card) {
		cards.addCard(card);
		if (cards.isBust()) {
			return new Bust(cards);
		}
		return new Hit(cards);
	}

	@Override
	public State stay() {
		return new Stay(cards);
	}
}
