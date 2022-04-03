package blackjack.minhoyoo.domain.owner;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class NameTest {

	@DisplayName("잘못된 이름 생성 시 에러")
	@NullAndEmptySource
	@ParameterizedTest
	void from(String name) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> Name.from(name))
			.withMessage("잘못된 이름입니다.");
	}
}