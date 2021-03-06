package blackjack.minhoyoo.service;

import java.util.List;
import java.util.stream.Collectors;

import blackjack.minhoyoo.domain.Deck;
import blackjack.minhoyoo.domain.Money;
import blackjack.minhoyoo.domain.MoreCardType;
import blackjack.minhoyoo.domain.card.Cards;
import blackjack.minhoyoo.domain.message.ProfitMessages;
import blackjack.minhoyoo.domain.message.StatusMessage;
import blackjack.minhoyoo.domain.message.StatusMessages;
import blackjack.minhoyoo.domain.owner.CardOwner;
import blackjack.minhoyoo.domain.owner.CardOwners;
import blackjack.minhoyoo.domain.owner.Dealer;
import blackjack.minhoyoo.domain.owner.Names;
import blackjack.minhoyoo.domain.owner.Player;
import blackjack.minhoyoo.domain.shuffle.RandomShuffleStrategy;
import blackjack.minhoyoo.view.InputView;
import blackjack.minhoyoo.view.ResultView;

public class BlackJackService {
	private final Deck deck = new Deck(new RandomShuffleStrategy());

	public void start() {
		List<Player> players = getPlayers(getNames());
		Dealer dealer = new Dealer(drawInitCards());
		CardOwners cardOwners = new CardOwners(players, dealer);
		printStatus(cardOwners);

		updateCards(players, dealer);
		updateMoney(cardOwners);
		printProfitStatus(cardOwners);
	}

	private Names getNames() {
		try {
			return Names.from(InputView.getNames());
		} catch (IllegalArgumentException e) {
			ResultView.printMessage(e.getMessage());
			return getNames();
		}
	}

	private List<Player> getPlayers(Names names) {
		return names.getValues().stream()
			.map(name -> new Player(name, drawInitCards(), getMoney(name.getValue())))
			.collect(Collectors.toList());
	}

	private Cards drawInitCards() {
		return Cards.of(deck.draw(), deck.draw());
	}

	private Money getMoney(String name) {
		try {
			return Money.from(InputView.getMoney(name));
		} catch (IllegalArgumentException e) {
			ResultView.printMessage(e.getMessage());
			return getMoney(name);
		}
	}

	private void updateCards(List<Player> players, Dealer dealer) {
		players.forEach(this::setCards);
		drawDealerCards(dealer);
	}

	private void setCards(Player player) {
		if (player.isFinished()) {
			return;
		}

		MoreCardType moreCardType = getMoreCardType(player);
		if (moreCardType.isMore()) {
			player.addCard(deck.draw());
			printStatus(player);
			setCards(player);
		} else {
			player.stay();
		}
	}

	private MoreCardType getMoreCardType(Player player) {
		try {
			return MoreCardType.from(InputView.getMoreCardInput(player.getName().getValue()));
		} catch (IllegalArgumentException e) {
			ResultView.printMessage("????????? ???????????????.");
			return getMoreCardType(player);
		}
	}

	private void drawDealerCards(Dealer dealer) {
		if(dealer.isFinished()) {
			ResultView.printMessage("????????? 16????????? ????????? ????????? ??? ???????????????.");
			dealer.addCard(deck.draw());
			drawDealerCards(dealer);
		}
	}

	private void updateMoney(CardOwners cardOwners) {
		cardOwners.updateMoney();
		printStatus(cardOwners);
	}

	private void printStatus(CardOwner cardOwner) {
		String message = StatusMessage.from(cardOwner).getMessage();
		ResultView.printMessage(message);
	}

	private void printStatus(CardOwners cardOwners) {
		String message = StatusMessages.from(cardOwners).getMessageWithResult();
		ResultView.printMessage(message);
	}

	private void printProfitStatus(CardOwners cardOwners) {
		ResultView.printMessage("\n## ?????? ??????");
		String message = ProfitMessages.from(cardOwners).getMessage();
		ResultView.printMessage(message);
	}
}
