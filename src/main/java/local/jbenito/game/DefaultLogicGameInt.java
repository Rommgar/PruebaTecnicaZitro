package local.jbenito.game;

import java.util.List;

public interface DefaultLogicGameInt extends GameInt{

	@Override
	default Prizes calculatePrize(Prizes[] prizes) {
		Prizes rewardObtained = Prizes.STANDARPRIZE;
		double rand = Math.random() * 101;
		for (Prizes prize : prizes) {
			if (rand < prize.getRewardWeight()) {
				rewardObtained = prize;
			}
		}
		return rewardObtained;
	}

	@Override
	default Boolean play(List<Object> otherOptions) {
		double rand = Math.random()*101;
		boolean awarded = (rand < 30) ? true: false;
		return awarded;
	}

	@Override
	default List<Object> selectOtherOptions() {
		return null;
	}
}
