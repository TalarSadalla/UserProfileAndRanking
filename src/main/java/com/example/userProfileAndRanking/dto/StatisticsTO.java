package com.example.userProfileAndRanking.dto;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.example.userProfileAndRanking.enums.Level;
import com.example.userProfileAndRanking.model.Challenge;

public class StatisticsTO {

	private AtomicLong uniqueId;

	private long gameId;
	private Level level;
	private int rankingPosition;
	private int win, loss, draw;
	private List<Challenge> userGameHistory;

	public StatisticsTO(int userId, Level level, int rankingPosition, int win, int loss, int draw,
			List<Challenge> userGameHistory) {
		super();
		this.gameId = uniqueId.incrementAndGet();
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
		win++;
	}

	public void addLoss() {
		loss++;
	}

	public void addDraw() {
		draw++;
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
