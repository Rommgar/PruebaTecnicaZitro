package local.jbenito.room;

import local.jbenito.dto.GameDTO;
import local.jbenito.dto.RoomDTO;
import local.jbenito.gamble.Gamble;
import local.jbenito.game.GameInitializer;
import local.jbenito.player.Player;

public class Room extends RoomDTO {
	public Room(Player player) {
		super(player);
	}

	@Override
	public void run() {
		while (running) {
			gameSelection();
			timer.decrementPlayerTime(player);
			while (this.player.isPlaying()) {
				gamble = new Gamble(game, player);
				gamble.strat();
			}
			destroyTimer();
			this.setRunning(false);
		}
	}
	
	@Override
	protected void destroyTimer() {
		timer.cancel();
		timer = null;
	}
	
	@Override
	protected void gameSelection() {
		String availabelGames = GameInitializer.availableGames();
		GameDTO selectedGame = GameInitializer.initGame(availabelGames);
		this.setGame(selectedGame);
		this.player.setPlaying(true);
	}
}
