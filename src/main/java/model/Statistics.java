package model;

import java.util.List;

import enums.Level;

public class Statistics {

	private int userId;
	private Level level;
	private int rankingPosition;
	private int win, loss, drawn;
	private List<Game> userGameHistory;

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLoss() {
		return loss;
	}

	public void setLoss(int loss) {
		this.loss = loss;
	}

	public int getDrawn() {
		return drawn;
	}

	public void setDrawn(int drawn) {
		this.drawn = drawn;
	}

	public void addWin() {
		this.win = this.win++;
	}

	public void addLoss() {
		this.win = this.win++;
	}

	public void addDraw() {
		this.win = this.win++;
	}

	public Level getLevel() {
		return level;
	}

	public int getRankingPosition() {
		return rankingPosition;
	}

	public int numberOfAllGames() {
		return win + loss + drawn;
	}

}
