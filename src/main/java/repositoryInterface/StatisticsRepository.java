package repositoryInterface;

import java.util.List;

import enums.Level;
import model.Challenge;
import model.Statistics;

public interface StatisticsRepository {

	Statistics getUserStatistics(long userId);

	Level getUserLevel(long userId);

	Level getUserLevel(long userId, int points);

	int getUserCurrentRanking(long userId);

	List<Challenge> getUserGameHistory(long userId);

	int getUserWins(long userId);

	int getUserLosses(long userId);

	int getUserDraws(long userId);

	int getNumberOfAllUserGames(long userId);

}
