package com.example.userProfileAndRanking.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.example.userProfileAndRanking.model.Game;
import com.example.userProfileAndRanking.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	List<User> userList = new ArrayList<>();

	@PostConstruct
	public void initialize() {
		userList.add(new User("Talar", "Sadalla", "password", "talarsadalla@yahoo.com", "Just keep walking",
				new ArrayList<>()));
		userList.add(new User("Joanna", "Polanska", "hehe", "joanna@gmail.com", "Just nike", new ArrayList<>()));
		userList.add(new User("Marcin", "Sadalla", "password", "nowak@wp.pl", "Yolo", new ArrayList<>()));
		userList.add(new User("Olek", "Tomaszewski", "1234", "olek@yahoo.com", "Let the force be with You",
				new ArrayList<>()));
	}

	public UserRepositoryImpl() {
		super();

	}

	@Override
	public User editUser(long userId, User user) {
		User userToEdit = findUserById(userId);
		userToEdit.setFirstName(user.getFirstName());
		userToEdit.setLastName(user.getLastName());
		userToEdit.setEmail(user.getEmail());
		userToEdit.setLiveMotto(user.getLiveMotto());
		userToEdit.setPassword(user.getPassword());
		return userToEdit;
	}

	@Override
	public User showUser(long userId) {
		User userToShow = findUserById(userId);
		return userToShow;

	}

	@Override
	public User deleteUser(long userId) {
		User userToDelete = findUserById(userId);
		userList.remove(userToDelete);
		return userToDelete;

	}

	@Override
	public List<User> findAllUsers() {
		return userList;
	}

	@Override
	public User findUserById(long userId) {
		if (userId < 0 || userId > userList.size())
			throw new IndexOutOfBoundsException();
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUserId() == userId) {
				return userList.get(i);
			}
		}
		throw new NoSuchElementException();
	}

	@Override
	public List<User> findUserByFirstName(String firstName) {
		List<User> usersWithFirstName = new ArrayList<>();
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getFirstName().equals(firstName)) {
				usersWithFirstName.add(userList.get(i));
			}
		}
		return usersWithFirstName;
	}

	@Override
	public List<User> findUserByLastName(String lastName) {
		List<User> usersWithLastName = new ArrayList<>();
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getLastName().equals(lastName)) {
				usersWithLastName.add(userList.get(i));
			}
		}
		return usersWithLastName;
	}

	@Override
	public List<User> findUserByFirstNameAndLastName(String firstName, String lastName) {
		List<User> usersWithFirstNameLastName = new ArrayList<>();
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getFirstName().equals(firstName) && userList.get(i).getLastName().equals(lastName)) {
				usersWithFirstNameLastName.add(userList.get(i));
			}
		}
		return usersWithFirstNameLastName;
	}

	@Override
	public List<User> findUserByFirstNameAndLastNameAndEmail(String firstName, String lastName, String email) {
		List<User> usersWithFirstNameLastName = new ArrayList<>();
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getFirstName().equals(firstName) && userList.get(i).getLastName().equals(lastName)
					&& userList.get(i).getEmail().equals(email)) {
				usersWithFirstNameLastName.add(userList.get(i));
			}
		}
		return usersWithFirstNameLastName;
	}

	@Override
	public List<User> findUserByEmail(String email) {
		List<User> usersWithEmail = new ArrayList<>();
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getEmail().equals(email)) {
				usersWithEmail.add(userList.get(i));
			}
		}
		return usersWithEmail;
	}

	@Override
	public List<User> findUserByLiveMotto(String liveMotto) {
		List<User> usersWithLiveMotto = new ArrayList<>();
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getLiveMotto().equals(liveMotto)) {
				usersWithLiveMotto.add(userList.get(i));
			}
		}
		return usersWithLiveMotto;
	}

	@Override
	public void addGame(long userId, Game game) {
		User user = findUserById(userId);
		List<Game> userGamesList = user.getUserGamesList();
		userGamesList.add(game);
		user.setUserGamesList(userGamesList);
	}

	@Override
	public List<Game> getUserGameList(long userId) {
		User user = findUserById(userId);
		List<Game> userGamesList = user.getUserGamesList();
		return userGamesList;
	}

	@Override
	public Game deleteGame(long userId, Game game) {
		User user = findUserById(userId);
		List<Game> userGamesList = user.getUserGamesList();
		userGamesList.remove(game);
		return game;
	}

}
