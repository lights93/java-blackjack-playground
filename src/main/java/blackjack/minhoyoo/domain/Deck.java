package blackjack.minhoyoo.domain;

import java.util.Deque;

import blackjack.minhoyoo.domain.card.Card;

public class Deck {
	private final Deque<Card> cards;

	public Deck(ShuffleStrategy strategy) {
		cards = strategy.shuffle();
	}

	public Card draw() {
		return cards.pop();
	}
}
