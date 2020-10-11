package local.jbenito.gamble;

import java.util.List;

import local.jbenito.credit.CreditBasic;
import local.jbenito.credit.CreditInt;
import local.jbenito.dto.GambleDTO;
import local.jbenito.game.GameInt;
import local.jbenito.player.Player;
import local.jbenito.sender.Sender;

public interface GambleBasic extends GambleInt{
	GambleDTO gamble = new GambleDTO();
	
	default CreditInt tryBetIsCorrect(GameInt game) {
		CreditInt selectedBet = null;
		boolean correctBet;
		do {
			try {
				selectedBet = sendBet(game.getMinBet(), game.getMaxBet());
				correctBet = true;
			} catch (Exception e) {
				//logErr.send(e.toString());
				correctBet = false;
			}
		} while (!correctBet);
		return selectedBet;
	}
	
	default List<Object> selectOtherOptions(GameInt game) {
		return game.selectOtherOptions();
	}
	
	default CreditInt sendBet(CreditInt minBet, CreditInt maxBet) {
		CreditInt selectedBet = Sender.sendAvailableBets(minBet, maxBet);
		if (selectedBet.isInRange(minBet, maxBet)) {
			selectedBet.normalizeCredit();
		} else {
			selectedBet.normalizeCredit();
			maxBet.normalizeCredit();
			minBet.normalizeCredit();
			throw new RuntimeException("La apuesta esta fuera de rango MinBet: " + minBet.getCredit() + " MaxBet: " + 
					maxBet.getCredit() + " Bet: " + selectedBet.getCredit());
		}
		return selectedBet;
	}
	
	default void calculateBalance(CreditInt playerCredit, Boolean isAwarded, double betPercentage,
			CreditInt bet, CreditInt balance) {
		if (isAwarded) {
			CreditInt betPercenatge = new CreditBasic(betPercentage);
			betPercenatge.normalizeCredit();
			betPercenatge.multiply(bet);
			betPercenatge.subtract(bet);
			balance = bet;
			playerCredit.add(balance);
		} else {
			balance.subtract(bet);
			playerCredit.subtract(bet);
		}
		balance.normalizeCredit();
		playerCredit.normalizeCredit();
	}

	default void strat(Player player, GameInt game) {
		gamble.setBet(tryBetIsCorrect(game));
		gamble.setOtherGameOptions(selectOtherOptions(game));
		gamble.setAwarded(game.play(gamble.getOtherGameOptions()));
		if (gamble.isAwarded()) {
			gamble.setPrize(game.calculatePrize(game.getPrizes()));
		}
		calculateBalance(player.getCredit(), gamble.isAwarded(), 
				gamble.getBetPercentage(), gamble.getBet(), gamble.getBalance());
		log.send(this.toString());
		if (player.getCredit().isCreditsZero()) {
			player.setPlaying(false);
		}
	}
	
	
}
