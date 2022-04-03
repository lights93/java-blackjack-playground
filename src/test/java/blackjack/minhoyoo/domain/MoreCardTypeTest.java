package blackjack.minhoyoo.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoreCardTypeTest {

	@DisplayName("카드 더 입려인지 획인")
	@Test
	void isMore() {
		assertThat(MoreCardType.Y.isMore()).isTrue();
		assertThat(MoreCardType.N.isMore()).isFalse();
	}
}