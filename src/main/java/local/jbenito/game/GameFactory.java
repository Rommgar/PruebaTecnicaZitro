package local.jbenito.game;

public class GameFactory {
	public static GameFactory instance;
	
	private GameFactory() {
		
	}
	public static GameFactory getInstance() {
		if (instance == null) {
			instance = new GameFactory();
		}
		return instance;
	}
	
	public GameInt getBlackJack(AvailableGames game) {
		return new GameBlackJack(game);
	}
	public GameInt getRulette(AvailableGames game) {
		return new GameRulette(game);
	}
	public GameInt getPoker(AvailableGames game) {
		return new GamePoker(game);
	}
	public GameInt getSlots(AvailableGames game) {
		return new GameSlots(game);
	}
	public GameInt getVideBingo(AvailableGames game) {
		return new GameVideoBingo(game);
	}
}
