package com.example.userProfileAndRanking.service;

import java.util.List;

import com.example.userProfileAndRanking.dto.ChallengeTO;
import com.example.userProfileAndRanking.dto.LevelTO;
import com.example.userProfileAndRanking.dto.StatisticsTO;

public interface UserStatisticsService {

	StatisticsTO getUserStatistics(long userId);

	LevelTO getUserLevel(long userId);

	int getUserRanking(long userId);

	List<ChallengeTO> getUserChallengeHistory(long userId);

}
