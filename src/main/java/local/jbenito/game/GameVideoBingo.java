package local.jbenito.game;

import java.util.List;

import local.jbenito.dto.GameDTO;

public class GameVideoBingo extends GameDTO implements DefaultLogicGameInt {

	public GameVideoBingo(AbailableGames game) {
		super(game);
		// TODO Auto-generated constructor stub
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
