package blackjack.minhoyoo.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class CardOwner {
	private final List<Card> cards = new ArrayList<>();

	public void addCard(Card card) {
		cards.add(card);
	}

	public List<Card> getCards() {
		return Collections.unmodifiableList(cards);
	}
}
