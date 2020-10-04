package local.jbenito.game;

import java.math.BigDecimal;

public enum AbailableGames {
	
	STARSPOKER(1,"POKER","2.50","1000.00", 5,new Prizes[] {Prizes.POKER, Prizes.GRANBOTE}),
	STARSSLOTS(2,"SLOTS","5.00","1000.00", 5, new Prizes[] {Prizes.SLOTSLOKOS, Prizes.GRANBOTE}),
	STARSBLACKJACK(3, "BLACKJACK","5.00","1000.00", 5, new Prizes[] {Prizes.JACKPOD, Prizes.GRANBOTE}),
	STARSRULETA(4,"RULETA","5.00","1000.00", 5, new Prizes[] {Prizes.GRANRULETA, Prizes.GRANBOTE}),
	STARSVIDEOBINDO(5, "VIDEOBINGO","5.00","1000.00", 5, new Prizes[] {Prizes.BINGOFULL, Prizes.GRANBOTE}),
	MOONPOKER(1,"POKER","1000.00","3000.00", 5, new Prizes[] {Prizes.POKER, Prizes.GRANBOTE}),
	MOONRULETA(4, "RULETA","1050.00","3000.00", 5, new Prizes[] {Prizes.GRANRULETA, Prizes.GRANBOTE}),
	MOONSLOTS(2, "POKER","999.55","3000.10", 5, new Prizes[] {Prizes.SLOTSLOKOS, Prizes.GRANBOTE});
	
	
	private final int idType;
	private final String nameType;
	private final BigDecimal minBet;
	private final BigDecimal maxBet;
	private final int prizePercentage;
	private final Prizes[] prizes;
	
	
	AbailableGames(int idType, String nameType, String minBet, String maxBet, int prizePercentage, Prizes[] prizes){
		this.idType = idType;
		this.nameType = nameType;
		this.minBet = new BigDecimal(minBet);
		this.maxBet = new BigDecimal(maxBet);
		this.prizePercentage = prizePercentage;
		this.prizes = prizes;
	}
	public BigDecimal getMinBet() {
		return minBet;
	}
	public BigDecimal getMaxBet() {
		return maxBet;
	}
	public int getPrizePercentage() {
		return prizePercentage;
	}
	public int getIdType() {
		return this.idType;
	}
	public String getNameType() {
		return this.nameType;
	}
	public Prizes[] getPrizes() {
		return prizes;
	}
	
}
