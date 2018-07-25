package serviceInterface;

import java.util.List;

import model.Game;

public interface UserGameService {

	public void addGame(long userId, Game game);

	public List<Game> userGameCollection(long userId);

	public void removeGameFromUserCollection(long userId, Game game);
}
