package local.jbenito.dto;

import local.jbenito.credit.CreditBasic;
import local.jbenito.game.AbailableGames;
import local.jbenito.game.Prizes;

public class GameDTO{
		protected final String name;
		protected final int idType;
		protected final CreditBasic minBet;
		protected final CreditBasic maxBet;
		protected final int rewardPercentage;
		protected final Prizes[] prizes;
		protected static int gameCount;
		
		public GameDTO(AbailableGames game) {
			this.name = game.name();
			this.idType = game.getIdType();
			this.minBet = new CreditBasic(game.getMinBet().doubleValue());
			this.maxBet = new CreditBasic(game.getMaxBet().doubleValue());
			this.rewardPercentage = game.getPrizePercentage();
			this.prizes = game.getPrizes();
		}

		public static int getGameCount() {
			return gameCount;
		}

		public static void setGameCount(int gameCount) {
			GameDTO.gameCount = gameCount;
		}

		public int getIdType() {
			return idType;
		}

		public CreditBasic getMinBet() {
			return minBet;
		}

		public CreditBasic getMaxBet() {
			return maxBet;
		}

		public int getRewardPercentage() {
			return rewardPercentage;
		}

		public String getName() {
			return name;
		}

		public Prizes[] getPrizes() {
			return prizes;
		}
}
