package local.jbenito.dto;

import java.time.LocalDateTime;
import java.util.List;

import local.jbenito.credit.Credit;
import local.jbenito.game.Prizes;
import local.jbenito.player.Player;

public abstract class GambleDTO {
	protected final LocalDateTime date;
	protected GameDTO game;
	protected Player player;
	protected Credit bet;
	protected Credit balance = new Credit(0.00);
	protected Boolean awarded;
	protected Prizes prize;
	protected List<Object> otherGameOption;

	public GambleDTO(Object game, Object player) {
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
}
