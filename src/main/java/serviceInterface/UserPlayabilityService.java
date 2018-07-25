package serviceInterface;

import java.util.List;

import model.Availability;
import model.User;

public interface UserPlayabilityService {

	public void addUserAvailabilityHours(Long userId, String beginHour, String endHour);

	public void editUserAvailabilityHours(Long userId, Availability oldAvailability, Availability newAvailability);

	public void deleteUserAvailabilityHours(long userId, Availability availabilityToDelete, String reason);

	public List<User> listOfAvailableUsersInSimilarAvailableHours(long userId);

}
