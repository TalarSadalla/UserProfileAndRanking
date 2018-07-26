package dto;

import java.util.List;

import org.springframework.stereotype.Component;

import model.Game;
import model.User;

@Component
public class ChallengeTO {

	private List<User> usersList;
	private Game game;
	private long userId;
	private long userWithWin;

	public ChallengeTO(List<User> usersList, Game game) {
		super();
		this.usersList = usersList;
		this.game = game;
	}

	public List<User> getUsersList() {
		return usersList;
	}

	public Game getGame() {
		return game;
	}

	public long getUserWithWin() {
		return userWithWin;
	}

	public void setUserWithWin(long userId) {
		this.userWithWin = userId;
	}

}
