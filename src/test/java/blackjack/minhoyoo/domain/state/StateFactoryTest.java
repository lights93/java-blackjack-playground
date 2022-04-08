package blackjack.minhoyoo.domain.state;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import blackjack.minhoyoo.domain.card.Card;
import blackjack.minhoyoo.domain.card.CardNumber;
import blackjack.minhoyoo.domain.card.Cards;
import blackjack.minhoyoo.domain.card.Suit;

class StateFactoryTest {
	private Cards firstBlackjackCards;
	private Cards lessBlackjackCards;
	private Cards overBlackjackCards;

	@BeforeEach
	void setUp() {
		firstBlackjackCards = Cards.empty();
		firstBlackjackCards.addCard(new Card(CardNumber.KING, Suit.SPADE));
		firstBlackjackCards.addCard(new Card(CardNumber.ACE, Suit.SPADE));

		lessBlackjackCards = Cards.empty();
		lessBlackjackCards.addCard(new Card(CardNumber.EIGHT, Suit.SPADE));
		lessBlackjackCards.addCard(new Card(CardNumber.TWO, Suit.SPADE));
		lessBlackjackCards.addCard(new Card(CardNumber.JACK, Suit.SPADE));

		overBlackjackCards = Cards.of(new Card(CardNumber.KING, Suit.HEART), new Card(CardNumber.QUEEN, Suit.HEART), new Card(CardNumber.TWO, Suit.HEART));
	}

	@DisplayName("블랙잭 생성")
	@Test
	void createBlackjack() {
		State state = StateFactory.create(firstBlackjackCards);
		assertThat(state).isInstanceOf(Blackjack.class);
	}

	@DisplayName("블랙잭 초과 상태 생성")
	@Test
	void createBust() {
		State state = StateFactory.create(overBlackjackCards);
		assertThat(state).isInstanceOf(Bust.class);
	}

	@DisplayName("블랙잭 미만 상태 생성")
	@Test
	void createHit() {
		State state = StateFactory.create(lessBlackjackCards);
		assertThat(state).isInstanceOf(Hit.class);
	}

	@DisplayName("딜러 블랙잭 상태 생성")
	@Test
	void createDealerBlackjack() {
		State state = StateFactory.createDealerState(firstBlackjackCards);
		assertThat(state).isInstanceOf(Blackjack.class);
	}

	@DisplayName("딜러 블랙잭 미만 상태 생성")
	@Test
	void createDealerHit() {
		Cards dealerNotEndCards = Cards.of(new Card(CardNumber.SIX, Suit.HEART), new Card(CardNumber.KING, Suit.HEART));

		State state = StateFactory.createDealerState(dealerNotEndCards);
		assertThat(state).isInstanceOf(DealerHit.class);
	}

	@DisplayName("딜러 블랙잭 자동뽑기 초과 상태 생성")
	@Test
	void createDealerEnd() {

		State state = StateFactory.createDealerState(lessBlackjackCards);
		assertThat(state).isInstanceOf(DealerEnd.class);
	}

	@DisplayName("딜러 블랙잭 초과 상태 생성")
	@Test
	void createDealerBust() {
		State state = StateFactory.createDealerState(overBlackjackCards);
		assertThat(state).isInstanceOf(Bust.class);
	}
}