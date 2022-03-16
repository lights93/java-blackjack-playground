package blackjack.minhoyoo.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardNumberTest {

	@DisplayName("ACE인지 확인")
	@Test
	void isAce() {
		CardNumber ace = CardNumber.ACE;

		assertThat(ace.isAce()).isTrue();
	}

	@DisplayName("ACE가 아닌지 확인")
	@Test
	void isNotAce() {
		CardNumber ace = CardNumber.KING;

		assertThat(ace.isAce()).isFalse();
	}
}