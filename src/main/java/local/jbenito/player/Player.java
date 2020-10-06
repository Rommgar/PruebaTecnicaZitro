package local.jbenito.player;

import java.math.BigDecimal;

public class Player {
	private final int uuid;
	private final int provider;
	private long maxTimePlay;
	private BigDecimal credit;
	private boolean playing;

	public Player(int uuid, long maxTimePlay, int provider, double credit) {
		this.uuid = uuid;
		this.maxTimePlay = maxTimePlay;
		this.credit = new BigDecimal(credit);
		this.provider = provider;
		this.playing = false;
	}

	public long getMaxTimePlay() {
		return maxTimePlay;
	}

	public void setMaxTimePlay(long maxTimePlay) {
		this.maxTimePlay = maxTimePlay;
	}

	public int getUuid() {
		return uuid;
	}

	public int getProvider() {
		return provider;
	}

	public boolean isPlaying() {
		return this.playing;
	}

	public void setPlaying(boolean playing) {
		this.playing = playing;
	}

	public BigDecimal getCredit() {
		return credit;
	}

	public void setCredit(BigDecimal credit) {
		this.credit = credit;
	}

	public static Player createPlayer(int uuid, long maxTimePlay, int provider, double credit) {
		Player newPlayer = new Player(uuid, maxTimePlay, provider, credit);
		return newPlayer;
	}
}
