package blackjack.minhoyoo.domain;

import java.util.Objects;

public class Card {
	private final CardNumber cardNumber;
	private final Suit suit;

	public Card(CardNumber cardNumber, Suit suit) {
		this.cardNumber = cardNumber;
		this.suit = suit;
	}

	public int getNumber() {
		return cardNumber.getNumber();
	}

	public boolean isAce() {
		return cardNumber.isAce();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Card card = (Card)o;
		return cardNumber == card.cardNumber && suit == card.suit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cardNumber, suit);
	}

	@Override
	public String toString() {
		return cardNumber.getName() + suit.getName();
	}
}
