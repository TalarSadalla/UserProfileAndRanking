package repositoryInterface;

import java.util.List;

import enums.GameType;
import model.Game;

public interface GameRepository {

	void addGame(String gameName, GameType gameType, int minimumNumberOfPlayers, int maximumNumberOfPlayers,
			double gameDuration, boolean oneBoardFlag);

	void addGame(Game game);

	Game findGameById(int gameId);

	public Game findGameByGameName(String gameName);

	public List<Game> getListOfAllGames();

	public List<Game> findGameByGameType(GameType gameType);

	public List<Game> findGameByMinimumNuberOfPlayers(int numberOfPlayers);

	public List<Game> findGameByMaximumNuberOfPlayers(int numberOfPlayers);

}
