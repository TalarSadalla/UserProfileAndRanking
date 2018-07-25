package repositoryImpl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Repository;

import enums.GameType;
import model.Challenge;
import model.Game;
import model.User;
import repositoryInterface.ChallengeRepository;

@Repository
public class ChallengeRepositoryImpl implements ChallengeRepository {

	List<Challenge> challengelist;
	List<User> userList1;
	List<User> userList2;
	List<User> userList3;
	List<User> userList4;
	List<Game> fullGameList;

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
	public Challenge getChallenge(Game game) {
		for (int i = 0; i < challengelist.size(); i++) {
			if (challengelist.get(i).getGame().equals(game.getGameName()))
				return challengelist.get(i);
		}
		throw new NoSuchElementException();
	}

}
