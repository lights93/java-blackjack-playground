package blackjack.minhoyoo.domain;

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

		assertThat(cards.calculate()).isEqualTo(25);
	}

	@DisplayName("ACE가 1로 계산")
	@Test
	void calculateWithAceValueIsOne() {
		Cards cards = Cards.empty();
		cards.addCard(new Card(CardNumber.KING, Suit.SPADE));
		cards.addCard(new Card(CardNumber.ONE, Suit.SPADE));
		cards.addCard(new Card(CardNumber.ACE, Suit.SPADE));

		assertThat(cards.calculate()).isEqualTo(12);
	}

	@DisplayName("ACE가 11로 계산")
	@Test
	void calculateWithAceValueIsEleven() {
		Cards cards = Cards.empty();
		cards.addCard(new Card(CardNumber.KING, Suit.SPADE));
		cards.addCard(new Card(CardNumber.ACE, Suit.SPADE));

		assertThat(cards.calculate()).isEqualTo(21);
	}
}