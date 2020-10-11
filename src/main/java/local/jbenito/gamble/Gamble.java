package local.jbenito.gamble;

import local.jbenito.dto.GambleDTO;
import local.jbenito.game.GameInt;
import local.jbenito.player.Player;


public class Gamble implements GambleBasic{
	private GambleDTO gamble;
	private Player player;
	private GameInt game;
	
	public Gamble(Player player, GameInt game){
		this.player = player;
		this.game = game;
	}
	
	public void strat() {
		this.gamble = new GambleDTO(game, player);
		GambleBasic.super.strat(player, game, gamble);
	}

}
