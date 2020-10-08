package local.jbenito.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import local.jbenito.dto.GameDTO;
import local.jbenito.sender.Sender;

public class rulette extends GameDTO {
	private int cuadrados = 38;
	int [] numerosRuleta = new int[cuadrados];
    boolean [] coloresRuleta = new boolean[cuadrados];
    
	public rulette(AbailableGames game) {
		super(game);
		this.cuadrados = 2 * this.getRewardPercentage();
		int numero = 0;
        int posicion = 0;
        boolean color = false;
        numerosRuleta[0] = 0;
        
        for(posicion = 1; posicion < cuadrados; posicion++){
            numerosRuleta[posicion] = numero;
            numero++;
        }
        
        color = false;
        for(posicion = 0; posicion <= 12; posicion++){
            coloresRuleta[posicion] = color;
            color = !color;
        }
        for(posicion = 12; posicion <= 20; posicion++){
            coloresRuleta[posicion] = color;
            color = !color;
        }
        for(posicion = 20; posicion <= 29; posicion++){
            coloresRuleta[posicion] = color;
            color = !color;
        }
        for(posicion = 29; posicion < cuadrados; posicion++){
            coloresRuleta[posicion] = color;
        }
	}
	
	@Override
	public List<Object> selectOtherOptions(){
		List<Object> options = new ArrayList<Object>();
		Boolean selectedColor = Sender.sendAvailableColors();
		options.add(selectedColor);
		int slectedNumber = Sender.sendAvailablenumber(cuadrados);
		options.add(slectedNumber);
		return options;
	}
	
	@Override
	public Boolean play(List<Object> otherOptions) {
		int posicion;
        Random random = new Random();
        posicion = random.nextInt(cuadrados);
        boolean awarded = compareRollWhithPlayerSelect(otherOptions, posicion);
        return awarded;
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
}
