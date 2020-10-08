package local.jbenito.gamble;

import java.math.BigDecimal;
import java.math.RoundingMode;

import local.jbenito.dto.GambleDTO;
import local.jbenito.game.Prizes;
import local.jbenito.log.LogFactory;
import local.jbenito.log.LogSystem;
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

	private void sendBet(BigDecimal minBet, BigDecimal maxBet) {
		BigDecimal selectedBet = Sender.sendAvailableBets(minBet, maxBet);
		if ((selectedBet.compareTo(maxBet) == -1 && selectedBet.compareTo(minBet) == 1)
				|| selectedBet.compareTo(maxBet) == 0 || selectedBet.compareTo(minBet) == 0) {
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
			BigDecimal betPercenatge = new BigDecimal(prize.getBetPercentage() / 100).setScale(2, RoundingMode.CEILING);
			betPercenatge.subtract(bet);
			this.balance = this.bet.multiply(betPercenatge);
			this.setPlayerCredits(this.getPlayerCredits().add(balance));
		} else {
			this.balance = balance.subtract(this.bet);
			this.setPlayerCredits(this.getPlayerCredits().subtract(bet).setScale(2, RoundingMode.CEILING));
		}

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
