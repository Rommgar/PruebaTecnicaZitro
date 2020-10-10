package local.jbenito.game;

import java.util.List;

import local.jbenito.dto.GameDTO;

public class GameBlackJack extends GameDTO implements DefaultLogicGameInt {
	public GameBlackJack(AbailableGames game) {
		super(game);
	}

	@Override
	public Boolean play(List<Object> otherOptions) {
		return DefaultLogicGameInt.super.play(otherOptions);
	}

	@Override
	public List<Object> selectOtherOptions() {
		return DefaultLogicGameInt.super.selectOtherOptions();
	}
}
