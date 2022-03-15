package blackjack.minhoyoo.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardOwnerTest {
	@DisplayName("카드 추가 테스트")
	@Test
	void addCard() {
		Dealer dealer = new Dealer();
		dealer.addCard(new Card(CardNumber.ACE, Suit.SPADE));

		assertThat(dealer.getCards()).isEqualTo(Arrays.asList(new Card(CardNumber.ACE, Suit.SPADE)));
	}
}