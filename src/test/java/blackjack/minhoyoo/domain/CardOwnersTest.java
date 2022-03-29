package blackjack.minhoyoo.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardOwnersTest {
	private Cards blackjackCards;
	private Cards firstBlackjackCards;
	private Cards lessBlackjackCards;
	@BeforeEach
	void setUp() {
		blackjackCards = Cards.empty();
		blackjackCards.addCard(new Card(CardNumber.KING, Suit.SPADE));
		blackjackCards.addCard(new Card(CardNumber.ONE, Suit.SPADE));
		blackjackCards.addCard(new Card(CardNumber.JACK, Suit.SPADE));

		firstBlackjackCards = Cards.empty();
		firstBlackjackCards.addCard(new Card(CardNumber.KING, Suit.SPADE));
		firstBlackjackCards.addCard(new Card(CardNumber.ACE, Suit.SPADE));

		lessBlackjackCards = Cards.empty();
		lessBlackjackCards.addCard(new Card(CardNumber.EIGHT, Suit.SPADE));
		lessBlackjackCards.addCard(new Card(CardNumber.TWO, Suit.SPADE));
		lessBlackjackCards.addCard(new Card(CardNumber.JACK, Suit.SPADE));
	}

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

	@DisplayName("처음 두 장의 카드 합이 21일 경우 블랙잭이 되면 베팅 금액의 1.5 배를 딜러에게 받는다")
	@Test
	void updateMoney() {
		Player player1 = new Player(Name.from("pobi"), Money.from("100"));

		player1.addCard(new Card(CardNumber.KING, Suit.SPADE));
		player1.addCard(new Card(CardNumber.ACE, Suit.SPADE));

		Player player2 = new Player(Name.from("minho"), Money.from("100"));

		player2.addCard(new Card(CardNumber.EIGHT, Suit.SPADE));
		player2.addCard(new Card(CardNumber.KING, Suit.SPADE));

		Dealer dealer = new Dealer();

		CardOwners cardOwners = new CardOwners(
			Arrays.asList(player1, player2), dealer);

		cardOwners.updateMoney();

		assertAll(
			() -> assertThat(player1.getMoney()).isEqualTo(Money.from("250")),
			() -> assertThat(player2.getMoney()).isEqualTo(Money.from("-100")),
			() -> assertThat(dealer.getMoney()).isEqualTo(Money.from("50"))
		);
	}
}