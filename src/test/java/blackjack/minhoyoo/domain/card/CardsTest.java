package blackjack.minhoyoo.domain.card;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardsTest {
	@DisplayName("ACE가 없을 때 점수 계산")
	@Test
	void calculate() {
		Cards cards = Cards.empty();
		cards.addCard(new Card(CardNumber.KING, Suit.SPADE));
		cards.addCard(new Card(CardNumber.NINE, Suit.SPADE));
		cards.addCard(new Card(CardNumber.SIX, Suit.SPADE));

		assertThat(cards.calculateResult()).isEqualTo(25);
	}

	@DisplayName("ACE가 1로 계산")
	@Test
	void calculateWithAceValueIsOne() {
		Cards cards = Cards.empty();
		cards.addCard(new Card(CardNumber.NINE, Suit.SPADE));
		cards.addCard(new Card(CardNumber.TWO, Suit.SPADE));
		cards.addCard(new Card(CardNumber.ACE, Suit.SPADE));

		assertThat(cards.calculateResult()).isEqualTo(12);
	}

	@DisplayName("ACE가 11로 계산")
	@Test
	void calculateWithAceValueIsEleven() {
		Cards cards = Cards.empty();
		cards.addCard(new Card(CardNumber.KING, Suit.SPADE));
		cards.addCard(new Card(CardNumber.ACE, Suit.SPADE));

		assertThat(cards.calculateResult()).isEqualTo(21);
	}

	@DisplayName("bust 상태")
	@Test
	void isBustTrue() {
		Cards cards = Cards.empty();
		cards.addCard(new Card(CardNumber.QUEEN, Suit.SPADE));
		cards.addCard(new Card(CardNumber.TWO, Suit.SPADE));
		cards.addCard(new Card(CardNumber.KING, Suit.SPADE));

		assertThat(cards.isBust()).isTrue();
	}

	@DisplayName("bust 상태 아님")
	@Test
	void isBustFalse() {
		Cards cards = Cards.empty();
		cards.addCard(new Card(CardNumber.NINE, Suit.SPADE));
		cards.addCard(new Card(CardNumber.TWO, Suit.SPADE));
		cards.addCard(new Card(CardNumber.KING, Suit.SPADE));

		assertThat(cards.isBust()).isFalse();
	}

	@DisplayName("딜러 자동뽑기 종료 상태 아님")
	@Test
	void isDealerEndFalse() {
		Cards cards = Cards.empty();
		cards.addCard(new Card(CardNumber.KING, Suit.SPADE));
		cards.addCard(new Card(CardNumber.SIX, Suit.SPADE));

		assertThat(cards.isDealerEnd()).isFalse();
	}

	@DisplayName("딜러 자동뽑기 종료 상태")
	@Test
	void isDealerEndTrue() {
		Cards cards = Cards.empty();
		cards.addCard(new Card(CardNumber.KING, Suit.SPADE));
		cards.addCard(new Card(CardNumber.SEVEN, Suit.SPADE));

		assertThat(cards.isDealerEnd()).isTrue();
	}
}