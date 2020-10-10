package local.jbenito.dto;

import java.time.LocalDateTime;
import java.util.List;

import local.jbenito.credit.CreditBasic;
import local.jbenito.credit.CreditImp;
import local.jbenito.game.GameInt;
import local.jbenito.game.Prizes;
import local.jbenito.loggin.LogFactory;
import local.jbenito.player.Player;

public abstract class GambleDTO {
	protected final LogFactory factoryLog;
	protected final LocalDateTime date;
	protected GameInt game;
	protected Player player;
	protected CreditImp bet;
	protected CreditImp balance;
	protected Boolean awarded;
	protected Prizes prize;
	protected List<Object> otherGameOption;

	public GambleDTO(GameInt game, Object player) {
		this.factoryLog = LogFactory.getInstance();
		this.balance = new CreditBasic(00.00);
		this.date = LocalDateTime.now();
		this.game = game;
		this.player = (Player) player;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public int getUuidPlayer() {
		return player.getUuid();
	}

	public CreditImp getBet() {
		return bet;
	}

	public void setBet(CreditImp bet) {
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

	public CreditImp getBalance() {
		return this.balance;
	}

	public void setPlayerCredits(CreditImp credits) {
		this.player.setCredit(credits);
	}

	public CreditImp getPlayerCredits() {
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
