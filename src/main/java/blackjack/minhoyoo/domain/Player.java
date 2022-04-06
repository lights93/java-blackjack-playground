package blackjack.minhoyoo.domain;

import java.util.Objects;

public class Player extends CardOwner {
	private final Name name;

	public Player(Name name, Cards cards, Money money) {
		super(cards, money);
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
}
