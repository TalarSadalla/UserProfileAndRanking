package com.example.userProfileAndRanking.service;

import java.util.List;

import com.example.userProfileAndRanking.dto.UserTO;

public interface UserEditService {

	UserTO editUser(long userId, UserTO userTO);

	UserTO showUser(long userId);

	UserTO deleteUser(long userId);

	List<UserTO> findUserByFirstName(String firstName);

	List<UserTO> findUserByLastName(String lastName);

	List<UserTO> findUserByEmail(String email);

	List<UserTO> findUserByLiveMotto(String liveMotto);

	List<UserTO> findUserByFirstNameAndLastName(String firstName, String lastName);

	List<UserTO> findUser(UserTO userTO);

}
