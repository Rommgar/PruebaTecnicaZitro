package local.jbenito.sender;

import local.jbenito.PruebaTecnicaZitro.BotPlayer;
import local.jbenito.credit.Credit;

public class Sender {
	public static synchronized String sendAvailableGames(String[] nameGames) {
    	return BotPlayer.playerBotSelectOption(nameGames);
	}
	public static synchronized Credit sendAvailableBets(Credit minBet, Credit maxBet) {
		return new Credit(BotPlayer.playerBotSelectOption(minBet.getCredit(), maxBet.getCredit()));
	}
	public static synchronized Boolean sendAvailableColors() {
		return BotPlayer.playerBotSelectOption();
	}
	public static synchronized int sendAvailablenumber(int numero){
		return BotPlayer.playerBotSelectOption(numero);
	}
}
