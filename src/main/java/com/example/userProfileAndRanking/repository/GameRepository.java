package com.example.userProfileAndRanking.repository;

import java.util.List;

import com.example.userProfileAndRanking.model.Game;

import com.example.userProfileAndRanking.enums.GameType;

public interface GameRepository {

	void addGame(String gameName, GameType gameType, int minimumNumberOfPlayers, int maximumNumberOfPlayers,
			double gameDuration, boolean oneBoardFlag);

	void addGame(Game game);

	Game findGameById(long gameId);

	Game findGameByGameName(String gameName);

	List<Game> getListOfAllGames();

	List<Game> findGameByGameType(GameType gameType);

	List<Game> findGameByMinimumNuberOfPlayers(int numberOfPlayers);

	List<Game> findGameByMaximumNuberOfPlayers(int numberOfPlayers);

}
