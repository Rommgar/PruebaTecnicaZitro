package local.jbenito.game;

import java.util.List;

public interface DefaultInt extends GameInt{

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
