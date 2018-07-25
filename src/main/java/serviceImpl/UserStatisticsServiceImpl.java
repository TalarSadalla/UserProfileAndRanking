package serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.ChallengeTO;
import dto.LevelTO;
import dto.StatisticsTO;
import repositoryInterface.StatisticsRepository;
import serviceInterface.UserStatisticsService;

@Service
public class UserStatisticsServiceImpl implements UserStatisticsService {

	@Autowired
	StatisticsRepository statisticsRepository;

	@Autowired
	private ModelMapper modelMapper;

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
