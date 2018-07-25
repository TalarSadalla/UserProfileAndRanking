package serviceInterface;

import java.util.List;

import enums.Level;
import model.Challenge;
import model.Statistics;

public interface UserStatisticsService {

	Statistics getUserStatistics(long userId);

	Level getUserLevel(long userId);

	int getUserRanking(long userId);

	List<Challenge> getUserChallengeHistory(long userId);

}
