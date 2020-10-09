package local.jbenito.gamble;

import local.jbenito.credit.Credit;
import local.jbenito.dto.GambleDTO;
import local.jbenito.game.Prizes;
import local.jbenito.loggin.LogFactory;
import local.jbenito.loggin.LogSystem;
import local.jbenito.sender.Sender;

public class Gamble extends GambleDTO {
	LogSystem log = new LogFactory().LogFile();
	LogSystem logErr = new LogFactory().LogConsole();
	
	
	public Gamble(Object game, Object player) {
		super(game, player);
	}
	
	private void tryBetIsCorrect() {
		boolean correctBet;
		do {
			try {
				sendBet(this.game.getMinBet(), this.game.getMaxBet());
				correctBet = true;
			} catch (Exception e) {
				logErr.send(e.toString());
				correctBet = false;
			}
		} while (!correctBet);
		this.setOtherGameOptions(this.game.selectOtherOptions());
	}
	
	private void sendBet(Credit minBet, Credit maxBet) {
		Credit selectedBet = Sender.sendAvailableBets(minBet, maxBet);
		if (selectedBet.isInRange(minBet, maxBet)) {
			selectedBet.normalizeCredit();
			this.bet = selectedBet;
		} else {
			selectedBet.normalizeCredit();
			maxBet.normalizeCredit();
			minBet.normalizeCredit();
			throw new RuntimeException("La apuesta esta fuera de rango MinBet: " + minBet.getCredit() + "MaxBet: " + 
					maxBet.getCredit() + " Bet: " + selectedBet.getCredit());
		}

	}

	private void calculatePrize(Prizes[] prizes) {
		Prizes rewardObtained = Prizes.STANDARPRIZE;
		double rand = Math.random() * 101;
		for (Prizes prize : prizes) {
			if (rand < prize.getRewardWeight()) {
				rewardObtained = prize;
			}
		}
		this.prize = rewardObtained;

	}

	private void calculateBalance() {
		Credit playerCredit = this.player.getCredit();
		if (isAwarded()) {
			Credit betPercenatge = new Credit((double)prize.getBetPercentage() / 100);
			betPercenatge.normalizeCredit();
			betPercenatge.subtract(bet);
			this.bet.multiply(betPercenatge);
			this.balance = this.bet;
			playerCredit.add(balance);
		} else {
			this.balance.subtract(this.bet);
			playerCredit.subtract(bet);
		}
		this.balance.normalizeCredit();
		this.player.getCredit().normalizeCredit();
	}

	public void strat() {
		tryBetIsCorrect();
		this.setAwarded(this.game.play(this.getOtherGameOptions()));
		if (this.isAwarded()) {
			calculatePrize(this.game.getPrizes());
		}
		if (this.isCreditsZero()) {
			this.player.setPlaying(false);
		}
		calculateBalance();
		sendlog();
	}

	private void sendlog() {
		log.send(this.toString());
	}
}
