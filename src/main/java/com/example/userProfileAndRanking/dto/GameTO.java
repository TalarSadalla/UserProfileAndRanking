package com.example.userProfileAndRanking.dto;

import java.util.List;

import com.example.userProfileAndRanking.enums.GameType;
import com.example.userProfileAndRanking.model.Game;

public class GameTO {

	private long uniqueId = 0;

	private long gameId;
	private GameType gameType;
	private String gameName;
	private int minimumNumberOfPlayers;
	private int maximumNumberOfPlayers;
	private double gameDuration;
	private boolean oneBoardFlag;
	private List<Game> userGameList;

	public GameTO(GameBuilder gameBuilder) {
		this.gameName = gameBuilder.gameName;
		this.gameType = gameBuilder.gameType;
		this.minimumNumberOfPlayers = gameBuilder.minimumNumberOfPlayers;
		this.maximumNumberOfPlayers = gameBuilder.maximumNumberOfPlayers;
		this.gameDuration = (float) 0.5;
		this.oneBoardFlag = gameBuilder.oneBoardFlag;
	}

	public GameTO(String gameName, GameType gameType, int minimumNumberOfPlayers, int maximumNumberOfPlayers,
			double gameDuration, boolean oneBoardFlag) {
		super();
		this.gameId = incrementId();
		this.gameType = gameType;
		this.gameName = gameName;
		this.minimumNumberOfPlayers = minimumNumberOfPlayers;
		this.maximumNumberOfPlayers = maximumNumberOfPlayers;
		this.gameDuration = gameDuration;
		this.oneBoardFlag = oneBoardFlag;
	}

	public long getUniqueId() {
		return uniqueId;
	}

	public long getGameId() {
		return gameId;
	}

	private long incrementId() {
		return uniqueId = uniqueId + 1;
	}

	public GameType getGameType() {
		return gameType;
	}

	public void setGameType(GameType gameType) {
		this.gameType = gameType;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public int getMinimumNumberOfPlayers() {
		return minimumNumberOfPlayers;
	}

	public void setMinimumNumberOfPlayers(int minimumNumberOfPlayers) {
		this.minimumNumberOfPlayers = minimumNumberOfPlayers;
	}

	public int getMaximumNumberOfPlayers() {
		return maximumNumberOfPlayers;
	}

	public void setMaximumNumberOfPlayers(int maximumNumberOfPlayers) {
		this.maximumNumberOfPlayers = maximumNumberOfPlayers;
	}

	public double getGameDuration() {
		return gameDuration;
	}

	public void setGameDuration(double gameDuration) {
		this.gameDuration = gameDuration;
	}

	public boolean isOneBoardFlag() {
		return oneBoardFlag;
	}

	public void setOneBoardFlag(boolean oneBoardFlag) {
		this.oneBoardFlag = oneBoardFlag;
	}

	public List<Game> getUserGameList() {
		return userGameList;
	}

	public static class GameBuilder {
		private final int minimumNumberOfPlayers;
		private final int maximumNumberOfPlayers;
		private final GameType gameType;
		private final String gameName;
		private double gameDuration;
		private final boolean oneBoardFlag;

		public GameBuilder(String gameName, GameType gameType, int minimumNumberOfPlayers, int maximumNumberOfPlayers,
				boolean oneBoardFlag) {
			this.gameName = gameName;
			this.gameType = gameType;
			this.minimumNumberOfPlayers = minimumNumberOfPlayers;
			this.maximumNumberOfPlayers = maximumNumberOfPlayers;
			this.oneBoardFlag = oneBoardFlag;

		}

		public GameBuilder gameDuration(double gameDuration) {
			this.gameDuration = gameDuration;
			return this;
		}

		public GameTO build() {
			return new GameTO(this);
		}

	}
}
