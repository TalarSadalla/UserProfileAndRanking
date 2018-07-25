package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enums.Level;
import model.Challenge;
import model.Statistics;
import repositoryInterface.StatisticsRepository;
import serviceInterface.UserStatisticsService;

@Service
public class UserStatisticsServiceImpl implements UserStatisticsService {

	@Autowired
	StatisticsRepository statisticsRepository;

	@Override
	public Statistics getUserStatistics(long userId) {
		return statisticsRepository.getUserStatistics(userId);
	}

	@Override
	public Level getUserLevel(long userId) {
		return statisticsRepository.getUserLevel(userId);
	}

	@Override
	public int getUserRanking(long userId) {
		return statisticsRepository.getUserCurrentRanking(userId);
	}

	@Override
	public List<Challenge> getUserChallengeHistory(long userId) {
		return statisticsRepository.getUserGameHistory(userId);
	}

}
