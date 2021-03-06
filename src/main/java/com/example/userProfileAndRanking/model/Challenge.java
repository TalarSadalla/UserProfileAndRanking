package com.example.userProfileAndRanking.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Challenge {

	private List<User> usersList;
	private Game game;
	private long userId;
	private long userWithWin;

	public Challenge() {
		super();
	}

	public Challenge(List<User> usersList, Game game) {
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
