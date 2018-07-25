package serviceInterface;

import dto.UserTO;

public interface UserEditService {

	public void editUser(long userId, UserTO userTO);

	public UserTO showUser(long userId);
}
