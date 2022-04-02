package blackjack.minhoyoo.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardOwnerTest {
	@DisplayName("카드 추가 테스트")
	@Test
	void addCard() {
		Dealer dealer = new Dealer(Cards.empty());
		dealer.addCard(new Card(CardNumber.ACE, Suit.SPADE));

		assertThat(dealer.getCards()).isEqualTo(Arrays.asList(new Card(CardNumber.ACE, Suit.SPADE)));
	}

	@DisplayName("베팅금 값 비어있을 때 에러")
	@Test
	void constructErrorWithMoneyNull() {
		Cards cards = Cards.empty();
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new CardOwner(cards, null) {
			})
			.withMessage("금액 입력이 필요합니다.");
	}

	@DisplayName("카드 null일 때 에러")
	@Test
	void constructErrorWithCardsNull() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new CardOwner(null, Money.ZERO) {
			})
			.withMessage("카드가 필요합니다.");
	}
}