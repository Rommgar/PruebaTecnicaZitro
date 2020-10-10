package local.jbenito.room;
import local.jbenito.player.Player;

public class RoomFactory {
	private static RoomFactory instance;
	
	private RoomFactory() {
		
	}
	
	public static RoomFactory getInstance() {
		if (RoomFactory.instance == null) {
			RoomFactory.instance = new RoomFactory();
		}
		return instance;
	}
	
	public RoomInt basicRoom(Player player) {
		return new RoomBasic(player);
	}
}
