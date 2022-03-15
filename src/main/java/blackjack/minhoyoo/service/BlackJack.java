package blackjack.minhoyoo.service;

import blackjack.minhoyoo.domain.Names;
import blackjack.minhoyoo.view.InputView;
import blackjack.minhoyoo.view.ResultView;

public class BlackJack {
	private BlackJack() {
	}

	public static void start() {
		Names names = getNames();
	}

	private static Names getNames() {
		try {
			return Names.from(InputView.getNames());
		} catch (IllegalArgumentException e) {
			ResultView.printMessage(e.getMessage());
			return getNames();
		}
	}
}
