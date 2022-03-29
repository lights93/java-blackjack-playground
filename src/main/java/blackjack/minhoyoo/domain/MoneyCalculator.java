package blackjack.minhoyoo.domain;

public class MoneyCalculator {
	private MoneyCalculator() {
	}

	public static Money calculate(Player player, boolean isDealerBlackjack) {
		BlackjackResult blackjackResult = player.calculateResult();
		if(blackjackResult.isFirstBlackJack()) {
			return player.getMoney().addHalf();
		}

		return Money.from("0");
	}
}
