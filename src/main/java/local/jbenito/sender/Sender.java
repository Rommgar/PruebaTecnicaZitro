package local.jbenito.sender;

import java.math.BigDecimal;
import local.jbenito.PruebaTecnicaZitro.BotPlayer;
import local.jbenito.credit.Credit;

public class Sender {
	public static synchronized String sendAvailableGames(String[] nameGames) {
    	return BotPlayer.playerBotSelectOption(nameGames);
	}
	public static synchronized Credit sendAvailableBets(BigDecimal minBet, BigDecimal maxBet) {
		return new Credit(BotPlayer.playerBotSelectOption(minBet, maxBet));
	}
	public static synchronized Boolean sendAvailableColors() {
		return BotPlayer.playerBotSelectOption();
	}
	public static synchronized int sendAvailablenumber(int numero){
		return BotPlayer.playerBotSelectOption(numero);
	}
}
