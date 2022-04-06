package blackjack.minhoyoo.domain.owner;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import blackjack.minhoyoo.domain.Money;
import blackjack.minhoyoo.domain.card.Card;
import blackjack.minhoyoo.domain.card.CardNumber;
import blackjack.minhoyoo.domain.card.Cards;
import blackjack.minhoyoo.domain.card.Suit;
import blackjack.minhoyoo.domain.state.State;
import blackjack.minhoyoo.domain.state.StateFactory;

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
		State state = StateFactory.create(Cards.empty());
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new CardOwner(state, null) {
			})
			.withMessage("금액 입력이 필요합니다.");
	}

	@DisplayName("카드 null일 때 에러")
	@Test
	void constructErrorWithCardsNull() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new CardOwner(null, Money.ZERO) {
			})
			.withMessage("상태값이 필요합니다.");
	}
}