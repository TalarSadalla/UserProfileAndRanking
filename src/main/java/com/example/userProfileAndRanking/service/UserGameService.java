package com.example.userProfileAndRanking.service;

import java.util.List;

import com.example.userProfileAndRanking.dto.GameTO;

public interface UserGameService {

	public void addGame(long userId, GameTO gameTO);

	public List<GameTO> userGameCollection(long userId);

	public void removeGameFromUserCollection(long userId, GameTO gameTO);
}
