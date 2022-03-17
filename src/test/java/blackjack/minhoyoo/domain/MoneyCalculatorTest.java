package blackjack.minhoyoo.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyCalculatorTest {
	@DisplayName("첫 블랙잭일 때 1.5배 되는지 확인")
	@Test
	void firstBlackJackCalculate() {
		Player player = new Player(Name.from("pobi"), Money.from("100"));
		player.addCard(new Card(CardNumber.KING, Suit.HEART));
		player.addCard(new Card(CardNumber.ACE, Suit.SPADE));

		assertThat(MoneyCalculator.calculate(player)).isEqualTo(Money.from("150"));
	}
}