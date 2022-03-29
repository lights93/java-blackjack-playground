package blackjack.minhoyoo.domain;

import java.util.List;
import java.util.stream.Collectors;

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
}
