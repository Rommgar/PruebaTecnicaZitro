package local.jbenito.room;

import local.jbenito.dto.GameDTO;
import local.jbenito.dto.RoomDTO;
import local.jbenito.gamble.Gamble;
import local.jbenito.game.GameInitializer;
import local.jbenito.player.Player;
import local.jbenito.sender.Sender;

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

	private void destroyTimer() {
		timer.cancel();
		timer = null;
	}

	private void gameSelection() {
		String availabelGames = Sender.sendAvailableGames();
		GameDTO selectedGame = GameInitializer.initGame(availabelGames);
		this.setGame(selectedGame);
		this.player.setPlaying(true);
	}
}
