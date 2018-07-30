package com.example.userProfileAndRanking.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.example.userProfileAndRanking.enums.GameType;
import com.example.userProfileAndRanking.model.Challenge;
import com.example.userProfileAndRanking.model.Game;
import com.example.userProfileAndRanking.model.User;

@Repository
public class ChallengeRepositoryImpl implements ChallengeRepository {

	private List<Challenge> challengelist = new ArrayList<>();
	private List<User> userList1 = new ArrayList<>();
	private List<User> userList2 = new ArrayList<>();
	private List<User> userList3 = new ArrayList<>();
	private List<User> userList4 = new ArrayList<>();
	private List<Game> fullGameList = new ArrayList<>();

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
	}

	@Override
	public void createChallenge(List<User> userList, Game game) {
		if (userList.size() >= game.getMinimumNumberOfPlayers()
				&& userList.size() <= game.getMaximumNumberOfPlayers()) {
			Challenge challenge = new Challenge(userList, game);
			challengelist.add(challenge);
		}
	}

	@Override
	public void setGameWinner(Long userId, Challenge challenge) {
		challenge.setUserWithWin(userId);
	}

	@Override
	public long getGameWinner(Challenge challenge) {
		for (int i = 0; i < challengelist.size(); i++) {
			if (challengelist.get(i).equals(challenge))
				return challengelist.get(i).getUserWithWin();
		}
		throw new NoSuchElementException();
	}

	@Override
	public Challenge getChallenge(Game game) {
		for (int i = 0; i < challengelist.size(); i++) {
			if (challengelist.get(i).getGame().getGameName().equals(game.getGameName()))
				return challengelist.get(i);
		}
		throw new NoSuchElementException();
	}

	@Override
	public List<Challenge> getChallengeList() {
		return challengelist;
	}

}
