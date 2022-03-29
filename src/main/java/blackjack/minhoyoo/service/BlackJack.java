package blackjack.minhoyoo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import blackjack.minhoyoo.domain.BlackjackResult;
import blackjack.minhoyoo.domain.CardOwner;
import blackjack.minhoyoo.domain.Dealer;
import blackjack.minhoyoo.domain.Deck;
import blackjack.minhoyoo.domain.Money;
import blackjack.minhoyoo.domain.MoreCardType;
import blackjack.minhoyoo.domain.Names;
import blackjack.minhoyoo.domain.Player;
import blackjack.minhoyoo.domain.RandomShuffleStrategy;
import blackjack.minhoyoo.domain.StatusMessage;
import blackjack.minhoyoo.view.InputView;
import blackjack.minhoyoo.view.ResultView;

public class BlackJack {
	private static final Deck deck = new Deck(new RandomShuffleStrategy());

	public void start() {
		List<Player> players = getPlayers(getNames());
		List<CardOwner> cardOwners = new ArrayList<>(players);
		Dealer dealer = new Dealer();

		cardOwners.add(dealer);

		drawCard(cardOwners);
		drawCard(cardOwners);
		cardOwners.forEach(this::printStatus);

		players.forEach(this::setCards);
		drawDealerCards(dealer);
	}

	private void drawDealerCards(Dealer dealer) {
		BlackjackResult blackjackResult = dealer.calculateResult();
		if(!blackjackResult.isDealerEnd()) {
			ResultView.printMessage("딜러는 16이하라 한장의 카드를 더 받았습니다.");
			dealer.addCard(deck.draw());
			drawDealerCards(dealer);
		}
	}

	private void setCards(Player player) {
		BlackjackResult blackjackResult = player.calculateResult();

		if (blackjackResult.isBlackjackOrMore()) {
			return;
		}

		MoreCardType moreCardType = getMoreCardType(player);
		if (moreCardType.isMore()) {
			player.addCard(deck.draw());
			printStatus(player);
			setCards(player);
		}
	}

	private MoreCardType getMoreCardType(Player player) {
		try {
			return MoreCardType.from(InputView.getMoreCardInput(player.getName().getValue()));
		} catch (IllegalArgumentException e) {
			ResultView.printMessage("잘못된 입력입니다.");
			return getMoreCardType(player);
		}
	}

	private Names getNames() {
		try {
			return Names.from(InputView.getNames());
		} catch (IllegalArgumentException e) {
			ResultView.printMessage(e.getMessage());
			return getNames();
		}
	}

	private Money getMoney(String name) {
		try {
			return Money.from(InputView.getMoney(name));
		} catch (IllegalArgumentException e) {
			ResultView.printMessage(e.getMessage());
			return getMoney(name);
		}
	}

	private List<Player> getPlayers(Names names) {
		return names.getValues().stream()
			.map(name -> new Player(name, getMoney(name.getValue())))
			.collect(Collectors.toList());
	}

	private void drawCard(List<CardOwner> cardOwners) {
		cardOwners.forEach(cardOwner -> cardOwner.addCard(deck.draw()));
	}

	private void printStatus(CardOwner cardOwner) {
		String message = StatusMessage.from(cardOwner).getMessage();
		ResultView.printMessage(message);
	}
}
