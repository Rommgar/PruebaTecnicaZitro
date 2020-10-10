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
	
	public GameInt getBlackJack(AbailableGames game) {
		return new GameBlackJack(game);
	}
	public GameInt getRulette(AbailableGames game) {
		return new GameRulette(game);
	}
	public GameInt getPoker(AbailableGames game) {
		return new GamePoker(game);
	}
	public GameInt getSlots(AbailableGames game) {
		return new GameSlots(game);
	}
	public GameInt getVideBingo(AbailableGames game) {
		return new GameVideoBingo(game);
	}
}
