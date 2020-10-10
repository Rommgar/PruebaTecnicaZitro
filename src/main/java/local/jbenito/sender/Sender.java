package local.jbenito.sender;

import local.jbenito.PruebaTecnicaZitro.BotPlayer;
import local.jbenito.credit.CreditBasic;
import local.jbenito.credit.CreditImp;

public class Sender {
	public static synchronized String sendAvailableGames(String[] nameGames) {
    	return BotPlayer.playerBotSelectOption(nameGames);
	}
	public static synchronized CreditImp sendAvailableBets(CreditImp minBet, CreditImp maxBet) {
		return new CreditBasic(BotPlayer.playerBotSelectOption(minBet.getCredit(), maxBet.getCredit()));
	}
	public static synchronized Boolean sendAvailableColors() {
		return BotPlayer.playerBotSelectOption();
	}
	public static synchronized int sendAvailablenumber(int numero){
		return BotPlayer.playerBotSelectOption(numero);
	}
}
