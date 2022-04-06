package blackjack.minhoyoo.domain.owner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
		if (allBlackjack()) {
			players.forEach(
				player -> player.updateMoney(Money.ZERO)
			);
			return;
		}

		if(dealer.isBust()) {
			updateDealerMoney();
			return;
		}

		int maxSum = players.stream()
			.mapToInt(CardOwner::calculateResult)
			.max()
			.orElse(0);

		players.forEach(player -> {
			if(player.calculateResult() == maxSum) {
				player.win();
			} else {
				player.lose();
			}
		});

		updateDealerMoney();
	}

	private void updateDealerMoney() {
		Money playerSum = players.stream()
			.map(CardOwner::getMoney)
			.reduce(Money.ZERO, Money::add);
		dealer.updateMoney(playerSum.reverse());
	}

	private boolean allBlackjack() {
		return dealer.isBlackjack() && players.stream().allMatch(CardOwner::isBlackjack);
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
