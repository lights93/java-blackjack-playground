package blackjack.minhoyoo.domain;

import java.util.Objects;

public class Money {
	public static final Money ZERO = new Money(0);
	private static final double FIRST_BLACKJACK_MULTIPLE_VALUE = 1.5;

	private final int value;

	private Money(int value) {
		this.value = value;
	}

	public static Money from(String money) {
		try {
			return new Money(Integer.parseInt(money));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("잘못된 금액입니다.");
		}
	}

	public Money addHalf() {
		return new Money((int)(this.value * FIRST_BLACKJACK_MULTIPLE_VALUE));
	}

	public Money add(Money other) {
		return new Money(this.value + other.value);
	}

	public Money minus(Money other) {
		return new Money(this.value - other.value);
	}

	public Money reverse() {
		return new Money(-value);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Money money = (Money)o;
		return value == money.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
