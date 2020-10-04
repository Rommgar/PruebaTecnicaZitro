package local.jbenito.game;

import java.util.List;

import local.jbenito.dto.GameDTO;

public class Slots extends GameDTO {
	public Slots(AbailableGames game) {
		super(game);
	}

	
	@Override
	public List<Object> selectOtherOptions(){
		return null;
	}

	@Override
	public Boolean play(List<Object> selectedGameOptions) {
		double rand = Math.random()*101;
		boolean awarded = (rand < this.getRewardPercentage()) ? true: false;
		return awarded;
	}
}
