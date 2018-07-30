package com.example.userProfileAndRanking.repository;

import java.util.List;

import com.example.userProfileAndRanking.model.Game;
import com.example.userProfileAndRanking.model.User;

public interface UserRepository {

	User editUser(long userId, User user);

	User showUser(long userId);

	User deleteUser(long userId);

	List<User> findAllUsers();

	User findUserById(long userId);

	List<User> findUserByFirstName(String firstName);

	List<User> findUserByLastName(String lastName);

	List<User> findUserByFirstNameAndLastName(String firstName, String lastName);

	List<User> findUserByFirstNameAndLastNameAndEmail(String firstName, String lastName, String email);

	List<User> findUserByEmail(String email);

	List<User> findUserByLiveMotto(String liveMotto);

	void addGame(long userId, Game game);

	Game deleteGame(long userId, Game game);

	List<Game> getUserGameList(long userId);

}
