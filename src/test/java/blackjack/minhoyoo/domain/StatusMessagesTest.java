package blackjack.minhoyoo.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatusMessagesTest {
	@DisplayName("메시지 여러 건 생성")
	@Test
	void getMessage() {
		Player player = new Player(Name.from("pobi"), Money.from("1"));
		player.addCard(new Card(CardNumber.TWO, Suit.HEART));
		player.addCard(new Card(CardNumber.EIGHT, Suit.SPADE));

		Dealer dealer = new Dealer();
		dealer.addCard(new Card(CardNumber.TWO, Suit.HEART));
		dealer.addCard(new Card(CardNumber.EIGHT, Suit.SPADE));

		StatusMessages statusMessages = StatusMessages.from(new CardOwners(Collections.singletonList(player), dealer));

		assertThat(statusMessages.getMessage())
			.isEqualTo("pobi카드: 2하트, 8스페이드\n딜러 카드: 2하트, 8스페이드");
	}
}