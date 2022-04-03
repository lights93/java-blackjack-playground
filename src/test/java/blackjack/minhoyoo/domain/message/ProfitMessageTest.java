package blackjack.minhoyoo.domain.message;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import blackjack.minhoyoo.domain.Money;
import blackjack.minhoyoo.domain.card.Card;
import blackjack.minhoyoo.domain.card.CardNumber;
import blackjack.minhoyoo.domain.card.Cards;
import blackjack.minhoyoo.domain.card.Suit;
import blackjack.minhoyoo.domain.owner.Name;
import blackjack.minhoyoo.domain.owner.Player;

class ProfitMessageTest {

	@Test
	void getMessage() {
		Cards cards = Cards.of(new Card(CardNumber.TWO, Suit.HEART), new Card(CardNumber.EIGHT, Suit.SPADE));
		Player player = new Player(Name.from("pobi"), cards, Money.from("10000"));
		ProfitMessage profitMessage = ProfitMessage.from(player);

		assertThat(profitMessage.getMessage()).isEqualTo("pobi: 10000");
	}
}