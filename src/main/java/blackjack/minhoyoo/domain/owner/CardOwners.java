package blackjack.minhoyoo.domain.owner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import blackjack.minhoyoo.domain.BlackjackResult;
import blackjack.minhoyoo.domain.Deck;
import blackjack.minhoyoo.domain.Money;

public class CardOwners {
	private final List<Player> players;
	private final Dealer dealer;

	public CardOwners(List<Player> players, Dealer dealer) {
		this.players = players;
		this.dealer = dealer;
	}

	public void drawCard(Deck deck) {
		players.forEach(player -> player.addCard(deck.draw()));
		dealer.addCard(deck.draw());
	}

	public List<CardOwner> getAllCardOwners() {
		List<CardOwner> owners = new ArrayList<>(players);
		owners.add(dealer);

		return owners;
	}

	public void updateMoney() {
		BlackjackResult dealerResult = dealer.calculateResult();

		if (allBlackJack(dealerResult)) {
			return;
		}

		updateMoney(dealerResult);
		Money newSum = calculateSum();

		dealer.updateMoney(newSum.reverse());
	}

	private void updateMoney(BlackjackResult dealerResult) {
		if (dealerResult.isOverBlackjack()) {
			return;
		}

		if (isPlayerBlackjack(dealerResult)) {
			players.forEach(this::updateFirstBlackJack);
			return;
		}

		players.forEach(player -> updatePlayerMoney(dealerResult, player));
	}

	private void updatePlayerMoney(BlackjackResult dealerResult, Player player) {
		BlackjackResult playerResult = player.calculateResult();

		if (dealerResult.isBiggerThan(playerResult)) {
			player.lose();
			return;
		}

		if (!playerResult.isBiggerThan(dealerResult)) {
			player.updateMoney(Money.ZERO);
		}
	}

	private boolean allBlackJack(BlackjackResult dealerResult) {
		boolean hasNotBlackJack = players.stream()
			.anyMatch(player -> !player.calculateResult().isBlackjack());
		return dealerResult.isBlackjack() && !hasNotBlackJack;
	}

	private boolean isPlayerBlackjack(BlackjackResult dealerResult) {
		boolean hasBlackJack = players.stream()
			.anyMatch(player -> player.calculateResult().isBlackjack());

		return !dealerResult.isBlackjack() && hasBlackJack;
	}

	private void updateFirstBlackJack(Player player) {
		if (player.calculateResult().isFirstBlackJack()) {
			player.updateFirstBlackJackMoney();
		} else {
			player.lose();
		}
	}

	private Money calculateSum() {
		return players.stream()
			.map(CardOwner::getMoney)
			.reduce(Money.ZERO, (Money::add));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CardOwners that = (CardOwners)o;
		return Objects.equals(players, that.players) && Objects.equals(dealer, that.dealer);
	}

	@Override
	public int hashCode() {
		return Objects.hash(players, dealer);
	}
}
