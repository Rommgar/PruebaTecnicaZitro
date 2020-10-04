package local.jbenito.gametimer;

import local.jbenito.player.Player;

import java.util.Timer;
import java.util.TimerTask;

public class GameTimer extends TimerTask {
	private Player player;

	public GameTimer(Player player) {
		this.player = player;
	}

	public void run() {
		player.setMaxTimePlay(player.getMaxTimePlay() - 1);
		if (player.getMaxTimePlay() < 0) {
			player.setPlaying(false);
		}
	}

	public void decrementPlayerTime(Player player) {
		Timer timer = new Timer();
		GameTimer miContador = new GameTimer(player);
		timer.schedule(miContador, 0);
	}
}
