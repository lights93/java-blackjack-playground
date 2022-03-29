package blackjack.minhoyoo.domain;

import java.util.Objects;

public class Name {
	private static final int MIN_SIZE = 1;
	private static final String WRONG_NAME = "잘못된 이름입니다.";

	private final String value;

	private Name(String value) {
		if (value == null || value.length() < MIN_SIZE) {
			throw new IllegalArgumentException(WRONG_NAME);
		}
		this.value = value;
	}

	public static Name from(String name) {
		return new Name(name);
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Name name = (Name)o;
		return Objects.equals(value, name.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
