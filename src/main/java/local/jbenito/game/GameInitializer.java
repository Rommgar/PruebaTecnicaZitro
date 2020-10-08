package local.jbenito.game;


import java.util.Arrays;
import java.util.List;

import local.jbenito.dto.GameDTO;
import local.jbenito.sender.Sender;

public class GameInitializer {
	public static GameDTO initGame(String selectedGame) {
		GameDTO gameInitialized = null;
		List<AbailableGames> abailableGames = Arrays.asList(AbailableGames.values());
		for (AbailableGames game : abailableGames) {
			if (game.name() == selectedGame) {
				gameInitialized = gameSelector(game);
			}
		}
		return gameInitialized;
	}
	
	public static String availableGames() {
		List<AbailableGames> games = Arrays.asList(AbailableGames.values());
		String nameGames[] = new String[games.size()];
		int i = 0;
    	for (AbailableGames game : games) {
    		nameGames[i] = game.name();
    		i++;
		}
		return Sender.sendAvailableGames(nameGames);
	}
	
	private static GameDTO gameSelector(AbailableGames game) {
		switch (game.getNameType()){
		case "VIDEOBINGO":
			return  new VideoBingo(game);
		case "BLACKJACK":
			return  new BlackJack(game);
		case "POKER":
			return  new Poker(game);
		case "RULETA":
			return  new rulette(game);
		case "SLOTS":
			return  new Slots(game);
		default:
			//System.out.println("GameDTO no reconozido");
			return null;
		}
	}
}

