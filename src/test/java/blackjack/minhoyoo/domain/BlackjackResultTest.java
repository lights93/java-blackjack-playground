package blackjack.minhoyoo.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BlackjackResultTest {
	private Cards blackjackCards;
	private Cards firstBlackjackCards;
	private Cards overBlackjackCards;
	@BeforeEach
	void setUp() {
		blackjackCards = Cards.empty();
		blackjackCards.addCard(new Card(CardNumber.KING, Suit.SPADE));
		blackjackCards.addCard(new Card(CardNumber.ONE, Suit.SPADE));
		blackjackCards.addCard(new Card(CardNumber.JACK, Suit.SPADE));

		firstBlackjackCards = Cards.empty();
		firstBlackjackCards.addCard(new Card(CardNumber.KING, Suit.SPADE));
		firstBlackjackCards.addCard(new Card(CardNumber.ACE, Suit.SPADE));

		overBlackjackCards = Cards.empty();
		overBlackjackCards.addCard(new Card(CardNumber.KING, Suit.SPADE));
		overBlackjackCards.addCard(new Card(CardNumber.TWO, Suit.SPADE));
		overBlackjackCards.addCard(new Card(CardNumber.JACK, Suit.SPADE));
	}

	@DisplayName("블랙잭인지 확인")
	@Test
	void isBlackjackTrue() {
		BlackjackResult blackjackResult = BlackjackResult.from(blackjackCards);

		assertThat(blackjackResult.isBlackjack()).isTrue();
	}

	@DisplayName("블랙잭 아닌 것 확인")
	@Test
	void isBlackjackFalse() {
		BlackjackResult blackjackResult = BlackjackResult.from(overBlackjackCards);

		assertThat(blackjackResult.isBlackjack()).isFalse();
	}


	@DisplayName("첫 블랙잭인지 확인")
	@Test
	void isFirstBlackjackTrue() {
		BlackjackResult blackjackResult = BlackjackResult.from(firstBlackjackCards);

		assertThat(blackjackResult.isFirstBlackJack()).isTrue();
	}

	@DisplayName("첫 블랙잭 아닌 것 확인")
	@Test
	void isFirstBlackjackFalse() {
		BlackjackResult blackjackResult = BlackjackResult.from(blackjackCards);

		assertThat(blackjackResult.isFirstBlackJack()).isFalse();
	}

	@DisplayName("21을 넘음")
	@Test
	void isOverBlackjackTrue() {
		BlackjackResult blackjackResult = BlackjackResult.from(overBlackjackCards);

		assertThat(blackjackResult.isOverBlackjack()).isTrue();
	}

	@DisplayName("21 이하")
	@Test
	void isOverBlackjackFalse() {
		BlackjackResult blackjackResult = BlackjackResult.from(blackjackCards);

		assertThat(blackjackResult.isOverBlackjack()).isFalse();
	}

	@DisplayName("17 이상")
	@Test
	void isDealerEndTrue() {
		Cards cards = Cards.empty();
		cards.addCard(new Card(CardNumber.KING, Suit.SPADE));
		cards.addCard(new Card(CardNumber.SEVEN, Suit.SPADE));
		BlackjackResult blackjackResult = BlackjackResult.from(cards);

		assertThat(blackjackResult.isDealerEnd()).isTrue();
	}

	@DisplayName("16 이하")
	@Test
	void isDealerEndFalse() {
		Cards cards = Cards.empty();
		cards.addCard(new Card(CardNumber.KING, Suit.SPADE));
		cards.addCard(new Card(CardNumber.SIX, Suit.SPADE));
		BlackjackResult blackjackResult = BlackjackResult.from(cards);

		assertThat(blackjackResult.isDealerEnd()).isFalse();
	}
}