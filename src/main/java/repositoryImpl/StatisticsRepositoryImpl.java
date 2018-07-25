package repositoryImpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import enums.GameType;
import enums.Level;
import model.Challenge;
import model.Game;
import model.Statistics;
import model.User;
import repositoryInterface.StatisticsRepository;

@Repository
public class StatisticsRepositoryImpl implements StatisticsRepository {

	private Map<Integer, Statistics> usersStatistics;

	List<User> userList1;
	List<User> userList2;
	List<User> userList3;
	List<User> userList4;
	List<Game> fullGameList;
	List<Challenge> challengelist;

	public void initialize() {

		userList1.add(new User("Talar", "Sadalla", "password", "talarsadalla@yahoo.com", "Just keep walking"));
		userList1.add(new User("Joanna", "Polanska", "hehe", "joanna@gmail.com", "Just nike"));
		userList1.add(new User("Marcin", "Nowak", "password", "nowak@wp.pl", "Yolo"));
		userList1.add(new User("Olek", "Tomaszewski", "1234", "olek@yahoo.com", "Let the force be with You"));

		userList2.add(new User("Talar", "Sadalla", "password", "talarsadalla@yahoo.com", "Just keep walking"));
		userList2.add(new User("Joanna", "Polanska", "hehe", "joanna@gmail.com", "Just nike"));
		userList2.add(new User("Marcin", "Nowak", "password", "nowak@wp.pl", "Yolo"));

		userList3.add(new User("Talar", "Sadalla", "password", "talarsadalla@yahoo.com", "Just keep walking"));
		userList3.add(new User("Marcin", "Nowak", "password", "nowak@wp.pl", "Yolo"));
		userList3.add(new User("Olek", "Tomaszewski", "1234", "olek@yahoo.com", "Let the force be with You"));

		userList4.add(new User("Talar", "Sadalla", "password", "talarsadalla@yahoo.com", "Just keep walking"));
		userList4.add(new User("Joanna", "Polanska", "hehe", "joanna@gmail.com", "Just nike"));
		userList4.add(new User("Olek", "Tomaszewski", "1234", "olek@yahoo.com", "Let the force be with You"));

		fullGameList.add(new Game("Monopoly", GameType.WORKER_PLACEMENT, 2, 8, 1.5, true));
		fullGameList.add(new Game("Warhammer", GameType.DECK_BUILDERS, 2, 4, 6, false));
		fullGameList.add(new Game("Scrabble", GameType.WORKER_PLACEMENT, 2, 4, 2, true));
		fullGameList.add(new Game("Chess", GameType.COMBAT, 2, 2, 1.5, true));

		challengelist.add(new Challenge(userList1, fullGameList.get(0)));
		challengelist.add(new Challenge(userList2, fullGameList.get(1)));
		challengelist.add(new Challenge(userList3, fullGameList.get(2)));
		challengelist.add(new Challenge(userList4, fullGameList.get(3)));

		usersStatistics.put(1, new Statistics(1, Level.BEGINNER, 4, 4, 20, 15, challengelist));
		usersStatistics.put(2, new Statistics(1, Level.CHUCK_NORRIS_OF_CHESS, 1, 405, 28, 31, challengelist));
		usersStatistics.put(3, new Statistics(1, Level.EXPERIENCED_MIDDLEBORW, 3, 152, 48, 66, challengelist));
		usersStatistics.put(4, new Statistics(1, Level.PROFESSIONAL, 2, 250, 34, 58, challengelist));
	}

	@Override
	public Statistics getUserStatistics(long userId) {
		return usersStatistics.get(userId);
	}

	@Override
	public Level getUserLevel(long userId) {
		return usersStatistics.get(userId).getLevel();
	}

	@Override
	public Level getUserLevel(long userId, int points) {
		return usersStatistics.get(userId).getLevel().getLevelByValue(points);
	}

	@Override
	public int getUserCurrentRanking(long userId) {
		return usersStatistics.get(userId).getRankingPosition();
	}

	@Override
	public List<Challenge> getUserGameHistory(long userId) {
		return usersStatistics.get(userId).getUserGameHistory();
	}

	@Override
	public int getUserWins(long userId) {
		return usersStatistics.get(userId).getWin();
	}

	@Override
	public int getUserLosses(long userId) {
		return usersStatistics.get(userId).getLoss();
	}

	@Override
	public int getUserDraws(long userId) {
		return usersStatistics.get(userId).getDraw();
	}

	@Override
	public int getNumberOfAllUserGames(long userId) {
		return usersStatistics.get(userId).numberOfAllGames();
	}

}
