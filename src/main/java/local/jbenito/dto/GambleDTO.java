package local.jbenito.dto;

import java.time.LocalDateTime;
import java.util.List;

import local.jbenito.credit.Credit;
import local.jbenito.game.Prizes;
import local.jbenito.loggin.LogFactory;
import local.jbenito.player.Player;

public abstract class GambleDTO {
	protected final LogFactory factoryLog;
	protected final LocalDateTime date;
	protected GameDTO game;
	protected Player player;
	protected Credit bet;
	protected Credit balance;
	protected Boolean awarded;
	protected Prizes prize;
	protected List<Object> otherGameOption;

	public GambleDTO(Object game, Object player) {
		this.factoryLog = new LogFactory();
		this.balance = new Credit(00.00);
		this.date = LocalDateTime.now();
		this.game = (GameDTO) game;
		this.player = (Player) player;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public int getUuidPlayer() {
		return player.getUuid();
	}

	public Credit getBet() {
		return bet;
	}

	public void setBet(Credit bet) {
		this.bet = bet;
	}

	public String getTypeGame() {
		return game.getName();
	}

	public void setAwarded(Boolean awarded) {
		this.awarded = awarded;
	}

	public boolean isAwarded() {
		return this.awarded;
	}

	public void setPrize(Prizes prize) {
		this.prize = prize;
	}

	public Prizes getPrize() {
		return this.prize;
	}

	public void setOtherGameOptions(List<Object> selectOtherOptions) {
		this.otherGameOption = selectOtherOptions;
	}

	public List<Object> getOtherGameOptions() {
		return this.otherGameOption;
	}

	public Credit getBalance() {
		return this.balance;
	}

	public void setPlayerCredits(Credit credits) {
		this.player.setCredit(credits);
	}

	public Credit getPlayerCredits() {
		return this.player.getCredit();
	}

	public boolean isCreditsZero() {
		return (this.player.getCredit().isCreditsZero());
	}

	public int getUuidProvider() {
		return this.player.getUuid();
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Gamble [date=");
		builder.append(this.date);
		builder.append(", uuidPlayer=");
		builder.append(this.player.getUuid());
		builder.append(", playerCredits=");
		builder.append(this.player.getCredit());
		builder.append(", uuidProvider=");
		builder.append(this.player.getProvider());
		builder.append(", bet=");
		builder.append(this.bet);
		builder.append(", balance=");
		builder.append(this.balance);
		builder.append(", awarded=");
		builder.append(this.awarded);
		builder.append(", typeGame=");
		builder.append(this.getTypeGame());
		builder.append(", prize=");
		builder.append(this.prize);
		builder.append(", otherGameOption=");
		builder.append(this.otherGameOption);
		builder.append("]");
		return builder.toString();
	}
}
