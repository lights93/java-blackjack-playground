package blackjack.minhoyoo;

import blackjack.minhoyoo.service.BlackJackService;

public class Application {
	public static void main(String[] args) {
		BlackJackService blackJackService = new BlackJackService();
		blackJackService.start();
	}
}
