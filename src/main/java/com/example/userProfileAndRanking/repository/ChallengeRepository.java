package com.example.userProfileAndRanking.repository;

import java.util.List;

import com.example.userProfileAndRanking.model.Challenge;
import com.example.userProfileAndRanking.model.Game;
import com.example.userProfileAndRanking.model.User;

public interface ChallengeRepository {

	void createChallenge(List<User> userList, Game game);

	void setGameWinner(Long userId, Challenge challenge);

	long getGameWinner(Challenge challenge);

	Challenge getChallenge(Game game);

	List<Challenge> getChallengeList();

}
