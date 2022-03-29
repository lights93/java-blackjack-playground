package blackjack.minhoyoo.domain;

public class BlackjackResult {
	private static final int BLACK_JACK = 21;
	private static final int INIT_SIZE = 2;
	public static final int DEALER_MIN_NUMBER = 17;
	private final int result;
	private final boolean isFirst;

	private BlackjackResult(Cards cards) {
		this.result = cards.calculateResult();
		this.isFirst = cards.size() == INIT_SIZE;
	}

	public static BlackjackResult from(Cards cards) {
		return new BlackjackResult(cards);
	}

	public boolean isBlackjack() {
		return result == BLACK_JACK;
	}

	public boolean isFirstBlackJack() {
		return isBlackjack() && isFirst;
	}

	public boolean isBlackjackOrMore() {
		return result >= BLACK_JACK;
	}

	public boolean isDealerEnd() {
		return result >= DEALER_MIN_NUMBER;
	}
}
