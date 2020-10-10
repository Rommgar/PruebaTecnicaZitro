package local.jbenito.room;

import local.jbenito.dto.GameDTO;
import local.jbenito.gamble.Gamble;
import local.jbenito.game.GameInitializer;
import local.jbenito.gametimer.GameTimer;
import local.jbenito.player.Player;

public abstract class RoomBasicAbs implements RoomInt{
	Player player;
	GameDTO game;
	GameTimer timer;
	Gamble gamble;
	boolean running;

	@Override
	public void runStructure() {
		while (running) {
			gameSelection();
			timer.decrementPlayerTime();
			createGambel();
			destroyTimer();
			this.running = false;
		}
	}

	@Override
	public void destroyTimer() {
		timer.cancel();
		timer = null;
	}
	
	@Override
	public void gameSelection() {
		String availabelGames = GameInitializer.availableGames();
		GameDTO selectedGame = GameInitializer.initGame(availabelGames);
		this.game = selectedGame;
		this.player.setPlaying(true);
	}

	@Override
	public void createGambel() {
		while (this.player.isPlaying()) {
			gamble = new Gamble(game, player);
			gamble.strat();
		}
	}
}
