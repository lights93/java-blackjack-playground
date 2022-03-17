package blackjack.minhoyoo.domain;

import java.util.List;

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
}
