package local.jbenito.game;

import java.util.List;

import local.jbenito.dto.GameDTO;

public class GameSlots extends GameDTO implements DefaultInt {

	public GameSlots(AbailableGames game) {
		super(game);
	}

	@Override
	public Boolean play(List<Object> otherOptions) {
		return DefaultInt.super.play(otherOptions);
	}

	@Override
	public List<Object> selectOtherOptions() {
		return DefaultInt.super.selectOtherOptions();
	}
	
	
}
