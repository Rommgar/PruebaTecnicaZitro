package local.jbenito.gamble;

import local.jbenito.game.GameInt;
import local.jbenito.player.Player;


public class Gamble implements GambleBasic{
	Player player;
	GameInt game;
	public Gamble(Player player, GameInt game){
		this.player = player;
		this.game = game;
	}
	
	public void strat() {
		GambleBasic.super.strat(player, game);
	}

}
