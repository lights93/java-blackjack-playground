package blackjack.minhoyoo.service;

import java.util.stream.Collectors;

import blackjack.minhoyoo.domain.Money;
import blackjack.minhoyoo.domain.Names;
import blackjack.minhoyoo.domain.Player;
import blackjack.minhoyoo.domain.Players;
import blackjack.minhoyoo.view.InputView;
import blackjack.minhoyoo.view.ResultView;

public class BlackJack {
	private BlackJack() {
	}

	public static void start() {
		Players players = getPlayers(getNames());
	}

	private static Names getNames() {
		try {
			return Names.from(InputView.getNames());
		} catch (IllegalArgumentException e) {
			ResultView.printMessage(e.getMessage());
			return getNames();
		}
	}

	private static Money getMoney(String name) {
		try {
			return Money.from(InputView.getMoney(name));
		} catch (IllegalArgumentException e) {
			ResultView.printMessage(e.getMessage());
			return getMoney(name);
		}
	}

	private static Players getPlayers(Names names) {
		return Players.from(names.getValues().stream()
			.map(name -> new Player(name, getMoney(name.getValue())))
			.collect(Collectors.toList()));
	}
}
