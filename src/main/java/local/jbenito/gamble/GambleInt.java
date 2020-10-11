package local.jbenito.gamble;

import local.jbenito.dto.GambleDTO;
import local.jbenito.game.GameInt;
import local.jbenito.loggin.LogFactory;
import local.jbenito.loggin.LogSystem;
import local.jbenito.player.Player;

public interface GambleInt {
	final LogFactory factoryLog = LogFactory.getInstance();
	final LogSystem log = factoryLog.LogFile();
	final LogSystem logErr = factoryLog.LogConsole();
	
	public void strat(Player player, GameInt game, GambleDTO gamble);
}
