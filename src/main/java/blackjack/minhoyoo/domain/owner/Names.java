package blackjack.minhoyoo.domain.owner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Names {
	public static final String NAME_SPLIT = ",";
	private final List<Name> values;

	private Names(List<Name> values) {
		this.values = values;
	}

	public static Names from(String names) {
		String[] split = names.split(NAME_SPLIT);
		return new Names(Arrays.stream(split)
			.map(Name::from)
			.collect(Collectors.toList()));
	}

	public int size() {
		return values.size();
	}

	public List<Name> getValues() {
		return Collections.unmodifiableList(values);
	}
}
