package model;

import java.util.List;

import enums.Level;

public class Statistics {

	private int userId;
	private Level level;
	private int rankingPosition;
	private int win, loss, draw;
	private List<Challenge> userGameHistory;

	public Statistics(int userId, Level level, int rankingPosition, int win, int loss, int draw,
			List<Challenge> userGameHistory) {
		super();
		this.userId = userId;
		this.level = level;
		this.rankingPosition = rankingPosition;
		this.win = win;
		this.loss = loss;
		this.draw = draw;
		this.userGameHistory = userGameHistory;
	}

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

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
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
		return win + loss + draw;
	}

	public List<Challenge> getUserGameHistory() {
		return userGameHistory;
	}

}
