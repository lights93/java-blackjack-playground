package blackjack.minhoyoo.domain.shuffle;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

import blackjack.minhoyoo.domain.ShuffleStrategy;
import blackjack.minhoyoo.domain.card.Card;
import blackjack.minhoyoo.domain.card.CardNumber;
import blackjack.minhoyoo.domain.card.Suit;

public class RandomShuffleStrategy implements ShuffleStrategy {
	@Override
	public Deque<Card> shuffle() {
		return Arrays.stream(CardNumber.values())
			.flatMap(cardNumber -> Arrays.stream(Suit.values())
				.map(suit -> new Card(cardNumber, suit)))
			.collect(Collectors.collectingAndThen(Collectors.toCollection(LinkedList::new), cards -> {
				Collections.shuffle(cards);
				return cards;
			}));
	}
}
