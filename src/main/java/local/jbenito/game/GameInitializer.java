package local.jbenito.game;


import java.util.Arrays;
import java.util.List;

import local.jbenito.dto.GameDTO;
import local.jbenito.game.AbailableGames;

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
	
	private static GameDTO gameSelector(AbailableGames game) {
		switch (game.getNameType()){
		case "VIDEOBINGO":
			return  new VideoBingo(game);
		case "BLACKJACK":
			return  new BlackJack(game);
		case "POKER":
			return  new Poker(game);
		case "RULETA":
			return  new Ruleta(game);
		case "SLOTS":
			return  new Slots(game);
		default:
			//System.out.println("GameDTO no reconozido");
			return null;
		}
	}
}

