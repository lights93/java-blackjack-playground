package blackjack.minhoyoo.domain;

import java.util.Deque;

import blackjack.minhoyoo.domain.card.Card;

public interface ShuffleStrategy {
	Deque<Card> shuffle();
}
