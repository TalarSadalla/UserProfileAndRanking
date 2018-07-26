package repositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Repository;

import model.Game;
import model.User;
import repositoryInterface.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	List<User> userList = new ArrayList<>();

	public void initialize() {
		userList.add(new User("Talar", "Sadalla", "password", "talarsadalla@yahoo.com", "Just keep walking",
				new ArrayList<>()));
		userList.add(new User("Joanna", "Polanska", "hehe", "joanna@gmail.com", "Just nike", new ArrayList<>()));
		userList.add(new User("Marcin", "Sadalla", "password", "nowak@wp.pl", "Yolo", new ArrayList<>()));
		userList.add(new User("Olek", "Tomaszewski", "1234", "olek@yahoo.com", "Let the force be with You",
				new ArrayList<>()));
	}

	@Override
	public void editUser(long userId, User user) {
		User userToEdit = findUserById(userId);
		userToEdit.setFirstName(user.getFirstName());
		userToEdit.setLastName(user.getLastName());
		userToEdit.setEmail(user.getEmail());
		userToEdit.setLiveMotto(user.getLiveMotto());
		userToEdit.setPassword(user.getPassword());
	}

	@Override
	public User showUser(long userId) {
		User userToShow = findUserById(userId);
		return userToShow;

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
			if (userList.get(i).getId() == userId) {
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
