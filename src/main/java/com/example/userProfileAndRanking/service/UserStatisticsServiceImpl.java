package com.example.userProfileAndRanking.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userProfileAndRanking.dto.ChallengeTO;
import com.example.userProfileAndRanking.dto.LevelTO;
import com.example.userProfileAndRanking.dto.StatisticsTO;
import com.example.userProfileAndRanking.repository.StatisticsRepository;

@Service
public class UserStatisticsServiceImpl implements UserStatisticsService {

	@Autowired
	StatisticsRepository statisticsRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public StatisticsTO getUserStatistics(long userId) {
		return modelMapper.map(statisticsRepository.getUserStatistics(userId), StatisticsTO.class);
	}

	@Override
	public LevelTO getUserLevel(long userId) {
		return modelMapper.map(statisticsRepository.getUserLevel(userId), LevelTO.class);
	}

	@Override
	public int getUserRanking(long userId) {
		return statisticsRepository.getUserCurrentRanking(userId);
	}

	@Override
	public List<ChallengeTO> getUserChallengeHistory(long userId) {
		return modelMapper.map(statisticsRepository.getUserGameHistory(userId), ChallengeTO.class);
	}

}
