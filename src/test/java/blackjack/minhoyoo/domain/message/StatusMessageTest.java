package blackjack.minhoyoo.domain.message;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import blackjack.minhoyoo.domain.Money;
import blackjack.minhoyoo.domain.card.Card;
import blackjack.minhoyoo.domain.card.CardNumber;
import blackjack.minhoyoo.domain.card.Cards;
import blackjack.minhoyoo.domain.card.Suit;
import blackjack.minhoyoo.domain.owner.CardOwner;
import blackjack.minhoyoo.domain.owner.Dealer;
import blackjack.minhoyoo.domain.owner.Name;
import blackjack.minhoyoo.domain.owner.Player;

class StatusMessageTest {

	@DisplayName("player일 때 메시지 생성")
	@Test
	void getMessageWhenPlayer() {
		Player player = new Player(Name.from("pobi"), Cards.empty(), Money.from("1"));
		player.addCard(new Card(CardNumber.TWO, Suit.HEART));
		player.addCard(new Card(CardNumber.EIGHT, Suit.SPADE));

		StatusMessage statusMessage = StatusMessage.from(player);

		assertThat(statusMessage.getMessage()).isEqualTo("pobi카드: 2하트, 8스페이드");
	}

	@DisplayName("딜러일 때 메시지 생성")
	@Test
	void getMessageWhenDealer() {
		Dealer dealer = new Dealer(Cards.empty());
		dealer.addCard(new Card(CardNumber.TWO, Suit.HEART));
		dealer.addCard(new Card(CardNumber.EIGHT, Suit.SPADE));

		StatusMessage statusMessage = StatusMessage.from(dealer);

		assertThat(statusMessage.getMessage()).isEqualTo("딜러 카드: 2하트, 8스페이드");
	}

	@DisplayName("player일 때 메시지 결과와 함께 생성")
	@Test
	void getMessageWithResultWhenPlayer() {
		Player player = new Player(Name.from("pobi"), Cards.empty(), Money.from("1"));
		player.addCard(new Card(CardNumber.TWO, Suit.HEART));
		player.addCard(new Card(CardNumber.EIGHT, Suit.SPADE));

		StatusMessage statusMessage = StatusMessage.from(player);

		assertThat(statusMessage.getMessageWithResult()).isEqualTo("pobi카드: 2하트, 8스페이드 - 결과: 10");
	}

	@DisplayName("딜러일 때 메시지 생성")
	@Test
	void getMessageWithResulWhenDealer() {
		Dealer dealer = new Dealer(Cards.empty());
		dealer.addCard(new Card(CardNumber.TWO, Suit.HEART));
		dealer.addCard(new Card(CardNumber.EIGHT, Suit.SPADE));

		StatusMessage statusMessage = StatusMessage.from(dealer);

		assertThat(statusMessage.getMessageWithResult()).isEqualTo("딜러 카드: 2하트, 8스페이드 - 결과: 10");
	}

	@DisplayName("잘못된 타입으로 들어올 때 에러")
	@Test
	void getMessageError() {
		CardOwner cardOwner = new CardOwner(Cards.empty(), Money.ZERO) {
		};

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> StatusMessage.from(cardOwner))
			.withMessage("잘못된 카드 주인 타입입니다.");
	}
}