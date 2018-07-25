package serviceInterface;

import java.util.List;

import dto.GameTO;

public interface UserGameService {

	public void addGame(long userId, GameTO gameTO);

	public List<GameTO> userGameCollection(long userId);

	public void removeGameFromUserCollection(long userId, GameTO gameTO);
}
