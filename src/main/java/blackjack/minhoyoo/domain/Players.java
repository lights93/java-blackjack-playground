package blackjack.minhoyoo.domain;

import java.util.List;

public class Players {
	private final List<Player> elements;

	private Players(List<Player> elements) {
		this.elements = elements;
	}

	public static Players from(List<Player> players) {
		return new Players(players);
	}

	public void addCard(Deck deck) {
		for (Player player : elements) {
			player.addCard(deck.draw());
		}
	}
}
