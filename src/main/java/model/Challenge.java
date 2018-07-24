package model;

import java.util.List;

public class Challenge {

	private List<User> usersList;
	private Game game;
	private int UserId;

	public Challenge(List<User> usersList, Game game) {
		super();
		this.usersList = usersList;
		this.game = game;
	}

	public List<User> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<User> usersList) {
		this.usersList = usersList;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

}
