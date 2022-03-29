package blackjack.minhoyoo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
