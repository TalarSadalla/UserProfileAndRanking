package repositoryInterface;

import java.util.List;

import model.Game;
import model.User;

public interface UserRepository {

	void editUser(long userId, User user);

	User showUser(long userId);

	List<User> findAllUsers();

	User findUserById(long userId);

	List<User> findUserByFirstName(String firstName);

	List<User> findUserByLastName(String lastName);

	List<User> findUserByFirstNameAndLastName(String firstName, String lastName);

	List<User> findUserByEmail(String email);

	void addGame(long userId, Game game);

	Game deleteGame(long userId, Game game);

	List<Game> getUserGameList(long userId);

}
