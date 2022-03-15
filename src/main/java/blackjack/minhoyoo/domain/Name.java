package blackjack.minhoyoo.domain;

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
}
