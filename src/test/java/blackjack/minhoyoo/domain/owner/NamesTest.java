package blackjack.minhoyoo.domain.owner;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NamesTest {

	@DisplayName("이름 생성")
	@Test
	void from() {
		Names names = Names.from("pobi,jason");

		assertThat(names.size()).isEqualTo(2);
	}
}