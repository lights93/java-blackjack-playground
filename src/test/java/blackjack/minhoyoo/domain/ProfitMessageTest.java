package blackjack.minhoyoo.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProfitMessageTest {

	@Test
	void getMessage() {
		Player player = new Player(Name.from("pobi"), Money.from("10000"));
		player.addCard(new Card(CardNumber.TWO, Suit.HEART));
		player.addCard(new Card(CardNumber.EIGHT, Suit.SPADE));
		ProfitMessage profitMessage = ProfitMessage.from(player);

		assertThat(profitMessage.getMessage()).isEqualTo("pobi: 10000");
	}
}