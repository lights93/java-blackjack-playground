package blackjack.minhoyoo.domain;

public class Money {
	private static final int MIN_MONEY = 0;
	private final int value;

	private Money(int value) {
		if (value < MIN_MONEY) {
			throw new IllegalArgumentException("잘못된 금액입니다.");
		}
		this.value = value;
	}

	public static Money from(String money) {
		try {
			return new Money(Integer.parseInt(money));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("잘못된 금액입니다.");
		}
	}
}
