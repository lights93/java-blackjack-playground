package blackjack.minhoyoo.domain.message;

import java.util.List;
import java.util.stream.Collectors;

import blackjack.minhoyoo.domain.owner.CardOwners;

public class StatusMessages {
	private final List<StatusMessage> messages;

	public StatusMessages(List<StatusMessage> messages) {
		this.messages = messages;
	}

	public static StatusMessages from(CardOwners cardOwners) {
		return new StatusMessages(cardOwners.getAllCardOwners().stream()
			.map(StatusMessage::from)
			.collect(Collectors.toList()));
	}

	public String getMessage() {
		return messages.stream()
			.map(StatusMessage::getMessage)
			.collect(Collectors.joining("\n"));
	}

	public String getMessageWithResult() {
		return messages.stream()
			.map(StatusMessage::getMessageWithResult)
			.collect(Collectors.joining("\n"));
	}
}
