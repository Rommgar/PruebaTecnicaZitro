package local.jbenito.game;

import java.util.List;

import local.jbenito.dto.GameDTO;

public class GameRulette extends GameDTO implements RuletteImp{
	
	public GameRulette(AbailableGames game) {
		super(game);
	}

	@Override
	public Boolean play(List<Object> otherOptions) {
		return RuletteImp.super.play(otherOptions);
	}

	@Override
	public List<Object> selectOtherOptions() {
		return RuletteImp.super.selectOtherOptions();
	}
	
}
