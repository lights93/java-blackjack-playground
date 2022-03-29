package blackjack.minhoyoo.domain;

import java.util.List;
import java.util.Objects;

public abstract class CardOwner {
	private final Cards cards = Cards.empty();

	public void addCard(Card card) {
		cards.addCard(card);
	}

	public List<Card> getCards() {
		return cards.getAll();
	}

	public BlackjackResult calculateResult() {
		return BlackjackResult.from(cards);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CardOwner cardOwner = (CardOwner)o;
		return Objects.equals(cards, cardOwner.cards);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cards);
	}
}
