package blackjack.minhoyoo.domain;

import java.util.Objects;

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

	public int getValue() {
		return value;
	}

	public Money addHalf() {
		return new Money((int)(this.value * 1.5));
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
