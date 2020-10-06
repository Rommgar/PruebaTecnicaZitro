package local.jbenito.sender;

import java.math.BigDecimal;
import local.jbenito.PruebaTecnicaZitro.BotPlayer;

public class Sender {
	public static synchronized String sendAvailableGames(String[] nameGames) {
    	return BotPlayer.playerBotSelectOption(nameGames);
	}
	public static synchronized BigDecimal sendAvailableBets(BigDecimal minBet, BigDecimal maxBet) {
		return BotPlayer.playerBotSelectOption(minBet, maxBet);
	}
	public static synchronized Boolean sendAvailableColors() {
		return BotPlayer.playerBotSelectOption();
	}
	public static synchronized int sendAvailablenumber(int numero){
		return BotPlayer.playerBotSelectOption(numero);
	}
}
