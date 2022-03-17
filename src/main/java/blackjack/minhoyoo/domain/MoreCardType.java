package blackjack.minhoyoo.domain;

public enum MoreCardType {
	Y,
	N;

	public static MoreCardType from(String input) {
		return MoreCardType.valueOf(input.toUpperCase());
	}

	public boolean isMore() {
		return this == Y;
	}
}
