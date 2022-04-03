package blackjack.minhoyoo.domain.message;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import blackjack.minhoyoo.domain.owner.CardOwner;
import blackjack.minhoyoo.domain.owner.Dealer;
import blackjack.minhoyoo.domain.owner.Player;

public class ProfitMessage {
	private static final Map<Class<? extends CardOwner>, Function<CardOwner, String>> OWNER_TO_MESSAGE_MAP = makeOwnerToMessageMap();
	private final String message;

	private ProfitMessage(String message) {
		this.message = message;
	}

	private static Map<Class<? extends CardOwner>, Function<CardOwner, String>> makeOwnerToMessageMap() {
		Map<Class<? extends CardOwner>, Function<CardOwner, String>> map = new HashMap<>();

		map.put(Player.class, (owner -> {
			Player player = (Player)owner;

			return player.getName() + ": " + player.getMoney().getValue();
		}));

		map.put(Dealer.class, (owner -> "딜러: " + owner.getMoney().getValue()));

		return map;
	}

	public static ProfitMessage from(CardOwner owner) {
		if (owner == null || !OWNER_TO_MESSAGE_MAP.containsKey(owner.getClass())) {
			throw new IllegalArgumentException("잘못된 카드 주인 타입입니다.");
		}

		String message = OWNER_TO_MESSAGE_MAP.get(owner.getClass()).apply(owner);
		return new ProfitMessage(message);
	}

	public String getMessage() {
		return message;
	}
}
