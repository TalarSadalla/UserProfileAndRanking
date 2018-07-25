package serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.UserTO;
import model.User;
import repositoryImpl.UserRepositoryImpl;
import serviceInterface.UserEditService;

@Service
public class UserEditServiceImpl implements UserEditService {

	@Autowired
	private UserRepositoryImpl userRepositoryImpl;

	@Autowired
	private ModelMapper modelMapper;

	public void editUser(long userId, UserTO userTO) {
		User user = modelMapper.map(userTO, User.class);
		userRepositoryImpl.editUser(userId, user);
	}

	public UserTO showUser(long userId) {
		UserTO userTO = modelMapper.map(userRepositoryImpl.showUser(userId), UserTO.class);
		return userTO;
	}

}
