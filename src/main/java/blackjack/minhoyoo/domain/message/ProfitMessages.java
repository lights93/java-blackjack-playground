package blackjack.minhoyoo.domain.message;

import java.util.List;
import java.util.stream.Collectors;

import blackjack.minhoyoo.domain.owner.CardOwners;

public class ProfitMessages {
	private final List<ProfitMessage> messages;

	public ProfitMessages(List<ProfitMessage> messages) {
		this.messages = messages;
	}

	public static ProfitMessages from(CardOwners cardOwners) {
		return new ProfitMessages(cardOwners.getAllCardOwners().stream()
			.map(ProfitMessage::from)
			.collect(Collectors.toList()));
	}

	public String getMessage() {
		return messages.stream()
			.map(ProfitMessage::getMessage)
			.collect(Collectors.joining("\n"));
	}
}
