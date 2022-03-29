package blackjack.minhoyoo.domain;

import java.util.List;
import java.util.Objects;

public abstract class CardOwner {
	private final Cards cards = Cards.empty();
	private Money money;

	protected CardOwner(Money money) {
		if(money == null) {
			throw new IllegalArgumentException("금액 입력이 필요합니다.");
		}
		this.money = money;
	}

	public void addCard(Card card) {
		cards.addCard(card);
	}

	public Money getMoney() {
		return money;
	}

	public List<Card> getCards() {
		return cards.getAll();
	}

	public BlackjackResult calculateResult() {
		return BlackjackResult.from(cards);
	}

	public void updateFirstBlackJackMoney() {
		money = money.addHalf();
	}

	public void updateMoney(Money money) {
		this.money = money;
	}

	public void lose() {
		this.money = money.reverse();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CardOwner cardOwner = (CardOwner)o;
		return Objects.equals(cards, cardOwner.cards);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cards);
	}
}
