package serviceInterface;

import model.User;

public interface UserEditService {

	public void editUser(long userId, User user);

	public User showUser(long userId);
}
