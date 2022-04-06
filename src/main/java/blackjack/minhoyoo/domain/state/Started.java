package blackjack.minhoyoo.domain.state;

import java.util.Objects;

import blackjack.minhoyoo.domain.card.Cards;

public abstract class Started implements State {
	protected final Cards cards;

	protected Started(Cards cards) {
		this.cards = cards;
	}

	@Override
	public Cards cards() {
		return cards;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Started started = (Started)o;
		return Objects.equals(cards, started.cards);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cards);
	}
}
