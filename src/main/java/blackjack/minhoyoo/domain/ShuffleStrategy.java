package blackjack.minhoyoo.domain;

import java.util.Deque;

public interface ShuffleStrategy {
	Deque<Card> shuffle();
}
