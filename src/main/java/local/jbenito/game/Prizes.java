package local.jbenito.game;

public enum Prizes {
	STANDARPRIZE(1, 60f, 40f),
	JACKPOD(2, 4f,70f),
	SLOTSLOKOS(3, 3f, 60f),
	POKER(4, 3f, 70f),
	GRANRULETA(5, 3f, 70f),
	BINGOFULL(6, 2.5f, 70f),
	GRANBOTE(7, 0.5f,98f);
	
	private final int idPrize;
	private final float rewardWeight;
	private final float betPercentage;
	
	private Prizes(int idPrize, float rewardWeight,float betPercentage) {
		this.idPrize = idPrize;
		this.rewardWeight = rewardWeight;
		this.betPercentage = betPercentage;
	}

	public int getIdPrize() {
		return this.idPrize;
	}

	public float getBetPercentage() {
		return this.betPercentage;
	}
	
	public float getRewardWeight() {
		return this.rewardWeight;
	}
	
	
}
