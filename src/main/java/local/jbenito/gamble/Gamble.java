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
				//logErr.send(e.toString());
				correctBet = false;
			}
		} while (!correctBet);
		this.setOtherGameOptions(this.game.selectOtherOptions());
	}
	
	private void sendBet(Credit minBet, Credit maxBet) {
		Credit selectedBet = Sender.sendAvailableBets(minBet, maxBet);
		if (selectedBet.isInRange(minBet, maxBet)) {
			selectedBet = selectedBet.normalizeCredit();
			this.bet = selectedBet;
		} else {
			throw new RuntimeException("La apuesta esta fuera de rango");
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
		if (isAwarded()) {
			Credit betPercenatge = new Credit((double)prize.getBetPercentage() / 100);
			betPercenatge.normalizeCredit();
			betPercenatge.subtract(bet);
			this.balance = this.bet.multiply(betPercenatge);
			this.setPlayerCredits(this.getPlayerCredits().add(balance));
		} else {
			this.balance = balance.subtract(this.bet);
			this.setPlayerCredits(this.getPlayerCredits().subtract(bet));
		}
		this.balance = this.balance.normalizeCredit();
		//System.out.println(this.balance.normalizeCredit());
		this.player.setCredit(this.player.getCredit().normalizeCredit());
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
		log.send(toString());
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Gamble [date=");
		builder.append(date);
		builder.append(", uuidPlayer=");
		builder.append(this.getUuidPlayer());
		builder.append(", playerCredits=");
		builder.append(this.getPlayerCredits());
		builder.append(", uuidProvider=");
		builder.append(this.player.getProvider());
		builder.append(", bet=");
		builder.append(bet);
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", awarded=");
		builder.append(awarded);
		builder.append(", typeGame=");
		builder.append(this.getTypeGame());
		builder.append(", prize=");
		builder.append(prize);
		builder.append(", otherGameOption=");
		builder.append(otherGameOption);
		builder.append("]");
		return builder.toString();
	}
}
