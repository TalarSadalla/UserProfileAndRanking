package com.example.userProfileAndRanking.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userProfileAndRanking.dto.GameTO;
import com.example.userProfileAndRanking.model.Game;
import com.example.userProfileAndRanking.repository.GameRepository;
import com.example.userProfileAndRanking.repository.UserRepository;

@Service
public class UserGameServiceImpl implements UserGameService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	GameRepository gameRepository;

	private ModelMapper modelMapper = new ModelMapper();

	public void addGame(long userId, GameTO gameTO) {
		Game game = modelMapper.map(gameTO, Game.class);
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

	public List<GameTO> userGameCollection(long userId) {
		List<GameTO> userGameTOList = new ArrayList<>();
		List<Game> userGameList = userRepository.getUserGameList(userId);
		userGameTOList.add(modelMapper.map(userGameList, GameTO.class));
		return userGameTOList;
	}

	public void removeGameFromUserCollection(long userId, GameTO gameTO) {
		Game game = modelMapper.map(gameTO, Game.class);
		List<GameTO> userGameCollectionList = userGameCollection(userId);
		GameTO gameToDeleteTO = modelMapper.map(gameRepository.findGameByGameName(game.getGameName()), GameTO.class);
		userGameCollectionList.remove(gameToDeleteTO);
	}

}
