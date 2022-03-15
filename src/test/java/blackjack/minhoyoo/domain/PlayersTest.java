package blackjack.minhoyoo.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

	@DisplayName("카드 더하기 테스트")
	@Test
	void addCard() {
		Deck deck = new Deck(() -> {
			Deque<Card> cards = new LinkedList<>();
			cards.push(new Card(CardNumber.TWO, Suit.SPADE));
			cards.push(new Card(CardNumber.ONE, Suit.SPADE));

			return cards;
		});

		Player player1 = new Player(Name.from("name1"), Money.from("1"));
		Player player2 = new Player(Name.from("name1"), Money.from("1"));

		Players players = Players.from(Arrays.asList(player1, player2));

		players.addCard(deck);

		assertThat(player1.getCards()).isEqualTo(Collections.singletonList(new Card(CardNumber.ONE, Suit.SPADE)));
		assertThat(player2.getCards()).isEqualTo(Collections.singletonList(new Card(CardNumber.TWO, Suit.SPADE)));
	}
}