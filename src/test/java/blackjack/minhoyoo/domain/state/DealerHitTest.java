package blackjack.minhoyoo.domain.state;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import blackjack.minhoyoo.domain.card.Card;
import blackjack.minhoyoo.domain.card.CardNumber;
import blackjack.minhoyoo.domain.card.Cards;
import blackjack.minhoyoo.domain.card.Suit;

class DealerHitTest {

	@DisplayName("딜러 엔드 상태로 변경")
	@Test
	void drawToDealerEnd() {
		Cards cards = Cards.of(new Card(CardNumber.SIX, Suit.SPADE), new Card(CardNumber.FOUR, Suit.SPADE));
		DealerHit dealerHit = new DealerHit(cards);

		State state = dealerHit.draw(new Card(CardNumber.SEVEN, Suit.SPADE));
		assertThat(state).isInstanceOf(DealerEnd.class);
	}

	@DisplayName("초과 상태로 변경")
	@Test
	void drawToBust() {
		Cards cards = Cards.of(new Card(CardNumber.KING, Suit.SPADE), new Card(CardNumber.FIVE, Suit.SPADE));
		DealerHit dealerHit = new DealerHit(cards);

		State state = dealerHit.draw(new Card(CardNumber.SEVEN, Suit.SPADE));
		assertThat(state).isInstanceOf(Bust.class);
	}

	@DisplayName("그대로 상태 유지")
	@Test
	void drawToDealerHit() {
		Cards cards = Cards.of(new Card(CardNumber.SIX, Suit.SPADE), new Card(CardNumber.FOUR, Suit.SPADE));
		DealerHit dealerHit = new DealerHit(cards);

		State state = dealerHit.draw(new Card(CardNumber.SIX, Suit.CLUB));
		assertThat(state).isInstanceOf(DealerEnd.class);
	}
}