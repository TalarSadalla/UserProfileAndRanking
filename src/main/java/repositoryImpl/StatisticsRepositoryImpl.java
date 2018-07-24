package repositoryImpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import enums.Level;
import model.Game;
import model.Statistics;
import repositoryInterface.StatisticsRepository;

@Repository
public class StatisticsRepositoryImpl implements StatisticsRepository {

	private Map<Integer, List<Statistics>> usersStatistics;

	@Override
	public void getUserStatistics(long userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Level getUserLevel(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getUserCurrentRanking(long userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Game> getUserGameHistory(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
