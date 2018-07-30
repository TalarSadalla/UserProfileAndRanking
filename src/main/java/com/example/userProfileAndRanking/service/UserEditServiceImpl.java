package com.example.userProfileAndRanking.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userProfileAndRanking.dto.UserTO;
import com.example.userProfileAndRanking.model.User;
import com.example.userProfileAndRanking.repository.UserRepository;

@Service
public class UserEditServiceImpl implements UserEditService {

	@Autowired
	private UserRepository userRepository;

	private ModelMapper modelMapper = new ModelMapper();

	public UserTO editUser(long userId, UserTO userTO) {
		User user = modelMapper.map(userTO, User.class);
		User editedUser = userRepository.editUser(userId, user);
		UserTO editedUserTO = modelMapper.map(editedUser, UserTO.class);
		return editedUserTO;
	}

	public UserTO showUser(long userId) {
		UserTO userTO = modelMapper.map(userRepository.showUser(userId), UserTO.class);
		return userTO;
	}

	public UserTO deleteUser(long userId) {
		UserTO userTO = modelMapper.map(userRepository.deleteUser(userId), UserTO.class);
		return userTO;
	}

	@Override
	public List<UserTO> findUserByFirstName(String firstName) {
		return modelMapper.map(userRepository.findUserByFirstName(firstName), UserTO.class);
	}

	@Override
	public List<UserTO> findUserByLastName(String lastName) {
		return modelMapper.map(userRepository.findUserByLastName(lastName), UserTO.class);
	}

	@Override
	public List<UserTO> findUserByEmail(String email) {
		return modelMapper.map(userRepository.findUserByEmail(email), UserTO.class);
	}

	@Override
	public List<UserTO> findUserByFirstNameAndLastName(String firstName, String lastName) {
		return modelMapper.map(userRepository.findUserByFirstNameAndLastName(firstName, lastName), UserTO.class);
	}

	public List<UserTO> findUserByLiveMotto(String liveMotto) {
		return modelMapper.map(userRepository.findUserByLiveMotto(liveMotto), UserTO.class);
	}

	@Override
	public List<UserTO> findUser(UserTO userTO) {
		User usertoFind = modelMapper.map(userTO, User.class);
		List<User> foundUsersList = new ArrayList<>();
		if (usertoFind.getFirstName() != null && usertoFind.getLastName() != null && usertoFind.getEmail() != null) {
			foundUsersList.addAll(userRepository.findUserByFirstNameAndLastNameAndEmail(usertoFind.getFirstName(),
					usertoFind.getLastName(), usertoFind.getEmail()));
		} else if (usertoFind.getFirstName() != null && usertoFind.getLastName() == null
				&& usertoFind.getEmail() == null) {
			foundUsersList.addAll(userRepository.findUserByFirstName(usertoFind.getFirstName()));
		} else if (usertoFind.getFirstName() == null && usertoFind.getLastName() != null
				&& usertoFind.getEmail() == null) {
			foundUsersList.addAll(userRepository.findUserByLastName(usertoFind.getLastName()));
		} else if (usertoFind.getFirstName() == null && usertoFind.getLastName() == null
				&& usertoFind.getEmail() != null) {
			foundUsersList.addAll(userRepository.findUserByEmail(usertoFind.getEmail()));
		}

		List<UserTO> foundUsersListTO = new ArrayList<>();
		for (int i = 0; i < foundUsersList.size(); i++) {
			foundUsersListTO.add(modelMapper.map(foundUsersList.get(i), UserTO.class));
		}
		return foundUsersListTO;
	}
}
