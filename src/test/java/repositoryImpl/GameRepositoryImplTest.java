package repositoryImpl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import enums.GameType;
import model.Game;
import repositoryImpl.GameRepositoryImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameRepositoryImplTest {

	@Test
	public void initializeData() {

		// given
		GameRepositoryImpl gameRepositoryImpl = new GameRepositoryImpl();

		// when
		gameRepositoryImpl.Initialize();
		List<Game> gameList = gameRepositoryImpl.getListOfAllGames();

		// then
		assertEquals(5, gameList.size());

	}

	@Test
	public void addGameTest() {
		// given
		GameRepositoryImpl gameRepositoryImpl = new GameRepositoryImpl();

		// when
		gameRepositoryImpl.Initialize();
		gameRepositoryImpl.addGame("ToyStory", GameType.CO_OP, 1, 4, 5.0, false);
		List<Game> gameList = gameRepositoryImpl.getListOfAllGames();

		// then
		assertEquals(6, gameList.size());

	}

	@Test
	public void addGameByGameTest() {
		// given
		GameRepositoryImpl gameRepositoryImpl = new GameRepositoryImpl();
		Game game = new Game("ToyStory", GameType.CO_OP, 1, 4, 5.0, false);
		// when
		gameRepositoryImpl.Initialize();
		gameRepositoryImpl.addGame(game);
		List<Game> gameList = gameRepositoryImpl.getListOfAllGames();

		// then
		assertEquals(6, gameList.size());
	}

	@Test
	public void findGameByIdTest() {
		// given
		GameRepositoryImpl gameRepositoryImpl = new GameRepositoryImpl();

		// when
		gameRepositoryImpl.Initialize();
		Game game = gameRepositoryImpl.findGameById(3);

		// then
		assertEquals("Game [gameId=" + 3 + ", gameType=" + GameType.WORKER_PLACEMENT + ", gameName=" + "Scrabble"
				+ ", minimumNumberOfPlayers=" + 2 + ", maximumNumberOfPlayers=" + 4 + ", gameDuration=" + 2.0
				+ ", oneBoardFlag=" + true + "]", game.toString());
	}

	@Test
	public void findGameByGameNameTest() {

		// given
		GameRepositoryImpl gameRepositoryImpl = new GameRepositoryImpl();

		// when
		gameRepositoryImpl.Initialize();
		Game game = gameRepositoryImpl.findGameByGameName("Warhammer");

		// then
		assertEquals("Game [gameId=" + 2 + ", gameType=" + GameType.DECK_BUILDERS + ", gameName=" + "Warhammer"
				+ ", minimumNumberOfPlayers=" + 2 + ", maximumNumberOfPlayers=" + 4 + ", gameDuration=" + 6.0
				+ ", oneBoardFlag=" + false + "]", game.toString());
	}

	@Test
	public void getListOfAllGamesTest() {
		// given
		GameRepositoryImpl gameRepositoryImpl = new GameRepositoryImpl();

		// when
		gameRepositoryImpl.Initialize();
		List<Game> gameList = gameRepositoryImpl.getListOfAllGames();

		// then
		assertEquals(5, gameList.size());
	}

	@Test
	public void findGameByGameTypeTest() {
		// given
		GameRepositoryImpl gameRepositoryImpl = new GameRepositoryImpl();

		// when
		gameRepositoryImpl.Initialize();
		List<Game> gameList1 = gameRepositoryImpl.findGameByGameType(GameType.WORKER_PLACEMENT);
		List<Game> gameList2 = gameRepositoryImpl.findGameByGameType(GameType.DECK_BUILDERS);
		List<Game> gameList3 = gameRepositoryImpl.findGameByGameType(GameType.COMBAT);
		List<Game> gameList4 = gameRepositoryImpl.findGameByGameType(GameType.AREA_CONTROL);
		List<Game> gameList5 = gameRepositoryImpl.findGameByGameType(GameType.LEGACY);

		// then
		assertEquals(2, gameList1.size());
		assertEquals(1, gameList2.size());
		assertEquals(1, gameList3.size());
		assertEquals(1, gameList4.size());
		assertEquals(0, gameList5.size());
	}

	@Test
	public void findGameByMinimumNuberOfPlayersTest() {
		// given
		GameRepositoryImpl gameRepositoryImpl = new GameRepositoryImpl();

		// when
		gameRepositoryImpl.Initialize();
		List<Game> gameList1 = gameRepositoryImpl.findGameByMinimumNuberOfPlayers(3);
		List<Game> gameList2 = gameRepositoryImpl.findGameByMinimumNuberOfPlayers(2);
		List<Game> gameList3 = gameRepositoryImpl.findGameByMinimumNuberOfPlayers(4);
		List<Game> gameList4 = gameRepositoryImpl.findGameByMinimumNuberOfPlayers(1);
		List<Game> gameList5 = gameRepositoryImpl.findGameByMinimumNuberOfPlayers(5);

		// then
		assertEquals(0, gameList1.size());
		assertEquals(5, gameList2.size());
		assertEquals(0, gameList3.size());
		assertEquals(5, gameList4.size());
		assertEquals(0, gameList5.size());
	}

	@Test
	public void findGameByMaximumNuberOfPlayersTest() {
		// given
		GameRepositoryImpl gameRepositoryImpl = new GameRepositoryImpl();

		// when
		gameRepositoryImpl.Initialize();
		List<Game> gameList1 = gameRepositoryImpl.findGameByMaximumNuberOfPlayers(3);
		List<Game> gameList2 = gameRepositoryImpl.findGameByMaximumNuberOfPlayers(2);
		List<Game> gameList3 = gameRepositoryImpl.findGameByMaximumNuberOfPlayers(4);
		List<Game> gameList4 = gameRepositoryImpl.findGameByMaximumNuberOfPlayers(1);
		List<Game> gameList5 = gameRepositoryImpl.findGameByMaximumNuberOfPlayers(5);

		// then
		assertEquals(1, gameList1.size());
		assertEquals(1, gameList2.size());
		assertEquals(4, gameList3.size());
		assertEquals(0, gameList4.size());
		assertEquals(4, gameList5.size());
	}
}
