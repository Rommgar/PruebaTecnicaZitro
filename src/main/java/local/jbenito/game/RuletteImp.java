package local.jbenito.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import local.jbenito.sender.Sender;

public interface RuletteImp extends GameInt{
	public static final int cuadrados = 38;
	int [] numerosRuleta = new int[cuadrados];
    boolean [] coloresRuleta = new boolean[cuadrados];
	
    
	@Override
	default Boolean play(List<Object> otherOptions) {
		int posicion;
        Random random = new Random();
        posicion = random.nextInt(cuadrados);
        boolean awarded = compareRollWhithPlayerSelect(otherOptions, posicion);
        return awarded;
	}

	@Override
	default List<Object> selectOtherOptions() {
		List<Object> options = new ArrayList<Object>();
		Boolean selectedColor = Sender.sendAvailableColors();
		options.add(selectedColor);
		int slectedNumber = Sender.sendAvailablenumber(cuadrados);
		options.add(slectedNumber);
		return options;
	}
	
	private Boolean compareRollWhithPlayerSelect(List<Object> otherOptions, int posicion) {
		boolean color = false;
        boolean sameNum = false;
        boolean awarded;
		for (Object object : otherOptions) {
			if (object instanceof Boolean) {
				color = object.equals(coloresRuleta[posicion]);
			}
			else if (object instanceof Integer) {
				sameNum = ((int) object == posicion)? true: false;
			}
		}
		awarded = (color && sameNum) ? true: false;
		return awarded;
	}

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
	
}
