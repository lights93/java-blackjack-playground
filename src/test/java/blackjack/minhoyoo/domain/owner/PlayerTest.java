package blackjack.minhoyoo.domain.owner;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import blackjack.minhoyoo.domain.Money;
import blackjack.minhoyoo.domain.card.Cards;

class PlayerTest {
	@DisplayName("이름 값 비어있을 때 에러")
	@Test
	void constructErrorWithNameNull() {
		Money money = Money.from("1");
		Cards cards = Cards.empty();

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new Player(null, cards, money))
			.withMessage("플레이어에 필요한 값이 없습니다.");
	}
}