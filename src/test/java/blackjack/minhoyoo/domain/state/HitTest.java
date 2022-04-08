package blackjack.minhoyoo.domain.state;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import blackjack.minhoyoo.domain.card.Card;
import blackjack.minhoyoo.domain.card.CardNumber;
import blackjack.minhoyoo.domain.card.Cards;
import blackjack.minhoyoo.domain.card.Suit;

class HitTest {

	@DisplayName("초과 상태로 변경")
	@Test
	void drawToBust() {
		Cards cards = Cards.of(new Card(CardNumber.KING, Suit.SPADE), new Card(CardNumber.FIVE, Suit.SPADE));
		Hit hit = new Hit(cards);

		State state = hit.draw(new Card(CardNumber.SEVEN, Suit.SPADE));
		assertThat(state).isInstanceOf(Bust.class);
	}

	@DisplayName("그대로 상태 유지")
	@Test
	void drawToHit() {
		Cards cards = Cards.of(new Card(CardNumber.KING, Suit.SPADE), new Card(CardNumber.FIVE, Suit.SPADE));
		Hit hit = new Hit(cards);

		State state = hit.draw(new Card(CardNumber.SIX, Suit.CLUB));
		assertThat(state).isInstanceOf(Hit.class);
	}
}