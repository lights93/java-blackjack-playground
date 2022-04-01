package blackjack.minhoyoo.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeckTest {
	@DisplayName("카드 뽑기")
	@Test
	void draw() {
		Deck deck = new Deck(() -> {
			Deque<Card> cards = new LinkedList<>();
			cards.push(new Card(CardNumber.ACE, Suit.SPADE));
			cards.push(new Card(CardNumber.TWO, Suit.SPADE));

			return cards;
		});

		assertThat(deck.draw()).isEqualTo(new Card(CardNumber.TWO, Suit.SPADE));
		assertThat(deck.draw()).isEqualTo(new Card(CardNumber.ACE, Suit.SPADE));
	}
}
