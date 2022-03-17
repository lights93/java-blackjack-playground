package blackjack.minhoyoo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import blackjack.minhoyoo.domain.BlackjackResult;
import blackjack.minhoyoo.domain.CardOwner;
import blackjack.minhoyoo.domain.Dealer;
import blackjack.minhoyoo.domain.Deck;
import blackjack.minhoyoo.domain.Money;
import blackjack.minhoyoo.domain.Names;
import blackjack.minhoyoo.domain.Player;
import blackjack.minhoyoo.domain.RandomShuffleStrategy;
import blackjack.minhoyoo.domain.StatusMessage;
import blackjack.minhoyoo.view.InputView;
import blackjack.minhoyoo.view.ResultView;

public class BlackJack {
	private BlackJack() {
	}

	public static void start() {
		List<Player> players = getPlayers(getNames());
		List<CardOwner> cardOwners = new ArrayList<>(players);
		cardOwners.add(new Dealer());

		Deck deck = new Deck(new RandomShuffleStrategy());

		drawCard(cardOwners, deck);
		drawCard(cardOwners, deck);
		printStatus(cardOwners);

		if (isFirstBlackjack(players)) {
			printResult(players);
			return;
		}

	}

	private static void printResult(List<Player> players) {
		// TODO
	}

	private static boolean isFirstBlackjack(List<Player> players) {
		return players.stream()
			.map(CardOwner::calculateResult)
			.anyMatch(BlackjackResult::isFirstBlackJack);
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

	private static List<Player> getPlayers(Names names) {
		return names.getValues().stream()
			.map(name -> new Player(name, getMoney(name.getValue())))
			.collect(Collectors.toList());
	}

	private static void drawCard(List<CardOwner> cardOwners, Deck deck) {
		cardOwners.forEach(cardOwner -> cardOwner.addCard(deck.draw()));
	}

	private static void printStatus(List<CardOwner> cardOwners) {
		cardOwners.stream()
			.map(cardOwner -> StatusMessage.from(cardOwner).getMessage())
			.forEach(ResultView::printMessage);
	}
}
