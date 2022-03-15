package blackjack.minhoyoo.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class MoneyTest {

	@DisplayName("잘못된 이름 생성 시 에러")
	@NullAndEmptySource
	@CsvSource(value = {"a", "-1"})
	@ParameterizedTest
	void fromError(String input) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> Money.from(input))
			.withMessage("잘못된 금액입니다.");
	}
}