package serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.User;
import repositoryImpl.UserRepositoryImpl;
import serviceInterface.UserEditService;

@Service
public class UserEditServiceImpl implements UserEditService {

	@Autowired
	private UserRepositoryImpl userRepositoryImpl;

	public void editUser(long userId, User user) {
		userRepositoryImpl.editUser(userId, user);
	}

	public User showUser(long userId) {
		return userRepositoryImpl.showUser(userId);
	}

}
