package blackjack.minhoyoo.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class MoneyTest {

	@DisplayName("잘못된 이름 생성 시 에러")
	@NullAndEmptySource
	@CsvSource(value = {"a"})
	@ParameterizedTest
	void fromError(String input) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> Money.from(input))
			.withMessage("잘못된 금액입니다.");
	}

	@DisplayName("1.5배")
	@Test
	void addHalf() {
		Money money10 = Money.from("10");

		assertThat(money10.addOneAndHalf()).isEqualTo(Money.from("25"));
	}

	@DisplayName("곱하기")
	@Test
	void add() {
		Money money10 = Money.from("10");
		Money money6 = Money.from("6");

		assertThat(money10.add(money6)).isEqualTo(Money.from("16"));
	}

	@DisplayName("빼기")
	@Test
	void minus() {
		Money money10 = Money.from("10");
		Money money6 = Money.from("6");

		assertThat(money10.minus(money6)).isEqualTo(Money.from("4"));
	}

	@DisplayName("반전")
	@Test
	void reverse() {
		Money money10 = Money.from("10");

		assertThat(money10.reverse()).isEqualTo(Money.from("-10"));
	}
}