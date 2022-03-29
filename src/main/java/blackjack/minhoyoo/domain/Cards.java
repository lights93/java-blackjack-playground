package blackjack.minhoyoo.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Cards {
	private static final int MAX_SUM = 21;
	private static final int ACE_DIFF = 10;
	private final List<Card> elements;

	private Cards(List<Card> elements) {
		this.elements = elements;
	}

	public static Cards empty() {
		return new Cards(new ArrayList<>());
	}

	public void addCard(Card card) {
		elements.add(card);
	}

	public List<Card> getAll() {
		return Collections.unmodifiableList(elements);
	}

	public int calculateResult() {
		int sum = calculateSum();

		if (sum <= MAX_SUM) {
			return sum;
		}

		if (containsAce()) {
			return sum - ACE_DIFF;
		}

		return sum;
	}

	private int calculateSum() {
		return elements.stream()
			.mapToInt(Card::getNumber)
			.sum();
	}

	private boolean containsAce() {
		return elements.stream()
			.anyMatch(Card::isAce);
	}

	public int size() {
		return elements.size();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Cards cards = (Cards)o;
		return Objects.equals(elements, cards.elements);
	}

	@Override
	public int hashCode() {
		return Objects.hash(elements);
	}
}
