package blackjack.minhoyoo.domain;

public class MoneyCalculator {
	public static Money calculate(Player player) {
		BlackjackResult blackjackResult = player.calculateResult();
		if(blackjackResult.isFirstBlackJack()) {
			return player.getMoney().addHalf();
		}

		return Money.from("0");
	}
}
