package local.jbenito.dto;

import java.util.List;

import local.jbenito.credit.Credit;
import local.jbenito.game.AbailableGames;
import local.jbenito.game.Prizes;

public abstract class GameDTO{
		private final int id;
		private final String name;
		private final int idType;
		private final Credit minBet;
		private final Credit maxBet;
		private final int rewardPercentage;
		private final Prizes[] prizes;
		private static int gameCount;
		
		public GameDTO(AbailableGames game) {
			this.id = ++gameCount;
			this.name = game.name();
			this.idType = game.getIdType();
			this.minBet = new Credit(game.getMinBet().doubleValue());
			this.maxBet = new Credit(game.getMaxBet().doubleValue());
			this.rewardPercentage = game.getPrizePercentage();
			this.prizes = game.getPrizes();
		}

		public int getId() {
			return id;
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

		public Credit getMinBet() {
			return minBet;
		}

		public Credit getMaxBet() {
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
		public abstract Boolean play(List<Object> otherOptions);
		public abstract List<Object> selectOtherOptions();
}
