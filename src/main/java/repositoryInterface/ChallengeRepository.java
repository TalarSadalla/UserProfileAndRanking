package repositoryInterface;

import java.util.List;

import model.Challenge;
import model.Game;
import model.User;

public interface ChallengeRepository {

	void createChallenge(List<User> userList, Game game);

	void setGameWinner(Long userId, Challenge challenge);

	long getGameWinner(Challenge challenge);

	Challenge getChallenge(Game game);

	List<Challenge> getChallengeList();

}
