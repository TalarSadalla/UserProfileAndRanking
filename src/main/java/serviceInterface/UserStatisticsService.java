package serviceInterface;

import java.util.List;

import dto.ChallengeTO;
import dto.LevelTO;
import dto.StatisticsTO;

public interface UserStatisticsService {

	StatisticsTO getUserStatistics(long userId);

	LevelTO getUserLevel(long userId);

	int getUserRanking(long userId);

	List<ChallengeTO> getUserChallengeHistory(long userId);

}
