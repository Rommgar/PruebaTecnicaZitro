package local.jbenito.casino;

import local.jbenito.player.Player;
import local.jbenito.room.Room;

public class Casino {
	private final int idCasino;
	private static int countCasinos;
	public final int maxPlayers;
	private int onlinePlayers;
	private boolean running;

	public Casino(int max_players) {
		this.idCasino = ++countCasinos;
		this.maxPlayers = max_players;
		this.onlinePlayers = 0;
		this.running = true;
	}

	public int getIdCasino() {
		return idCasino;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public void playerAuth(int uuid, long maxTimePlay, int provider, String credit) {
		Player player = Player.createPlayer(uuid, maxTimePlay, provider, credit);
		int maxPlayers = this.getMaxPlayers();
		if (maxPlayers > this.onlinePlayers) {
			createRoom(player);
			this.onlinePlayers = this.onlinePlayers + 1;
		} else {
			System.out.println("El casino esta lleno");
		}
	}

	private void createRoom(Player player) {
		Room room = new Room(player);
		room.start();
	}

	public void stopCasino() {
		this.running = false;
	}

	public boolean isRunning() {
		return this.running;
	}

	public static Casino startCasino(int maxUsers) {
		Casino casino = new Casino(maxUsers);
		return casino;
	}
}
