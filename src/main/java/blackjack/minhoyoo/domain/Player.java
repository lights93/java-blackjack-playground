package blackjack.minhoyoo.domain;

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
}
