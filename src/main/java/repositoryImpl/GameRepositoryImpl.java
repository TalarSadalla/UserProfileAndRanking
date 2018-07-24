package repositoryImpl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Repository;

import enums.GameType;
import model.Game;
import repositoryInterface.GameRepository;

@Repository
public class GameRepositoryImpl implements GameRepository {

	List<Game> gameList;
	List<Game> fullGameList;

	public void Initialize() {
		fullGameList.add(new Game("Monopoly", GameType.WORKER_PLACEMENT, 2, 8, 1.5, true));
		fullGameList.add(new Game("Warhammer", GameType.DECK_BUILDERS, 2, 4, 6, false));
		fullGameList.add(new Game("Scrabble", GameType.WORKER_PLACEMENT, 2, 4, 2, true));
		fullGameList.add(new Game("Chess", GameType.COMBAT, 2, 2, 1.5, true));
		fullGameList.add(new Game("Tousand", GameType.COMBAT, 2, 4, 30, true));
	}

	@Override
	public void addGame(String gameName, GameType gameType, int minimumNumberOfPlayers, int maximumNumberOfPlayers,
			double gameDuration, boolean oneBoardFlag) {
		Game newGame = null;
		newGame.setGameName(gameName);
		newGame.setGameType(gameType);
		newGame.setMinimumNumberOfPlayers(minimumNumberOfPlayers);
		newGame.setMaximumNumberOfPlayers(maximumNumberOfPlayers);
		newGame.setGameDuration(gameDuration);
		newGame.setOneBoardFlag(oneBoardFlag);
		fullGameList.add(newGame);
	}

	@Override
	public void addGame(Game game) {
		Game newGame = game;
		fullGameList.add(newGame);
	}

	@Override
	public Game findGameById(int gameId) {
		if (gameId < 0 || gameId > fullGameList.size())
			throw new IndexOutOfBoundsException();
		for (int i = 0; i < fullGameList.size(); i++) {
			if (fullGameList.get(i).getGameId() == gameId) {
				return fullGameList.get(i);
			}
		}
		throw new NoSuchElementException();
	}

	@Override
	public Game findGameByGameName(String gameName) {
		for (int i = 0; i < fullGameList.size(); i++) {
			if (fullGameList.get(i).getGameName().equals(gameName)) {
				return fullGameList.get(i);
			}
		}
		throw new NoSuchElementException();
	}

	@Override
	public List<Game> findGameByGameType(GameType gameType) {
		List<Game> gameListByType = null;
		for (int i = 0; i < fullGameList.size(); i++) {
			if (fullGameList.get(i).getGameType().equals(gameType)) {
				gameListByType.add(fullGameList.get(i));
			}
		}
		return gameListByType;
	}

	@Override
	public List<Game> findGameByMinimumNuberOfPlayers(int numberOfPlayers) {
		List<Game> gameListByNumberOfPlayers = null;
		for (int i = 0; i < fullGameList.size(); i++) {
			if (fullGameList.get(i).getMinimumNumberOfPlayers() >= numberOfPlayers) {
				gameListByNumberOfPlayers.add(fullGameList.get(i));
			}
		}
		return gameListByNumberOfPlayers;
	}

	@Override
	public List<Game> findGameByMaximumNuberOfPlayers(int numberOfPlayers) {
		// TODO Auto-generated method stub
		return null;
	}

}
