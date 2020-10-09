package local.jbenito.PruebaTecnicaZitro;

import java.math.BigDecimal;
import java.util.Random;


public class BotPlayer {
	
	public static boolean playerBotSelectOption() {
		boolean option = new Random().nextBoolean();
		return option;
	}
	
	public static String playerBotSelectOption(String... options) {
		int optionSelected =  getRandomNumber(0, options.length);
		return options[optionSelected].toUpperCase();
		
	}
	
	public static BigDecimal playerBotSelectOption(BigDecimal minBet, BigDecimal maxBet) {
		BigDecimal optionSelected = getRandomBigDecimal(minBet, maxBet);
		return optionSelected;
		
	}
	
	public static int playerBotSelectOption(int numero) {
		return getRandomNumber(0, numero);
	}
	
	private static int getRandomNumber(int min, int max) {
	    Random random = new Random();
	    return random.ints(min, max)
	      .findFirst()
	      .getAsInt();
	}
	
	private static BigDecimal getRandomBigDecimal(BigDecimal minBet, BigDecimal maxBet) {
		
		int firstRandom = getRandomNumber(minBet.intValue(), maxBet.intValue()+100);
		int secondRandom = getRandomNumber(0, 99);
		
		BigDecimal randBigDecimal = new BigDecimal(String.valueOf(firstRandom+"."+secondRandom));
		return randBigDecimal;
		
	}
}
