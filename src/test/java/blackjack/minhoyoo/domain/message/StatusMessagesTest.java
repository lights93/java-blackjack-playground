package blackjack.minhoyoo.domain.message;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import blackjack.minhoyoo.domain.Money;
import blackjack.minhoyoo.domain.card.Card;
import blackjack.minhoyoo.domain.card.CardNumber;
import blackjack.minhoyoo.domain.card.Cards;
import blackjack.minhoyoo.domain.card.Suit;
import blackjack.minhoyoo.domain.owner.CardOwners;
import blackjack.minhoyoo.domain.owner.Dealer;
import blackjack.minhoyoo.domain.owner.Name;
import blackjack.minhoyoo.domain.owner.Player;

class StatusMessagesTest {
	@DisplayName("메시지 여러 건 생성")
	@Test
	void getMessage() {
		Player player = new Player(Name.from("pobi"), Cards.empty(), Money.from("1"));
		player.addCard(new Card(CardNumber.TWO, Suit.HEART));
		player.addCard(new Card(CardNumber.EIGHT, Suit.SPADE));

		Dealer dealer = new Dealer(Cards.empty());
		dealer.addCard(new Card(CardNumber.TWO, Suit.HEART));
		dealer.addCard(new Card(CardNumber.EIGHT, Suit.SPADE));

		StatusMessages statusMessages = StatusMessages.from(new CardOwners(Collections.singletonList(player), dealer));

		assertThat(statusMessages.getMessage())
			.isEqualTo("pobi카드: 2하트, 8스페이드\n딜러 카드: 2하트, 8스페이드");
	}
}