package blackjack.minhoyoo.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CardOwnersTest {

	@Test
	void drawCard() {
		CardOwners cardOwners = new CardOwners(
			Collections.singletonList(new Player(Name.from("pobi"), Money.from("1"))), new Dealer());

		Deck deck = new Deck(() -> {
			Deque<Card> cards = new LinkedList<>();
			cards.push(new Card(CardNumber.ONE, Suit.SPADE));
			cards.push(new Card(CardNumber.TWO, Suit.SPADE));

			return cards;
		});

		cardOwners.drawCard(deck);

		Player player = new Player(Name.from("pobi"), Money.from("1"));
		player.addCard(new Card(CardNumber.TWO, Suit.SPADE));
		Dealer dealer = new Dealer();
		dealer.addCard(new Card(CardNumber.ONE, Suit.SPADE));

		CardOwners expected = new CardOwners(Collections.singletonList(player), dealer);

		assertThat(cardOwners).isEqualTo(expected);
	}
}