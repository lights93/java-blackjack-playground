package blackjack.minhoyoo.domain.message;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import blackjack.minhoyoo.domain.card.Card;
import blackjack.minhoyoo.domain.owner.CardOwner;
import blackjack.minhoyoo.domain.owner.Dealer;
import blackjack.minhoyoo.domain.owner.Player;

public class StatusMessage {
	private static final Map<Class<? extends CardOwner>, Function<CardOwner, String>> OWNER_TO_MESSAGE_MAP = makeOwnerToMessageMap();
	private final String message;
	private final int result;

	private StatusMessage(String message, int result) {
		this.message = message;
		this.result = result;
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
		// TODO
		return new StatusMessage(message, owner.getState().cards().calculateResult());
	}

	public String getMessage() {
		return message;
	}

	public String getMessageWithResult() {
		return message + " - 결과: " + result;
	}
}
