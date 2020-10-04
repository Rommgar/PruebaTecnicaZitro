package local.jbenito.sender;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import local.jbenito.PruebaTecnicaZitro.BotPlayer;
import local.jbenito.game.AbailableGames;

public class Sender {
	public static synchronized String sendAvailableGames() {
		List<AbailableGames> games = Arrays.asList(AbailableGames.values());
		String nameGames[] = new String[games.size()];
		int i = 0;
    	for (AbailableGames game : games) {
    		nameGames[i] = game.name();
    		i++;
		}
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
