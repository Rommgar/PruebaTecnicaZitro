package local.jbenito.dto;

import java.time.LocalDateTime;
import java.util.List;

import local.jbenito.credit.CreditBasic;
import local.jbenito.credit.CreditInt;
import local.jbenito.game.GameInt;
import local.jbenito.game.Prizes;
import local.jbenito.player.Player;

public class GambleDTO {
	private LocalDateTime date;
	private GameInt game;
	private Player player;
	private CreditInt bet;
	private CreditInt balance;
	private Boolean awarded;
	private Prizes prize;
	private List<Object> otherGameOption;

	public GambleDTO(GameInt game, Player player) {
		this.balance = new CreditBasic(00.00);
		this.date = LocalDateTime.now();
		this.game = game;
		this.player = player;
		this.prize = Prizes.NULL;
		this.awarded = false;
	}

	private String getTypeGame() {
		return this.game.getName();
	}


	public void setBet(CreditInt bet) {
		this.bet = bet;
	}


	public void setOtherGameOptions(List<Object> otherGameOption) {
		this.otherGameOption = otherGameOption;
	}


	public List<Object> getOtherGameOptions() {
		return this.otherGameOption;
	}


	public void setAwarded(Boolean play) {
		// TODO Auto-generated method stub
		
	}


	public boolean isAwarded() {
		return awarded;
	}


	public void setPrize(Prizes prize) {
		this.prize = prize;
	}


	public double getBetPercentage() {
		return this.prize.getBetPercentage();
	}


	public CreditInt getBet() {
		return this.bet;
	}


	public CreditInt getBalance() {
		return this.balance;
	}


	public void setBalance(CreditInt balance) {
		this.balance = balance;
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
