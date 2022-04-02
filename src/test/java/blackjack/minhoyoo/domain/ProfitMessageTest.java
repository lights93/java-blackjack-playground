package blackjack.minhoyoo.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProfitMessageTest {

	@Test
	void getMessage() {
		Cards cards = Cards.of(new Card(CardNumber.TWO, Suit.HEART), new Card(CardNumber.EIGHT, Suit.SPADE));
		Player player = new Player(Name.from("pobi"), cards, Money.from("10000"));
		ProfitMessage profitMessage = ProfitMessage.from(player);

		assertThat(profitMessage.getMessage()).isEqualTo("pobi: 10000");
	}
}