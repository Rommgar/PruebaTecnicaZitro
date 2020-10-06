package local.jbenito.dto;

import local.jbenito.gamble.Gamble;
import local.jbenito.gametimer.GameTimer;
import local.jbenito.player.Player;

public abstract class RoomDTO extends Thread{
	protected final Player player;
	protected GameDTO game;
	protected GameTimer timer;
	protected Gamble gamble;
	protected boolean running;

	public RoomDTO(Player player) {
		this.player = player;
		this.timer = new GameTimer(player);
		this.running = true;
	}

	public boolean isRunning() {
		return this.running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public void setGame(GameDTO game) {
		this.game = game;
	}
	
	@Override
	public abstract void run();
	
	protected abstract void destroyTimer();
	protected abstract void gameSelection();
}
