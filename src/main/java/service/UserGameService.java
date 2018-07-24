package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Game;
import repositoryInterface.GameRepository;
import repositoryInterface.UserRepository;

@Service
public class UserGameService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	GameRepository gameRepository;

	public void addGame(long userId, Game game) {
		List<Game> userGamesList = userRepository.getUserGameList(userId);
		for (int i = 0; i < userGamesList.size(); i++) {
			if (game.getGameName().equals(userGamesList.get(i).getGameName())) {
				userRepository.addGame(userId, game);
			} else {
				userRepository.addGame(userId, game);
				gameRepository.addGame(game);
			}
		}

	}

}
