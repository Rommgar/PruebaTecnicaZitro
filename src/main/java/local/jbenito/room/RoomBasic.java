package local.jbenito.room;

import local.jbenito.gametimer.GameTimer;
import local.jbenito.player.Player;

public class RoomBasic extends RoomBasicAbs {
	
	public RoomBasic(Player player) {
		this.timer = new GameTimer(player);
		this.player = player;
		this.running = true;
	}
	
	public void run() {
		runStructure();
	}
}
