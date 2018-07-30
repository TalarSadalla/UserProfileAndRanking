package repositoryImpl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.userProfileAndRanking.enums.GameType;
import com.example.userProfileAndRanking.model.Game;
import com.example.userProfileAndRanking.model.User;
import com.example.userProfileAndRanking.repository.UserRepositoryImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = UserRepositoryImpl.class)
public class UserRepositoryImplTest {

	@Test
	public void editUserTest() {
		// given
		UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();

		// when
		userRepositoryImpl.initialize();
		userRepositoryImpl.editUser(1,
				new User("Janusz", "Kowalski", "hehe", "janusz@o2.pl", "Good to be back!", new ArrayList<>()));

		// then
		assertEquals(
				"User [userId=" + 1 + ", firstName=" + "Janusz" + ", lastName=" + "Kowalski" + ", password=" + "hehe"
						+ ", email=" + "janusz@o2.pl" + ", liveMotto=" + "Good to be back!" + "]",
				userRepositoryImpl.showUser(1).toString());
	}

	@Test
	public void showUserTest() {
		// given
		UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();

		// when
		userRepositoryImpl.initialize();

		// then
		assertEquals(
				"User [userId=" + 1 + ", firstName=" + "Talar" + ", lastName=" + "Sadalla" + ", password=" + "password"
						+ ", email=" + "talarsadalla@yahoo.com" + ", liveMotto=" + "Just keep walking" + "]",
				userRepositoryImpl.showUser(1).toString());
	}

	@Test
	public void findAllUsersTest() {
		// given
		UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();

		// when
		userRepositoryImpl.initialize();
		List<User> allUsers = userRepositoryImpl.findAllUsers();

		// then
		assertEquals(4, allUsers.size());

	}

	@Test
	public void findUserByIdTest() {
		// given
		UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();

		// when
		userRepositoryImpl.initialize();
		User user = userRepositoryImpl.findUserById(2);
		// then
		assertEquals("User [userId=" + 2 + ", firstName=" + "Joanna" + ", lastName=" + "Polanska" + ", password="
				+ "hehe" + ", email=" + "joanna@gmail.com" + ", liveMotto=" + "Just nike" + "]", user.toString());
	}

	@Test
	public void findUserByFirstNameTest() {
		// given
		UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();

		// when
		userRepositoryImpl.initialize();
		List<User> allUsers = userRepositoryImpl.findUserByFirstName("Talar");

		// then
		assertEquals(1, allUsers.size());
	}

	@Test
	public void findUserByLastNameTest() {
		// given
		UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();

		// when
		userRepositoryImpl.initialize();
		List<User> allUsers = userRepositoryImpl.findUserByLastName("Sadalla");

		// then
		assertEquals(2, allUsers.size());
	}

	@Test
	public void findUserByFirstNameAndLastNameTest() {
		// given
		UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();

		// when
		userRepositoryImpl.initialize();
		List<User> allUsers = userRepositoryImpl.findUserByFirstNameAndLastName("Talar", "Sadalla");

		// then
		assertEquals(1, allUsers.size());
	}

	@Test
	public void findUserByEmailTest() {
		// given
		UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();

		// when
		userRepositoryImpl.initialize();
		List<User> allUsers = userRepositoryImpl.findUserByEmail("talarsadalla@yahoo.com");

		// then
		assertEquals(1, allUsers.size());
	}

	@Test
	public void addGameTest() {
		// given
		UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();

		// when
		userRepositoryImpl.initialize();
		userRepositoryImpl.addGame(1, new Game("Monopoly", GameType.COMBAT, 2, 6, 2.0, true));

		// then
		assertEquals(1, userRepositoryImpl.getUserGameList(1).size());
	}

	@Test
	public void getUserGameListTest() {
		// given
		UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();

		// when
		userRepositoryImpl.initialize();
		userRepositoryImpl.addGame(1, new Game("Monopoly", GameType.COMBAT, 2, 6, 2.0, true));
		List<Game> userGameList = userRepositoryImpl.getUserGameList(1);

		// then
		assertEquals(1, userGameList.size());
	}

}
