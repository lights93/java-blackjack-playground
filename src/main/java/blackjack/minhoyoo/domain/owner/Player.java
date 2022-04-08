package blackjack.minhoyoo.domain.owner;

import java.util.Objects;

import blackjack.minhoyoo.domain.Money;
import blackjack.minhoyoo.domain.card.Cards;
import blackjack.minhoyoo.domain.state.StateFactory;

public class Player extends CardOwner {
	private final Name name;

	public Player(Name name, Cards cards, Money money) {
		super(StateFactory.create(cards), money);
		if (name == null) {
			throw new IllegalArgumentException("플레이어에 필요한 값이 없습니다.");
		}
		this.name = name;
	}

	public Name getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;
		Player player = (Player)o;
		return Objects.equals(name, player.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), name);
	}

	public void lose() {
		money = money.reverse();
	}
}
