package com.example.userProfileAndRanking.repository;

import java.util.List;

import com.example.userProfileAndRanking.enums.Level;
import com.example.userProfileAndRanking.model.Challenge;
import com.example.userProfileAndRanking.model.Statistics;

public interface StatisticsRepository {

	Statistics getUserStatistics(long userId);

	Level getUserLevel(long userId);

	int getUserCurrentRanking(long userId);

	List<Challenge> getUserGameHistory(long userId);

	int getUserWins(long userId);

	int getUserLosses(long userId);

	int getUserDraws(long userId);

	int getNumberOfAllUserGames(long userId);

}
