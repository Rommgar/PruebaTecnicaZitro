package local.jbenito.game;

import java.util.List;
import local.jbenito.credit.CreditBasic;

public interface GameInt  {
	Boolean play(List<Object> otherOptions);
	public List<Object> selectOtherOptions();
	public Prizes calculatePrize(Prizes[] prizes);
	public Prizes[] getPrizes();
	
	public int getIdType();
	public CreditBasic getMinBet();
	public CreditBasic getMaxBet();
	public int getRewardPercentage();
	public String getName();
}
