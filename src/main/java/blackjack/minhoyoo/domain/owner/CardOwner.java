package blackjack.minhoyoo.domain.owner;

import java.util.List;
import java.util.Objects;

import blackjack.minhoyoo.domain.Money;
import blackjack.minhoyoo.domain.card.Card;
import blackjack.minhoyoo.domain.state.Blackjack;
import blackjack.minhoyoo.domain.state.Bust;
import blackjack.minhoyoo.domain.state.State;

public abstract class CardOwner {
	protected State state;
	protected Money money;

	protected CardOwner(State state, Money money) {
		if (money == null) {
			throw new IllegalArgumentException("금액 입력이 필요합니다.");
		}
		if (state == null) {
			throw new IllegalArgumentException("상태값이 필요합니다.");
		}
		this.state = state;
		this.money = money;
	}

	public void addCard(Card card) {
		state = state.draw(card);
	}

	public State getState() {
		return state;
	}

	public int calculateResult() {
		return state.cards().calculateResult();
	}

	public Money getMoney() {
		return money;
	}

	public List<Card> getCards() {
		return state.cards().getAll();
	}

	public void updateMoney(Money money) {
		this.money = money;
	}

	public void win() {
		money = state.profit(money);
	}

	public boolean isFinished() {
		return state.isFinished();
	}

	public void stay() {
		state.stay();
	}

	public boolean isBlackjack() {
		return state instanceof Blackjack;
	}

	public boolean isBust() {
		return state instanceof Bust;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CardOwner cardOwner = (CardOwner)o;
		return Objects.equals(state, cardOwner.state) && Objects.equals(money, cardOwner.money);
	}

	@Override
	public int hashCode() {
		return Objects.hash(state, money);
	}
}
