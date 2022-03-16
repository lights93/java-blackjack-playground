package blackjack.minhoyoo.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardTest {

	@DisplayName("ACE인지 확인")
	@Test
	void isAceTrue() {
		Card card = new Card(CardNumber.ACE, Suit.SPADE);

		assertThat(card.isAce()).isTrue();
	}

	@DisplayName("ACE가 아닌지 확인")
	@Test
	void isAceFalse() {
		Card card = new Card(CardNumber.ONE, Suit.SPADE);

		assertThat(card.isAce()).isFalse();
	}
}