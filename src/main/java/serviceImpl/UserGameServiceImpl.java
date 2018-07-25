package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Game;
import repositoryInterface.GameRepository;
import repositoryInterface.UserRepository;
import serviceInterface.UserGameService;

@Service
public class UserGameServiceImpl implements UserGameService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	GameRepository gameRepository;

	public void addGame(long userId, Game game) {
		List<Game> userGamesList = userRepository.getUserGameList(userId);
		List<Game> fullGameList = gameRepository.getListOfAllGames();
		for (int i = 0; i < fullGameList.size(); i++) {
			if (!(game.getGameName().equals(fullGameList.get(i).getGameName()))) {
				gameRepository.addGame(game);
				userRepository.addGame(userId, game);
			} else {
				for (int j = 0; j < userGamesList.size(); j++) {
					if (!(game.getGameName().equals(userGamesList.get(i).getGameName()))) {
						userRepository.addGame(userId, game);
					}
				}
			}
		}
	}

	public List<Game> userGameCollection(long userId) {
		return userRepository.getUserGameList(userId);
	}

	public void removeGameFromUserCollection(long userId, Game game) {
		List<Game> userGameCollectionList = userGameCollection(userId);
		Game gameToDelete = gameRepository.findGameByGameName(game.getGameName());
		userGameCollectionList.remove(gameToDelete);
	}

}
