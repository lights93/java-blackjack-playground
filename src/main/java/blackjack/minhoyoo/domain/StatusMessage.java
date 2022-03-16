package blackjack.minhoyoo.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StatusMessage {
	private static final Map<Class<? extends CardOwner>, Function<CardOwner, String>> OWNER_TO_MESSAGE_MAP = makeOwnerToMessageMap();
	private final String message;

	private StatusMessage(String message) {
		this.message = message;
	}

	private static Map<Class<? extends CardOwner>, Function<CardOwner, String>> makeOwnerToMessageMap() {
		Map<Class<? extends CardOwner>, Function<CardOwner, String>> map = new HashMap<>();

		map.put(Player.class, (owner -> {
			Player player = (Player)owner;

			return player.getName() + "카드: " + makeCardMessage(player);
		}));

		map.put(Dealer.class, (owner -> "딜러 카드: " + makeCardMessage(owner)));

		return map;
	}

	private static String makeCardMessage(CardOwner owner) {
		return owner.getCards().stream()
			.map(Card::toString)
			.collect(Collectors.joining(", "));
	}

	public static StatusMessage from(CardOwner owner) {
		if (owner == null || !OWNER_TO_MESSAGE_MAP.containsKey(owner.getClass())) {
			throw new IllegalArgumentException("잘못된 카드 주인 타입입니다.");
		}

		String message = OWNER_TO_MESSAGE_MAP.get(owner.getClass()).apply(owner);
		return new StatusMessage(message);
	}

	public String getMessage() {
		return message;
	}
}
