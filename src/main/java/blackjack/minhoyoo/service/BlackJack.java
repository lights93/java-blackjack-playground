package blackjack.minhoyoo.service;

import java.util.stream.Collectors;

import blackjack.minhoyoo.domain.Dealer;
import blackjack.minhoyoo.domain.Deck;
import blackjack.minhoyoo.domain.Money;
import blackjack.minhoyoo.domain.Names;
import blackjack.minhoyoo.domain.Player;
import blackjack.minhoyoo.domain.Players;
import blackjack.minhoyoo.domain.RandomShuffleStrategy;
import blackjack.minhoyoo.domain.StatusMessage;
import blackjack.minhoyoo.view.InputView;
import blackjack.minhoyoo.view.ResultView;

public class BlackJack {
	private BlackJack() {
	}

	public static void start() {
		Players players = getPlayers(getNames());
		Dealer dealer = new Dealer();

		Deck deck = new Deck(new RandomShuffleStrategy());

		initCards(players, dealer, deck);
		printStatus(players, dealer);
	}

	private static void printStatus(Players players, Dealer dealer) {
		players.getElements()
			.stream()
			.map(player -> StatusMessage.from(player).getMessage())
			.forEach(ResultView::printMessage);

		ResultView.printMessage(StatusMessage.from(dealer).getMessage());
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

	private static void initCards(Players players, Dealer dealer, Deck deck) {
		players.addCard(deck);
		players.addCard(deck);
		dealer.addCard(deck.draw());
		dealer.addCard(deck.draw());
	}
}
