package com.example.userProfileAndRanking.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.example.userProfileAndRanking.enums.GameType;
import com.example.userProfileAndRanking.enums.Level;
import com.example.userProfileAndRanking.model.Challenge;
import com.example.userProfileAndRanking.model.Game;
import com.example.userProfileAndRanking.model.Statistics;
import com.example.userProfileAndRanking.model.User;

@Repository
public class StatisticsRepositoryImpl implements StatisticsRepository {

	private Map<Integer, Statistics> usersStatistics = new HashMap<>();

	List<User> userList1 = new ArrayList<>();
	List<User> userList2 = new ArrayList<>();
	List<User> userList3 = new ArrayList<>();
	List<User> userList4 = new ArrayList<>();
	List<Game> fullGameList = new ArrayList<>();
	List<Challenge> challengelist = new ArrayList<>();

	@PostConstruct
	public void initialize() {

		userList1.add(new User("Talar", "Sadalla", "password", "talarsadalla@yahoo.com", "Just keep walking",
				new ArrayList<>()));
		userList1.add(new User("Joanna", "Polanska", "hehe", "joanna@gmail.com", "Just nike", new ArrayList<>()));
		userList1.add(new User("Marcin", "Nowak", "password", "nowak@wp.pl", "Yolo", new ArrayList<>()));
		userList1.add(new User("Olek", "Tomaszewski", "1234", "olek@yahoo.com", "Let the force be with You",
				new ArrayList<>()));

		userList2.add(new User("Talar", "Sadalla", "password", "talarsadalla@yahoo.com", "Just keep walking",
				new ArrayList<>()));
		userList2.add(new User("Joanna", "Polanska", "hehe", "joanna@gmail.com", "Just nike", new ArrayList<>()));
		userList2.add(new User("Marcin", "Nowak", "password", "nowak@wp.pl", "Yolo", new ArrayList<>()));

		userList3.add(new User("Talar", "Sadalla", "password", "talarsadalla@yahoo.com", "Just keep walking",
				new ArrayList<>()));
		userList3.add(new User("Marcin", "Nowak", "password", "nowak@wp.pl", "Yolo", new ArrayList<>()));
		userList3.add(new User("Olek", "Tomaszewski", "1234", "olek@yahoo.com", "Let the force be with You",
				new ArrayList<>()));

		userList4.add(new User("Talar", "Sadalla", "password", "talarsadalla@yahoo.com", "Just keep walking",
				new ArrayList<>()));
		userList4.add(new User("Joanna", "Polanska", "hehe", "joanna@gmail.com", "Just nike", new ArrayList<>()));
		userList4.add(new User("Olek", "Tomaszewski", "1234", "olek@yahoo.com", "Let the force be with You",
				new ArrayList<>()));

		fullGameList.add(new Game("Monopoly", GameType.WORKER_PLACEMENT, 2, 8, 1.5, true));
		fullGameList.add(new Game("Warhammer", GameType.DECK_BUILDERS, 2, 4, 6, false));
		fullGameList.add(new Game("Scrabble", GameType.WORKER_PLACEMENT, 2, 4, 2, true));
		fullGameList.add(new Game("Chess", GameType.COMBAT, 2, 2, 1.5, true));

		challengelist.add(new Challenge(userList1, fullGameList.get(0)));
		challengelist.add(new Challenge(userList2, fullGameList.get(1)));
		challengelist.add(new Challenge(userList3, fullGameList.get(2)));
		challengelist.add(new Challenge(userList4, fullGameList.get(3)));

		usersStatistics.put(1, new Statistics(1, Level.BEGINNER, 4, 4, 20, 15, challengelist));
		usersStatistics.put(2, new Statistics(2, Level.CHUCK_NORRIS_OF_BOARDGAMES, 1, 405, 28, 31, challengelist));
		usersStatistics.put(3, new Statistics(3, Level.EXPERIENCED_MIDDLEBORW, 3, 152, 48, 66, challengelist));
		usersStatistics.put(4, new Statistics(4, Level.PROFESSIONAL, 2, 250, 34, 58, challengelist));
	}

	@Override
	public Statistics getUserStatistics(long userId) {
		return usersStatistics.get((int) userId);
	}

	@Override
	public Level getUserLevel(long userId) {
		return usersStatistics.get((int) userId).getLevel();
	}

	@Override
	public int getUserCurrentRanking(long userId) {
		return usersStatistics.get((int) userId).getRankingPosition();
	}

	@Override
	public List<Challenge> getUserGameHistory(long userId) {
		return usersStatistics.get((int) userId).getUserGameHistory();
	}

	@Override
	public int getUserWins(long userId) {
		return usersStatistics.get((int) userId).getWin();
	}

	@Override
	public int getUserLosses(long userId) {
		return usersStatistics.get((int) userId).getLoss();
	}

	@Override
	public int getUserDraws(long userId) {
		return usersStatistics.get((int) userId).getDraw();
	}

	@Override
	public int getNumberOfAllUserGames(long userId) {
		return usersStatistics.get((int) userId).numberOfAllGames();
	}

}
