package local.jbenito.game;


import java.util.Arrays;
import java.util.List;

import local.jbenito.sender.Sender;

public class GameInitializer {
	public static GameInt initGame(String selectedGame) {
		GameInt gameInitialized = null;
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
	
	private static GameInt gameSelector(AbailableGames game) {
		GameFactory gameFactory = GameFactory.getInstance();
		switch (game.getNameType()){
		case "VIDEOBINGO":
			return gameFactory.getVideBingo(game);
		case "BLACKJACK":
			return gameFactory.getBlackJack(game);
		case "POKER":
			return gameFactory.getPoker(game);
		case "RULETA":
			return gameFactory.getRulette(game);
		case "SLOTS":
			return gameFactory.getSlots(game);
		default:
			return null;
		}
	}
}

