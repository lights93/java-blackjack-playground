package blackjack.minhoyoo.domain;

import java.util.Objects;

public class Player extends CardOwner {
	private final Name name;
	private final Money money;

	public Player(Name name, Money money) {
		if(name == null || money == null) {
			throw new IllegalArgumentException("플레이어에 필요한 값이 없습니다.");
		}
		this.name = name;
		this.money = money;
	}

	public Name getName() {
		return name;
	}

	public Money getMoney() {
		return money;
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
		return Objects.equals(name, player.name) && Objects.equals(money, player.money);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), name, money);
	}
}
