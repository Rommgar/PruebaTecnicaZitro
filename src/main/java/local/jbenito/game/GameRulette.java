package local.jbenito.game;

import java.util.List;

import local.jbenito.dto.GameDTO;

public class GameRulette extends GameDTO implements RuletteInt{
	
	public GameRulette(AbailableGames game) {
		super(game);
	}

	@Override
	public Boolean play(List<Object> otherOptions) {
		return RuletteInt.super.play(otherOptions);
	}

	@Override
	public List<Object> selectOtherOptions() {
		return RuletteInt.super.selectOtherOptions();
	}
	
}
