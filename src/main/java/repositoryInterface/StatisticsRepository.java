package repositoryInterface;

import java.util.List;

import enums.Level;
import model.Game;

public interface StatisticsRepository {

	void getUserStatistics(long userId);

	Level getUserLevel(long userId);

	int getUserCurrentRanking(long userId);

	List<Game> getUserGameHistory(long userId);

}
