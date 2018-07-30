package repositoryImpl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.userProfileAndRanking.enums.Level;
import com.example.userProfileAndRanking.model.Challenge;
import com.example.userProfileAndRanking.model.Statistics;
import com.example.userProfileAndRanking.repository.StatisticsRepositoryImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = StatisticsRepositoryImpl.class)
public class StatisticsRepositoryImplTest {

	@Test
	public void getUserStatisticsTest() {
		// given
		StatisticsRepositoryImpl statisticsRepositoryImpl = new StatisticsRepositoryImpl();

		// when
		statisticsRepositoryImpl.initialize();
		Statistics statistics = statisticsRepositoryImpl.getUserStatistics(1);

		// then
		assertEquals("Statistics [gameId=" + 1 + ", level=" + Level.BEGINNER + ", rankingPosition=" + 4 + ", win=" + 4
				+ ", loss=" + 20 + ", draw=" + 15 + "]", statistics.toString());
	}

	@Test
	public void getUserLevelTest() {

		// given
		StatisticsRepositoryImpl statisticsRepositoryImpl = new StatisticsRepositoryImpl();

		// when
		statisticsRepositoryImpl.initialize();
		Level userLevel = statisticsRepositoryImpl.getUserLevel(2);

		// then
		assertEquals(Level.CHUCK_NORRIS_OF_BOARDGAMES, userLevel);
	}

	@Test
	public void getUserCurrentRankingTest() {
		// given
		StatisticsRepositoryImpl statisticsRepositoryImpl = new StatisticsRepositoryImpl();

		// when
		statisticsRepositoryImpl.initialize();
		int userRanking = statisticsRepositoryImpl.getUserCurrentRanking(1);

		// then
		assertEquals(4, userRanking);
	}

	@Test
	public void getUserGameHistoryTest() {
		// given
		StatisticsRepositoryImpl statisticsRepositoryImpl = new StatisticsRepositoryImpl();

		// when
		statisticsRepositoryImpl.initialize();
		List<Challenge> userChallengeList = statisticsRepositoryImpl.getUserGameHistory(1);

		// then
		assertEquals(4, userChallengeList.size());
	}

	@Test
	public void getUserWinsTest() {

		// given
		StatisticsRepositoryImpl statisticsRepositoryImpl = new StatisticsRepositoryImpl();

		// when
		statisticsRepositoryImpl.initialize();
		int userWins = statisticsRepositoryImpl.getUserWins(1);

		// then
		assertEquals(4, userWins);
	}

	@Test
	public void getUserLossesTest() {

		// given
		StatisticsRepositoryImpl statisticsRepositoryImpl = new StatisticsRepositoryImpl();

		// when
		statisticsRepositoryImpl.initialize();
		int userLosses = statisticsRepositoryImpl.getUserLosses(1);

		// then
		assertEquals(20, userLosses);
	}

	@Test
	public void getUserDrawsTest() {

		// given
		StatisticsRepositoryImpl statisticsRepositoryImpl = new StatisticsRepositoryImpl();

		// when
		statisticsRepositoryImpl.initialize();
		int userDraws = statisticsRepositoryImpl.getUserDraws(1);

		// then
		assertEquals(15, userDraws);
	}

	@Test
	public void getNumberOfAllUserGamesTest() {
		// given
		StatisticsRepositoryImpl statisticsRepositoryImpl = new StatisticsRepositoryImpl();

		// when
		statisticsRepositoryImpl.initialize();
		int userAllGames = statisticsRepositoryImpl.getNumberOfAllUserGames(1);

		// then
		assertEquals(39, userAllGames);
	}

}
