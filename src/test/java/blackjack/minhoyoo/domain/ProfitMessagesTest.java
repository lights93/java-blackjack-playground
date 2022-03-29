package blackjack.minhoyoo.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitMessagesTest {

	@DisplayName("메시지 여러 건 생성")
	@Test
	void getMessage() {
		Player player1 = new Player(Name.from("pobi"), Money.from("10000"));
		Player player2 = new Player(Name.from("jason"), Money.from("-20000"));

		Dealer dealer = new Dealer();
		dealer.updateMoney(Money.from("10000"));

		ProfitMessages profitMessages = ProfitMessages.from(new CardOwners(Arrays.asList(player1, player2), dealer));

		assertThat(profitMessages.getMessage())
			.isEqualTo("pobi: 10000\n"
				+ "jason: -20000\n"
				+ "딜러: 10000");
	}
}