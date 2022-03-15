package blackjack.minhoyoo.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {
	@DisplayName("이름 값 비어있을 때 에러")
	@Test
	void constructErrorWithNameNull() {
		Money money = Money.from("1");

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new Player(null, money))
			.withMessage("플레이어에 필요한 값이 없습니다.");
	}

	@DisplayName("베팅금 값 비어있을 때 에러")
	@Test
	void constructErrorWithMoneyNull() {
		Name name = Name.from("name");

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new Player(name, null))
			.withMessage("플레이어에 필요한 값이 없습니다.");
	}
}