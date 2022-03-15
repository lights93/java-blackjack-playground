package blackjack.minhoyoo.view;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);
	private static final Pattern REMOVE_ALL_SPACES_PATTERN = Pattern.compile("\\s+");
	private static final String EMPTY = "";

	private InputView() {
	}

	public static String getNames() {
		System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
		return REMOVE_ALL_SPACES_PATTERN.matcher(scanner.nextLine()).replaceAll(EMPTY);
	}
}
