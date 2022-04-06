package blackjack.minhoyoo.domain.state;

import blackjack.minhoyoo.domain.Money;
import blackjack.minhoyoo.domain.card.Card;
import blackjack.minhoyoo.domain.card.Cards;

public interface State {
	State draw(Card card);
	State stay();
	boolean isFinished();
	Cards cards();
	Money profit(Money money);
}
