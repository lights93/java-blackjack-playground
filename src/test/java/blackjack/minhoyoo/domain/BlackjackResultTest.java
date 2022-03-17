package blackjack.minhoyoo.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BlackjackResultTest {
	@DisplayName("블랙잭인지 확인")
	@Test
	void isBlackjackTrue() {
		Cards cards = Cards.empty();
		cards.addCard(new Card(CardNumber.KING, Suit.SPADE));
		cards.addCard(new Card(CardNumber.ACE, Suit.SPADE));

		BlackjackResult blackjackResult = BlackjackResult.from(cards);

		assertThat(blackjackResult.isBlackjack()).isTrue();
	}

	@DisplayName("블랙잭 아닌 것 확인")
	@Test
	void isBlackjackFalse() {
		Cards cards = Cards.empty();
		cards.addCard(new Card(CardNumber.KING, Suit.SPADE));
		cards.addCard(new Card(CardNumber.TWO, Suit.SPADE));

		BlackjackResult blackjackResult = BlackjackResult.from(cards);

		assertThat(blackjackResult.isBlackjack()).isFalse();
	}


	@DisplayName("첫 블랙잭인지 확인")
	@Test
	void isFirstBlackjackTrue() {
		Cards cards = Cards.empty();
		cards.addCard(new Card(CardNumber.KING, Suit.SPADE));
		cards.addCard(new Card(CardNumber.ACE, Suit.SPADE));

		BlackjackResult blackjackResult = BlackjackResult.from(cards);

		assertThat(blackjackResult.isFirstBlackJack()).isTrue();
	}

	@DisplayName("첫 블랙잭 아닌 것 확인")
	@Test
	void isFirstBlackjackFalse() {
		Cards cards = Cards.empty();
		cards.addCard(new Card(CardNumber.KING, Suit.SPADE));
		cards.addCard(new Card(CardNumber.ONE, Suit.SPADE));
		cards.addCard(new Card(CardNumber.JACK, Suit.SPADE));

		BlackjackResult blackjackResult = BlackjackResult.from(cards);

		assertThat(blackjackResult.isFirstBlackJack()).isFalse();
	}
}